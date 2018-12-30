package project.dao;

import org.omg.CORBA.CODESET_INCOMPATIBLE;
import project.bean.*;
import project.util.DBUtil;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReserveItemDAO {

    //根据实体类新增订单项
    public void add(ReserveItem bean) {
        String sql = "insert into reserveItem values(null, ?, ?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, bean.getStadiumPlanItem().getId());
            ps.setInt(2, bean.getReserveId());
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




    //根据id获取订单项
    public ReserveItem get(int id) {
        ReserveItem bean = null;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "select * from reserveItem where id = " + id;
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                bean = new ReserveItem();
                bean.setId(id);
                bean.setStadiumPlanItem(new StadiumPlanItemDAO().get(rs.getInt("piid")));
                bean.setReserveId(rs.getInt("rid"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bean;
    }



    //根据id删除订单项，并修改安排表项状态
    public void delete(int id) {
        ReserveItem reserveItem = new ReserveItemDAO().get(id);
        new StadiumPlanItemDAO().edit(reserveItem.getStadiumPlanItem().getId(), "空闲");
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {

            String sql = "delete from reserveItem where id=" + id;
            s.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    //填充订单中的订单项列表
    public void fill(Reserve bean) {
        String sql = "select * from reserveitem where rid=" + bean.getId();
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            ResultSet rs = s.executeQuery(sql);
            List<ReserveItem> reserveItemList = new ArrayList<>();
            while (rs.next()) {
                ReserveItem reserveItem = new ReserveItem();
                reserveItem.setId(rs.getInt("id"));
                reserveItem.setStadiumPlanItem(new StadiumPlanItemDAO().get(rs.getInt("piid")));


                StadiumPlanItem stadiumPlanItem = reserveItem.getStadiumPlanItem();

                //处理名字
                StadiumPlan stadiumPlan = new StadiumPlanDAO().get(stadiumPlanItem.getStadiumPlanId());
                int index = stadiumPlan.getIndex() + 1;
                PlaceStadium placeStadium = stadiumPlan.getPlaceStadium();
                Place place = placeStadium.getPlace();
                stadiumPlanItem.setName(place.getName()+placeStadium.getName()+index);

                reserveItemList.add(reserveItem);
            }
            bean.setReserveItemList(reserveItemList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
