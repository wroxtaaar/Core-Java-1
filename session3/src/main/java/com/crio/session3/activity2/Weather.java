package com.crio.session3.activity2;

public class Weather {
    private String title;
    private String location_type;
    private String woeid;
    private String latt_long;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getLocation_type() {
        return location_type;
    }
    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }
    public String getWoeid() {
        return woeid;
    }
    public void setWoeid(String woeid) {
        this.woeid = woeid;
    }
    public String getLatt_long() {
        return latt_long;
    }
    public void setLatt_long(String latt_long) {
        this.latt_long = latt_long;
    }
    @Override
    public String toString() {
        return "Weather [latt_long=" + latt_long + ", location_type=" + location_type + ", title=" + title + ", woeid="
                + woeid + "]";
    }
    
}

