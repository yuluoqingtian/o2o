package com.bill.o2o.entity;



public class Shop {
    private Long shopId;
    private String name;
    private String address;
    private String latitude;
    private String longitude;
    private String phone;
    private Long typeId;
    private Integer status;
    private Integer recentOrderNum;
    private Integer ratingCount;
    private Integer rating;
    private String promotionInfo;
    private String cateringServiceLicenseImage;
    private String openingHours;
    private String piecewiseAgentFee;
    private String businessLicenseImage;
    private Integer isNew;
    private Integer isPremium;
    private String imagePath;
    private Long identificationId;

    @Override
    public String toString() {
        return "Shop{" +
                "shopId=" + shopId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", phone='" + phone + '\'' +
                ", typeId=" + typeId +
                ", status=" + status +
                ", recentOrderNum=" + recentOrderNum +
                ", ratingCount=" + ratingCount +
                ", rating=" + rating +
                ", promotionInfo='" + promotionInfo + '\'' +
                ", cateringServiceLicenseImage='" + cateringServiceLicenseImage + '\'' +
                ", openingHours='" + openingHours + '\'' +
                ", piecewiseAgentFee='" + piecewiseAgentFee + '\'' +
                ", businessLicenseImage='" + businessLicenseImage + '\'' +
                ", isNew=" + isNew +
                ", isPremium=" + isPremium +
                ", imagePath='" + imagePath + '\'' +
                ", identificationId=" + identificationId +
                ", floatDeliveryFee='" + floatDeliveryFee + '\'' +
                ", description='" + description + '\'' +
                ", deliverModeId=" + deliverModeId +
                ", deliverTime='" + deliverTime + '\'' +
                ", score='" + score + '\'' +
                ", foodScore='" + foodScore + '\'' +
                ", ServiceScore='" + ServiceScore + '\'' +
                ", rankRate='" + rankRate + '\'' +
                ", distance=" + distance +
                '}';
    }

    private String floatDeliveryFee;
    private String description;
    private Long deliverModeId;
    private String deliverTime;
    private String score;
    private String foodScore;
    private String ServiceScore;
    private String rankRate;
    private Float distance;


    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRecentOrderNum() {
        return recentOrderNum;
    }

    public void setRecentOrderNum(Integer recentOrderNum) {
        this.recentOrderNum = recentOrderNum;
    }

    public Integer getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getPromotionInfo() {
        return promotionInfo;
    }

    public void setPromotionInfo(String promotionInfo) {
        this.promotionInfo = promotionInfo;
    }

    public String getCateringServiceLicenseImage() {
        return cateringServiceLicenseImage;
    }

    public void setCateringServiceLicenseImage(String cateringServiceLicenseImage) {
        this.cateringServiceLicenseImage = cateringServiceLicenseImage;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getPiecewiseAgentFee() {
        return piecewiseAgentFee;
    }

    public void setPiecewiseAgentFee(String piecewiseAgentFee) {
        this.piecewiseAgentFee = piecewiseAgentFee;
    }

    public String getBusinessLicenseImage() {
        return businessLicenseImage;
    }

    public void setBusinessLicenseImage(String businessLicenseImage) {
        this.businessLicenseImage = businessLicenseImage;
    }

    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    public Integer getIsPremium() {
        return isPremium;
    }

    public void setIsPremium(Integer isPremium) {
        this.isPremium = isPremium;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Long getIdentificationId() {
        return identificationId;
    }

    public void setIdentificationId(Long identificationId) {
        this.identificationId = identificationId;
    }

    public String getFloatDeliveryFee() {
        return floatDeliveryFee;
    }

    public void setFloatDeliveryFee(String floatDeliveryFee) {
        this.floatDeliveryFee = floatDeliveryFee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getDeliverModeId() {
        return deliverModeId;
    }

    public void setDeliverModeId(Long deliverModeId) {
        this.deliverModeId = deliverModeId;
    }

    public String getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(String deliverTime) {
        this.deliverTime = deliverTime;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getFoodScore() {
        return foodScore;
    }

    public void setFoodScore(String foodScore) {
        this.foodScore = foodScore;
    }

    public String getServiceScore() {
        return ServiceScore;
    }

    public void setServiceScore(String serviceScore) {
        ServiceScore = serviceScore;
    }

    public String getRankRate() {
        return rankRate;
    }

    public void setRankRate(String rankRate) {
        this.rankRate = rankRate;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }
}
