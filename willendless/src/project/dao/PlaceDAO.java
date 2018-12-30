/**
 * curd
 * list():返回所有场馆的列表
 */

package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import project.bean.Place;
import project.bean.PlaceImage;
import project.util.DBUtil;
import project.util.DateUtil;

public class PlaceDAO {

    //获取场馆个数
    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select count(*) from Place";

            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return total;
    }

    public void add(Place bean) {

        String sql = "insert into place values(null, ?, ?, ?, ?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setString(1, bean.getName());
            ps.setString(2, bean.getEname());
            ps.setString(3, bean.getLocation());
            ps.setString(4, bean.getIntroduction());
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

    public void update(Place bean) {

        String sql = "update Place set name=?, ename=?, location=?, introduction=?  where id = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setString(1, bean.getName());
            ps.setString(2, bean.getEname());
            ps.setString(3, bean.getLocation());
            ps.setString(4, bean.getIntroduction());
            ps.setInt(5, bean.getId());
            ps.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void delete(int id) {

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "delete from Place where id = " + id;

            s.execute(sql);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public Place get(int id) {
        Place bean = new Place();

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select * from Place where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {

                bean.setName(rs.getString("name"));
                bean.setEname(rs.getString("ename"));
                bean.setLocation(rs.getString("location"));
                bean.setIntroduction(rs.getString("introduction"));
                bean.setId(id);
            }
            s.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }

    public List<Place> list() {
        return list(0, Short.MAX_VALUE);
    }

    public List<Place> list(int start, int count) {
        List<Place> beans = new ArrayList<>();

        String sql = "select * from Place order by id limit ?, ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Place bean = new Place();
                bean.setId(rs.getInt(1));
                bean.setName(rs.getString(2));
                bean.setEname(rs.getString("ename"));
                bean.setLocation(rs.getString("location"));
                bean.setIntroduction(rs.getString("introduction"));
                beans.add(bean);
            }
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return beans;
    }

}
