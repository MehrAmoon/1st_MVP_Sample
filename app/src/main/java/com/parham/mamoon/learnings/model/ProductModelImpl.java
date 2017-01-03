package com.parham.mamoon.learnings.model;

import android.content.Context;
import android.os.Handler;

import com.parham.mamoon.learnings.DTO.Product;
import com.parham.mamoon.learnings.R;

import java.util.ArrayList;

/**
 * Created by m.amoon on 11/22/2016.
 *
 * Mahdi revise: I think your Data structure
 * is had to change and I created a DTO calls Product
 * in public Package and split model to ProductModel and ProductModelImpl.
 */

public class ProductModelImpl implements ProductModel {

    private String[] imageList = {
            "https://api.touchmart.ir/api/photo/d0db14fb6c364feeac76aeefbd4fc832" +
                    ".jpeg?size=s",
            "https://3.bp.blogspot" +
                    ".com/-W__wiaHUjwI/Vt3Grd8df0I/AAAAAAAAA78/7xqUNj8ujtY/s1600/image02.png",
            "https://s-media-cache-ak0.pinimg" +
                    ".com/236x/e3/9c/e7/e39ce781d0af88486fc0cb625af2f83f.jpg",
            "https://3.bp.blogspot" +
                    ".com/-W__wiaHUjwI/Vt3Grd8df0I/AAAAAAAAA78/7xqUNj8ujtY/s1600/image02.png",
            "https://s-media-cache-ak0.pinimg" +
                    ".com/236x/e3/9c/e7/e39ce781d0af88486fc0cb625af2f83f.jpg"
    };

    private int[] pictures = {
            R.drawable.slideshow1,
            R.drawable.slideshow2,
            R.drawable.slideshow3,
            R.drawable.slideshow4,
            R.drawable.slideshow5
    };

    private Context context;

    public ProductModelImpl(Context context) {
        this.context = context;
    }


    @Override
    public void setFavorite(Product product,Boolean favorite) {
        //todo call some service to make this product favorite true or false
    }

    @Override
    public void getProductsFromServer(final DataCallBack callBack) {

        //mock fetch product imageList
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                callBack.onDataFetchSuccessfull(mockDataFromServer());
            }
        }, 500);

    }

    @Override
    public void getBannersFromServer(final BanerDataCallBack callBack) {

        //mock fetch slide imageList
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                callBack.onDataFetchSuccessfull(mockSlideShowDataFromServer());
            }
        }, 500);
    }

    private ArrayList<Integer> mockSlideShowDataFromServer() {

        ArrayList<Integer> slideShowPic = new ArrayList<Integer>();
        slideShowPic.add(R.drawable.banner1);
        slideShowPic.add(R.drawable.banner2);
        slideShowPic.add(R.drawable.banner3);
        return slideShowPic;

    }


    private ArrayList<Product> mockDataFromServer() {

        ArrayList<Product> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Product product = new Product();
            product.setData("data "+i+1);
            product.setImage(imageList[i]);
            product.setSlideShowPic(pictures[i]);
            list.add(product);
        }
        return list;
    }

}
