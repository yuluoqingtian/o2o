package com.bill.o2o.entity;

import java.io.Serializable;

public class Support implements Serializable {
    private Long supportId;
    private String supportIconColor;
    private String supportIconName;
    private String supportDescription;
    private String supportName;
    private String id;

    @Override
    public String toString() {
        return "Support{" +
                "supportId=" + supportId +
                ", supportIconColor='" + supportIconColor + '\'' +
                ", supportIconName='" + supportIconName + '\'' +
                ", supportDescription='" + supportDescription + '\'' +
                ", supportName='" + supportName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public Long getSupportId() {
        return supportId;
    }

    public void setSupportId(Long supportId) {
        this.supportId = supportId;
    }

    public String getSupportIconColor() {
        return supportIconColor;
    }

    public void setSupportIconColor(String supportIconColor) {
        this.supportIconColor = supportIconColor;
    }

    public String getSupportIconName() {
        return supportIconName;
    }

    public void setSupportIconName(String supportIconName) {
        this.supportIconName = supportIconName;
    }

    public String getSupportDescription() {
        return supportDescription;
    }

    public void setSupportDescription(String supportDescription) {
        this.supportDescription = supportDescription;
    }

    public String getSupportName() {
        return supportName;
    }

    public void setSupportName(String supportName) {
        this.supportName = supportName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
