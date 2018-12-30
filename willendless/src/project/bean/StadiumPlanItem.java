package project.bean;

import java.sql.Date;
import java.sql.Time;

public class StadiumPlanItem {
    private int id;
    private java.sql.Time beg;
    private java.sql.Time end;
    private int index;      //方便处理
    private String status;
    private int stadiumPlanId;  //修改
    private String name;    //供订单显示时使用


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getBeg() {
        return beg;
    }

    public void setBeg(Time beg) {
        this.beg = beg;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStadiumPlanId() {
        return stadiumPlanId;
    }

    public void setStadiumPlanId(int stadiumPlanId) {
        this.stadiumPlanId = stadiumPlanId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
