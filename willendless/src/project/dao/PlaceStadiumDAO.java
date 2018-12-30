package project.dao;

import project.bean.Place;
import project.bean.PlaceStadium;
import project.util.DBUtil;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaceStadiumDAO {
    //获取同一场馆场地个数
    public int getTotal(int pid) {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "select count(*) from PlaceStadium where pid =" + pid;

            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);

            }
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    public void add(PlaceStadium bean) {
        String sql = "insert into PlaceStadium values(null, ?, ?, ?, ?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1,bean.getName());
            ps.setInt(2, bean.getNum());
            ps.setInt(3, bean.getFare());
            ps.setInt(4, bean.getPlace().getId());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                bean.setId(id);
            }
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(PlaceStadium bean) {
        String sql = "update PlaceStadium set name=?, num=?, fare=?, pid=? where id =?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, bean.getName());
            ps.setInt(2, bean.getNum());
            ps.setInt(3, bean.getFare());
            ps.setInt(4, bean.getPlace().getId());
            ps.setInt(5, bean.getId());
            ps.execute();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "delete from PlaceStadium where id =" + id;
            s.execute(sql);
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PlaceStadium get(int id) {
        PlaceStadium bean = null;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "select * from PlaceStadium where id =" + id;
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                bean = new PlaceStadium();

                bean.setId(rs.getInt("id"));
                bean.setName(rs.getString("name"));
                bean.setNum(rs.getInt("num"));
                bean.setFare(rs.getInt("fare"));
                bean.setPlace(new PlaceDAO().get(rs.getInt("pid")));
            }
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bean;
    }

    //列出同一场馆所有场地
    public List<PlaceStadium> list(int pid) {
        return list(pid, 0, Short.MAX_VALUE);
    }
    public List<PlaceStadium> list(int pid, int start, int count) {
        List<PlaceStadium> beans = new ArrayList<>();
        Place place = new PlaceDAO().get(pid);

        String sql = "select * from placeStadium where pid=? order by id limit ?, ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, pid);
            ps.setInt(2, start);
            ps.setInt(3, count);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PlaceStadium bean = new PlaceStadium();

                bean.setId(rs.getInt("id"));
                bean.setName(rs.getString("name"));
                bean.setNum(rs.getInt("num"));
                bean.setFare(rs.getInt("fare"));
                bean.setPlace(new PlaceDAO().get(rs.getInt("pid")));
                beans.add(bean);
            }
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return beans;
    }

    public void fill(List<Place> placeList) {
        for (Place p : placeList) {
            p.setPlaceStadium(list(p.getId()));
        }
    }

    public void fill(Place place) {
        place.setPlaceStadium(list(place.getId()));
    }
}

