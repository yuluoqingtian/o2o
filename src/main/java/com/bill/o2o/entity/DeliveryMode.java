package com.bill.o2o.entity;

import java.io.Serializable;

public class DeliveryMode implements Serializable {
   private Long DeliveryModeId;
   private String ModeColor;
   private Integer isSolid;
   private String ModeText;


    public Long getDeliveryModeId() {
        return DeliveryModeId;
    }

    public void setDeliveryModeId(Long deliveryModeId) {
        DeliveryModeId = deliveryModeId;
    }

    public String getModeColor() {
        return ModeColor;
    }

    public void setModeColor(String modeColor) {
        ModeColor = modeColor;
    }

    public Integer getIsSolid() {
        return isSolid;
    }

    public void setIsSolid(Integer isSolid) {
        this.isSolid = isSolid;
    }

    public String getModeText() {
        return ModeText;
    }

    public void setModeText(String modeText) {
        ModeText = modeText;
    }

    @Override
    public String toString() {
        return "DeliveryMode{" +
                "DeliveryModeId=" + DeliveryModeId +
                ", ModeColor='" + ModeColor + '\'' +
                ", isSolid=" + isSolid +
                ", ModeText='" + ModeText + '\'' +
                '}';
    }
}
