package com.doubleclick.marklocation;

import java.util.Objects;

/**
 * Created By Eslam Ghazy on 9/30/2022
 */
public class Location {

    private String name;
    private String lat;
    private String lag;
    private String phone;
    private String address;
    private String id;


    public Location() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLag() {
        return lag;
    }

    public void setLag(String lag) {
        this.lag = lag;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return getId().equals(location.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", lat='" + lat + '\'' +
                ", lag='" + lag + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
