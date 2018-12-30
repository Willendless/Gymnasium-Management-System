//TODO

package project.dao;

import project.bean.PlaceStadium;
import project.bean.StadiumPlan;
import project.util.DBUtil;

import javax.sql.rowset.serial.SerialException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StadiumPlanDAO {
    public void getTotal() {}

    public StadiumPlan get(int id) {
        StadiumPlan stadiumPlan = null;
        String sql = "select * from stadiumPlan where id=" + id;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                stadiumPlan = new StadiumPlan();
                stadiumPlan.setIndex(rs.getInt("inode"));
                stadiumPlan.setId(id);
                stadiumPlan.setDate(rs.getDate("date"));
                stadiumPlan.setPlaceStadium(new PlaceStadiumDAO().get(rs.getInt("psid")));
                stadiumPlan.setStadiumPlanItemList(new StadiumPlanItemDAO().list(id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stadiumPlan;
    }


    public void add(StadiumPlan bean) {
        String sql = "insert into stadiumPlan values(null, ?, ?, ?);";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            //添加语句
            ps.setInt(1, bean.getIndex());
            ps.setDate(2, bean.getDate());
            ps.setInt(3, bean.getPlaceStadium().getId());
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

    //根据场地id和日期获得所有场的安排表,若不存在则新建一个
    public List<StadiumPlan> search(int psid, java.sql.Date date) {
        PlaceStadium placeStadium = new PlaceStadiumDAO().get(psid);
        List<StadiumPlan> stadiumPlanList = new ArrayList<>();

        for (int i = 0;i < placeStadium.getNum(); i++) {
            //初始化
            StadiumPlan stadiumPlan = new StadiumPlan();
            stadiumPlan.setIndex(i);
            stadiumPlan.setDate(date);
            stadiumPlan.setPlaceStadium(placeStadium);

            String sql = "select * from stadiumPlan where psid=? and date=? and inode=?";
            try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
                ps.setInt(1, psid);
                ps.setDate(2, date);
                ps.setInt(3, i);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    int id = rs.getInt("id");
                    stadiumPlan.setId(id);
                    stadiumPlan.setStadiumPlanItemList(new StadiumPlanItemDAO().list(id));
                } else {
                    add(stadiumPlan);
                    stadiumPlan.setStadiumPlanItemList(new StadiumPlanItemDAO().list(stadiumPlan.getId()));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stadiumPlanList.add(stadiumPlan);
        }
        return stadiumPlanList;
    }

    public void fill(PlaceStadium placeStadium) {

    }

}
