package project.dao;

import project.bean.*;
import project.util.DBUtil;
import project.util.DateUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReserveDAO {

    public int  getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "select count(*) from Reserve ";

            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    public void add(Reserve bean) {
        String sql = "insert into Reserve values(null, ?, ?, ?, ?, ?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setTimestamp(1, DateUtil.d2t(bean.getTime()));
            ps.setString(2, bean.getName());
            ps.setInt(3, bean.getFare());
            ps.setString(4, bean.getStatus());
            ps.setInt(5, bean.getUser().getId());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                bean.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*public void update(Reserve bean) {
        String sql = "update Reserve set begtime=?, endtime=?, status=?, sid=?, uid=?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setTime(1, bean.getBegtime());
            ps.setTime(2, bean.getEndtime());
            ps.setString(3, bean.getStatus());
            ps.setInt(4, bean.getPlaceStadium().getId());
            ps.setInt(5, bean.getUser().getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    public void edit(int id, String status) {
        String sql = "update Reserve set status=? where id=?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //订单取消:包括取消订单项
    public void delete(int id) {
        Reserve reserve = new Reserve();
        reserve.setId(id);
        new ReserveItemDAO().fill(reserve);

        for (int i = 0; i < reserve.getReserveItemList().size(); i++) {
            new ReserveItemDAO().delete(reserve.getReserveItemList().get(i).getId());
        }

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "delete from Reserve where id =" + id;
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //根据id获取订单
    /*public Reserve get(int id) {
        Reserve bean = new Reserve();
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "select * from Reserve where id =" + id;
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                java.sql.Time begtime = rs.getTime("begtime");
                java.sql.Time endtime = rs.getTime("endtime");
                String status = rs.getString("status");
                int sid = rs.getInt("sid");
                int uid = rs.getInt("uid");
                bean.setId(id);
                bean.setBegtime(begtime);
                bean.setEndtime(endtime);
                bean.setStatus(status);
                bean.setPlaceStadium(new PlaceStadiumDAO().get(sid));
                bean.setUser(new UserDAO().get(uid));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bean;
    }*/

    //列出所有订单
    public List<Reserve> list() {
        return list(0, Short.MAX_VALUE);
    }

    public List<Reserve> list(int start, int count) {
        List<Reserve> beans = new ArrayList<>();

        String sql = "select * from reserve order by id limit ?, ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reserve bean = new Reserve();
                bean.setId(rs.getInt("id"));
                bean.setTime(DateUtil.t2d(rs.getTimestamp("time")));
                bean.setName(rs.getString("name"));
                bean.setFare(rs.getInt("fare"));
                bean.setStatus(rs.getString("status"));
                bean.setUser(new UserDAO().get(rs.getInt("uid")));

                beans.add(bean);
            }
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return beans;
    }

    //列出同一个用户所有预约项
    public List<Reserve> list(int uid) {
        return list(uid, 0, Short.MAX_VALUE);
    }
    public List<Reserve> list(int uid, int start, int count) {
        List<Reserve> beans = new ArrayList<>();

        String sql = "select * from Reserve where uid=? order by id desc limit ?, ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, uid);
            ps.setInt(2, start);
            ps.setInt(3, count);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Reserve bean = new Reserve();
                bean.setId(rs.getInt("id"));
                bean.setTime(DateUtil.t2d(rs.getTimestamp("time")));
                bean.setName(rs.getString("name"));
                bean.setFare(rs.getInt("fare"));
                bean.setStatus(rs.getString("status"));
                bean.setUser(new UserDAO().get(rs.getInt("uid")));

                beans.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return beans;
    }
}
