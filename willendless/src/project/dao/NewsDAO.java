package project.dao;

import project.bean.News;
import project.util.DBUtil;
import project.util.DateUtil;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class NewsDAO {
    private final static String A="yyyy-MM-dd";//日期格式
    private final static String B="yyyy-MM-dd HH:mm:ss";//日期格式
    private final static String C="yyyy/MM/dd HH:mm:ss";//日期格式
    private final static String D="yyyy年MM月dd日";
    private final static SimpleDateFormat fmtA = new SimpleDateFormat(A);
    private final static SimpleDateFormat fmtB = new SimpleDateFormat(B);
    private final static SimpleDateFormat fmtC = new SimpleDateFormat(C);
    private final static SimpleDateFormat fmtD = new SimpleDateFormat(D);

    //总用户个数
    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select count(*) from News";

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

    public void add(News bean) {

        String sql = "insert into News values(null, ?, ?, ?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setTimestamp(1, DateUtil.d2t(bean.getTime()));
            ps.setString(2, bean.getTitle());
            ps.setString(3, bean.getContent());

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

    public void update(News bean) {

        String sql = "update News set title=?, content=? where id = ? ";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setString(1, bean.getTitle());
            ps.setString(2, bean.getContent());
            ps.setInt(3, bean.getId());

            ps.execute();
            c.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void delete(int id) {

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "delete from News where id = " + id;

            s.execute(sql);
            c.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }


    public News get(int id) {
        News bean = null;

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select * from News where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                bean = new News();
                bean.setId(id);
                bean.setTime(DateUtil.t2d(rs.getTimestamp("time")));
                bean.setTitle(rs.getString("title"));
                bean.setContent(rs.getString("content"));
                bean.setTIME(fmtD.format(bean.getTime()));
                bean.setTIMEX(fmtB.format(bean.getTime()));
            }
            c.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }

    //列出所有用户，从start（id号）开始
    public List<News> list() {
        return list(0, Short.MAX_VALUE);
    }

    public List<News> list(int start, int count) {
        List<News> beans = new ArrayList<News>();

        String sql = "select * from News order by id desc limit ?,? ";

        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                News bean = new News();
                bean.setId(rs.getInt("id"));
                bean.setTime(DateUtil.t2d(rs.getTimestamp("time")));
                bean.setTitle(rs.getString("title"));
                bean.setContent(rs.getString("content"));
                bean.setTIME(fmtD.format(bean.getTime()));
                bean.setTIMEX(fmtB.format(bean.getTime()));
                beans.add(bean);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return beans;
    }

}
