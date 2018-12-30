package project.dao;

import project.bean.PlaceStadium;
import project.bean.Reserve;
import project.bean.StadiumPlan;
import project.bean.StadiumPlanItem;
import project.util.DBUtil;
import sun.security.pkcs11.Secmod;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StadiumPlanItemDAO {
    private static final java.sql.Time[] time = new java.sql.Time[]{
            new Time(8,0,0),
            new Time(9,0,0),
            new Time(10,0,0),
            new Time(11,0,0),
            new Time(12,0,0),
            new Time(13,0,0),
            new Time(14,0,0),
            new Time(15,0,0),
            new Time(16,0,0),
            new Time(17,0,0),
            new Time(18,0,0),
            new Time(19,0,0),
            new Time(20,0,0),
            new Time(21,0,0),
            new Time(22,0,0)
    };

    public void getTotal() {}

    public void add(StadiumPlanItem bean) {
        String sql = "insert into stadiumPlanItem values(null, ?, ?, ?, ?, ?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setTime(1, bean.getBeg());
            ps.setTime(2, bean.getEnd());
            ps.setInt(3, bean.getIndex());
            ps.setString(4, bean.getStatus());
            ps.setInt(5, bean.getStadiumPlanId());
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

    public StadiumPlanItem get(int id) {
        StadiumPlanItem bean = null;

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select * from stadiumPlanItem where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                bean = new StadiumPlanItem();
                bean.setId(id);
                bean.setBeg(rs.getTime("beg"));
                bean.setEnd(rs.getTime("end"));
                bean.setIndex(rs.getInt("inode"));
                bean.setStadiumPlanId(rs.getInt("spid"));
            }
            c.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }


    //设置安排项状态
    public void edit(int id, String status) {
        String sql = "update stadiumPlanItem set status=? where id=?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, id);
            ps.execute();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }


    //根据场馆场地的安排表号(stadiumPlan id)查找表目项，返回列表
    public List<StadiumPlanItem> list(int spid) {
        List<StadiumPlanItem> beans = new ArrayList<>();
        String sql = "select * from stadiumPlanItem where spid=" + spid + " order by inode";
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            ResultSet rs = s.executeQuery(sql);
            int j = -1;
            if (rs.next())
                j = rs.getInt("inode");
            for (int i = 0; i < 13; i++) {
                StadiumPlanItem stadiumPlanItem = new StadiumPlanItem();
                stadiumPlanItem.setBeg(time[i]);
                stadiumPlanItem.setEnd(time[i + 1]);
                stadiumPlanItem.setStatus("空闲");
                stadiumPlanItem.setIndex(i);
                stadiumPlanItem.setStadiumPlanId(spid);
                if (i == j) {
                    int id = rs.getInt("id");
                    stadiumPlanItem.setId(id);
                    stadiumPlanItem.setStatus(rs.getString("status"));
                    if (rs.next())
                        j = rs.getInt("inode");
                } else {
                    add(stadiumPlanItem);
                }
                beans.add(stadiumPlanItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return beans;
    }



}
