package com.bill.o2o.dto;

import com.bill.o2o.entity.*;

import java.util.List;

public class ShopReturnData extends Shop {
   private FoodType shopType;
   private List<Activity> activities;
   private List<Support> supports;
   private DeliveryMode deliveryMode;

    @Override
    public String toString() {
        return  super.toString()+
                "shopType=" + shopType +
                ", activities=" + activities +
                ", supports=" + supports+
                ", deliveryMode=" + deliveryMode
                ;
    }

    public List<Support> getSupports() {
        return supports;
    }

    public void setSupports(List<Support> supports) {
        this.supports = supports;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public FoodType getShopType() {
        return shopType;
    }

    public void setShopType(FoodType shopType) {
        this.shopType = shopType;
    }

    public DeliveryMode getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(DeliveryMode deliveryMode){
        this.deliveryMode = deliveryMode;
    }
}
