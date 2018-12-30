//TODO
package project.bean;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class StadiumPlan{
    private int id;
    private int index;      //场地号
    private java.sql.Date date;     //场地记录表的日期
    private PlaceStadium placeStadium;
    private List<StadiumPlanItem> stadiumPlanItemList;   //场地状态,包含所有安排表项

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public PlaceStadium getPlaceStadium() {
        return placeStadium;
    }

    public void setPlaceStadium(PlaceStadium placeStadium) {
        this.placeStadium = placeStadium;
    }

    public Date getDate() { return date; }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<StadiumPlanItem> getStadiumPlanItemList() {
        return stadiumPlanItemList;
    }

    public void setStadiumPlanItemList(List<StadiumPlanItem> stadiumPlanItemList) {
        this.stadiumPlanItemList = stadiumPlanItemList;
    }
}
