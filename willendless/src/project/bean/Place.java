package project.bean;

import java.util.List;

public class Place {
    private int id;
    private String name;
    private String ename;
    private String introduction;
    private String location;
    private List<PlaceImage> placeImages;
    private List<PlaceStadium> placeStadium;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<PlaceImage> getPlaceImages() {
        return placeImages;
    }

    public void setPlaceImages(List<PlaceImage> placeImages) {
        this.placeImages = placeImages;
    }

    public List<PlaceStadium> getPlaceStadium() {
        return placeStadium;
    }

    public void setPlaceStadium(List<PlaceStadium> placeStadium) {
        this.placeStadium = placeStadium;
    }

}
