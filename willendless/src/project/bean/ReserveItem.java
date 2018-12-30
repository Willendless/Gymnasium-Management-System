package project.bean;

public class ReserveItem {
    private int id;
    private String name;
    private StadiumPlanItem stadiumPlanItem;
    private int reserveId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StadiumPlanItem getStadiumPlanItem() {
        return stadiumPlanItem;
    }

    public void setStadiumPlanItem(StadiumPlanItem stadiumPlanItem) {
        this.stadiumPlanItem = stadiumPlanItem;
    }

    public int getReserveId() {
        return reserveId;
    }

    public void setReserveId(int reserveId) {
        this.reserveId = reserveId;
    }
}
