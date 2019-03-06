package com.bill.o2o.dto;

public class SimplePositionReturnData {
    private String address;
    private String city;
    private String geohash;
    private String longitude;
    private String latitude;
    private String name;
    private String cityCode;


    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGeohash() {
        return geohash;
    }

    public void setGeohash(String geohash) {
        this.geohash = geohash;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SimplePositionReturnData{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", geohash='" + geohash + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", name='" + name + '\'' +
                ", cityCode='" + cityCode + '\'' +
                '}';
    }

}
