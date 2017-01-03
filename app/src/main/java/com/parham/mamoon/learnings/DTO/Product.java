package com.parham.mamoon.learnings.DTO;

public class Product {
    private String cost, discount, image;
    private Boolean favorite;
    private String data;
    private Integer slideShowPic;
    private Integer CategoryPic;

    public void Product(){

    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getSlideShowPic() {
        return slideShowPic;
    }

    public void setSlideShowPic(Integer slideShowPic) {
        this.slideShowPic = slideShowPic;
    }

    public Integer getCategoryPic() {
        return CategoryPic;
    }

    public void setCategoryPic(Integer categoryPic) {
        CategoryPic = categoryPic;
    }
}
