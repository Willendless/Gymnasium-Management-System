
package project.bean;

import java.util.List;

public class PlaceStadium {
    private int id;
    private String name;
    private int num;
    private int fare;
    private Place place;
    private List<StadiumPlan>[] stadiumPlansLists = new List[3];

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public List<StadiumPlan>[] getStadiumPlansLists() {
        return stadiumPlansLists;
    }

    public void setStadiumPlansLists(List<StadiumPlan>[] stadiumPlansLists) {
        this.stadiumPlansLists = stadiumPlansLists;
    }
}
