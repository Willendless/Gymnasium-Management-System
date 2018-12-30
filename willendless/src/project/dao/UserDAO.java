/**
 * curd方法
 * get：通过id号、通过用户名、通过用户名和密码
 * isExist: 判断用户名是否存在
 */


package project.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project.bean.User;
import project.util.DBUtil;

public class UserDAO {
    //总用户个数
    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select count(*) from User";

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

    public void add(User bean) {

        String sql = "insert into user values(null, ?, ?, ?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setString(1, bean.getName());
            ps.setString(2, bean.getPassword());
            ps.setString(3, bean.getEmail());

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

    public void update(User bean) {

        String sql = "update user set name= ? ,password = ?, email = ? where id = ? ";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setString(1, bean.getName());
            ps.setString(2, bean.getPassword());
            ps.setString(3, bean.getEmail());
            ps.setInt(4, bean.getId());

            ps.execute();
            c.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void delete(int id) {

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "delete from User where id = " + id;

            s.execute(sql);
            c.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }


    public User get(int id) {
        User bean = null;

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select * from User where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                bean = new User();
                bean.setId(id);
                bean.setName(rs.getString("name"));
                bean.setPassword(rs.getString("password"));
                bean.setEmail(rs.getString("email"));

            }
            c.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }

    //列出所有用户，从start（id号）开始
    public List<User> list() {
        return list(0, Short.MAX_VALUE);
    }

    public List<User> list(int start, int count) {
        List<User> beans = new ArrayList<User>();

        String sql = "select * from User order by id desc limit ?,? ";

        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User bean = new User();
                bean.setId(rs.getInt("id"));
                bean.setName(rs.getString("name"));
                bean.setPassword(rs.getString("password"));
                bean.setEmail(rs.getString("email"));


                beans.add(bean);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return beans;
    }

    public boolean isExist(String name) {
        User user = get(name);
        return user!=null;

    }

    public User get(String name) {
        User bean = null;

        String sql = "select * from User where name = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, name);
            ResultSet rs =ps.executeQuery();

            if (rs.next()) {
                bean = new User();
                bean.setId(rs.getInt("id"));
                bean.setName(rs.getString("name"));
                bean.setPassword(rs.getString("password"));
                bean.setEmail(rs.getString("email"));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }

    public User get(String name, String password) {
        User bean = null;

        String sql = "select * from User where name = ? and password=?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();

            if (rs.next()) {
                bean = new User();
                bean.setId(rs.getInt("id"));
                bean.setName(rs.getString("name"));
                bean.setPassword(rs.getString("password"));
                bean.setEmail(rs.getString("email"));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }

}

