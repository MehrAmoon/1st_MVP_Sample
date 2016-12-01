package com.parham.mamoon.learnings.model;

import com.parham.mamoon.learnings.R;

import java.util.ArrayList;

/**
 * Created by m.amoon on 11/22/2016.
 */

public class products {
    private String cost, discount, image;
    private Boolean favorite;
    private ArrayList<String> data = new ArrayList<String>();
    private ArrayList<Integer> slideShowPic = new ArrayList<Integer>();
    private ArrayList<Integer> CategoryPic = new ArrayList<Integer>();

    public products() {
    }

    public ArrayList<Integer> getSlideShowPic() {

        ArrayList<Integer> slideShowPic = new ArrayList<Integer>();
        slideShowPic.add(R.drawable.banner1);
        slideShowPic.add(R.drawable.banner2);
        slideShowPic.add(R.drawable.banner3);
        return slideShowPic;
    }

    public ArrayList<Integer> getCategoryPic() {

        ArrayList<Integer> categoryPic = new ArrayList<Integer>();
        categoryPic.add(R.drawable.slideshow1);
        categoryPic.add(R.drawable.slideshow2);
        categoryPic.add(R.drawable.slideshow3);
        categoryPic.add(R.drawable.slideshow4);
        categoryPic.add(R.drawable.slideshow5);
        categoryPic.add(R.drawable.slideshow6);
        return categoryPic;
    }

    public ArrayList<String> getData() {
        ArrayList<String> listData = new ArrayList<String>();
        listData.add("https://api.touchmart.ir/api/photo/d0db14fb6c364feeac76aeefbd4fc832" +
                ".jpeg?size=s");
        listData.add("https://3.bp.blogspot" +
                ".com/-W__wiaHUjwI/Vt3Grd8df0I/AAAAAAAAA78/7xqUNj8ujtY/s1600/image02.png");
        listData.add("https://s-media-cache-ak0.pinimg" +
                ".com/236x/e3/9c/e7/e39ce781d0af88486fc0cb625af2f83f.jpg");
        listData.add("https://3.bp.blogspot" +
                ".com/-W__wiaHUjwI/Vt3Grd8df0I/AAAAAAAAA78/7xqUNj8ujtY/s1600/image02.png");
        listData.add("https://s-media-cache-ak0.pinimg" +
                ".com/236x/e3/9c/e7/e39ce781d0af88486fc0cb625af2f83f.jpg");
        return listData;
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
}
