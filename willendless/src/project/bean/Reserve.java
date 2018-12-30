/**
 * 订单实体类：
 *
 */

package project.bean;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Reserve {
    private int id;
    private Date time;
    private String name;
    private int fare;
    private String status;
    private Place place;
    private PlaceStadium placeStadium;
    private User user;
    private List<ReserveItem> reserveItemList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public PlaceStadium getPlaceStadium() {
        return placeStadium;
    }

    public void setPlaceStadium(PlaceStadium placeStadium) {
        this.placeStadium = placeStadium;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ReserveItem> getReserveItemList() {
        return reserveItemList;
    }

    public void setReserveItemList(List<ReserveItem> reserveItemList) {
        this.reserveItemList = reserveItemList;
    }
}
