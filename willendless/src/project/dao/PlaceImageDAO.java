package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project.bean.Place;
import project.bean.PlaceImage;
import project.util.DBUtil;

public class PlaceImageDAO {
    public static final String type_single = "type_single";
    public static final String type_detail = "type_detail";

    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select count(*) from PlaceImage";

            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return total;
    }

    public void add(PlaceImage bean) {

        String sql = "insert into PlaceImage values(null,?,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, bean.getPlace().getId());
            ps.setString(2, bean.getType());
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

    public void update(PlaceImage bean) {

    }

    public void delete(int id) {

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "delete from PlaceImage where id = " + id;

            s.execute(sql);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public PlaceImage get(int id) {
        PlaceImage bean = new PlaceImage();

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select * from PlaceImage where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                int pid = rs.getInt("pid");
                String type = rs.getString("type");
                Place product = new PlaceDAO().get(pid);
                bean.setPlace(product);
                bean.setType(type);
                bean.setId(id);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }

    public List<PlaceImage> list(Place p, String type) {
        return list(p, type, 0, Short.MAX_VALUE);
    }

    public List<PlaceImage> list(Place p, String type, int start, int count) {
        List<PlaceImage> beans = new ArrayList<PlaceImage>();

        String sql = "select * from PlaceImage where pid =? and type =? order by id desc limit ?,? ";

        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1, p.getId());
            ps.setString(2, type);

            ps.setInt(3, start);
            ps.setInt(4, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                PlaceImage bean = new PlaceImage();
                int id = rs.getInt(1);

                bean.setPlace(p);
                bean.setType(type);
                bean.setId(id);

                beans.add(bean);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return beans;
    }
}
