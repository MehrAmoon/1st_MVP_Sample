package com.parham.mamoon.learnings.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.Display;

import com.parham.mamoon.learnings.model.ImageViewParams;
import com.parham.mamoon.learnings.model.animations;
import com.parham.mamoon.learnings.model.products;
import com.parham.mamoon.learnings.view.MainView;

import java.util.ArrayList;

/**
 * Created by m.amoon on 11/22/2016.
 */


public class MainPresenterImpl implements MainPresenter {
    products product;
    animations Animations;
    private MainView mainView;
    ArrayList<Integer> choice;
    ImageViewParams imageViewParams;
    Context context;

    public void clickGridItem(products item) {
    }

    public void loadGridView() {
    }

    @Override
    public void setView(MainView mainView) {
        this.mainView = mainView;

    }

    public ArrayList<Integer> loadSlideShow() {
        product = new products();
        getRandomNumbers(product.getSlideShowPic());
        return choice;
    }


    public ArrayList<Integer> loadMidleCat() {
        product = new products();
        getRandomNumbers(product.getCategoryPic());
        return choice;
    }

    public ArrayList<Integer> getRandomNumbers(ArrayList<Integer> want) {
        choice = new ArrayList<Integer>();
        ArrayList<Integer> rand;
        rand = want;
        for (int i = 0; i < rand.size(); i++) {
            int pic = (int) (Math.random() * rand.size());
            choice.add(Integer.valueOf(rand.get(pic)));
        }
        return choice;
    }

    public ImageViewParams setMiddleCatImageviewParams() {
        imageViewParams = new ImageViewParams();

//        Display display = ((Activity) context).getWindowManager().getDefaultDisplay();
//        int width = display.getWidth();
//        int height = display.getHeight();

        imageViewParams.setGravity("Gravity.RIGHT");
        imageViewParams.setLeft_margin(30);
        imageViewParams.setTop_margin(0);
        imageViewParams.setRight_margin(30);
        imageViewParams.setBottom_margin(0);
        imageViewParams.setWidth(150);
        imageViewParams.setHeight(150);
        return imageViewParams;
    }

    public ArrayList<String> loadGridData() {
        product = new products();
        final ArrayList<String> sampleData = product.getData();
        return sampleData;
    }

    public animations getAnimData() {
        Animations = new animations();
        Animations.setSetDuration(500);
        Animations.setFirstalpha(0f);
        Animations.setSecondAlpha(1f);
        Animations.setDelay(2000);
        return Animations;
    }
}
