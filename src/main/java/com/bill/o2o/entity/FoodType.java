package com.bill.o2o.entity;

//与食物的分类相对应

public class FoodType {
    private Integer typeId;
    private Integer isInServing;
    private String description;
    private String title;
    private String link;
    private String imageUrl;
    private String iconUrl;
    private String titleColor;
    private String _v;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getIsInServing() {
        return isInServing;
    }

    public void setIsInServing(Integer isInServing) {
        this.isInServing = isInServing;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }

    public String get_v() {
        return _v;
    }

    public void set_v(String _v) {
        this._v = _v;
    }

    @Override
    public String toString() {
        return "FoodType{" +
                "typeId=" + typeId +
                ", isInServing=" + isInServing +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", titleColor='" + titleColor + '\'' +
                ", _v='" + _v + '\'' +
                '}';
    }
}
