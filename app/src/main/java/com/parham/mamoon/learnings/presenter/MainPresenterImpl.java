package com.parham.mamoon.learnings.presenter;

import android.app.Activity;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.Toast;

import com.parham.mamoon.learnings.R;
import com.parham.mamoon.learnings.model.Products;
import com.parham.mamoon.learnings.view.MainView;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by m.amoon on 11/22/2016.
 */


public class MainPresenterImpl implements MainPresenter {
    private String TAG = "M3hrStraggeredGrid";
    private Products products;
    private MainView mainView;
    private boolean hasRequestMore;

//    @Override
//    public boolean isHasRequestMore() {
//        return hasRequestMore;
//    }
//
//    @Override
//    public void setHasRequestMore(boolean hasRequestMore) {
//        this.hasRequestMore = hasRequestMore;
//    }

//    private ArrayList<Integer> choice;
//    private ImageViewParams imageViewParams;
//    Context context;

    /* Product is the core business of the project and the domain model. So its relation with this class is 'has'. */
    public MainPresenterImpl(Products products) {
        this.products = products;
    }

//    public void clickGridItem(Products item) {
//    }

//    public void loadGridView() {
//    }

    @Override
    public void setView(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public Adaptor getGridAdaptor(Activity activity) {
        ArrayList<String> arrayList = getGridDataAsList();
        Adaptor adaptor = new Adaptor(activity, android.R.layout.simple_list_item_1, R.layout.custom_grid_row, arrayList);
        Iterator<String> data = arrayList.iterator();
        adaptor.add(data.next());
        return adaptor;
    }

    @Override
    public ArrayList<Integer> getPicArrayList() {
//        product = new Products();
        return getRandomNumbers(products.getSlideShowPic());
//        return choice;
    }

    @Override
    public ArrayList<Integer> getCategoryArrayList() {
//        product = new Products();
        return getRandomNumbers(products.getCategoryPic());
//        return choice;
    }

    private ArrayList<Integer> getRandomNumbers(ArrayList<Integer> want) {
        ArrayList<Integer> choice = new ArrayList<Integer>();
        ArrayList<Integer> rand;
        rand = want;
        for (int i = 0; i < rand.size(); i++) {
            int pic = (int) (Math.random() * rand.size());
            choice.add(Integer.valueOf(rand.get(pic)));
        }
        return choice;
    }

    @Override
    public ImageViewParams getMiddleCatImageviewParams() {
        ImageViewParams imageViewParams = new ImageViewParams();

//        Display display = ((Activity) context).getWindowManager().getDefaultDisplay();
//        int width = display.getWidth();
//        int height = display.getHeight();

        imageViewParams.setGravity("Gravity.RIGHT");
        /// TODO: 12/3/2016 It would be better to set all margins in a method like setMargins(int left,int right,int top, int bottom) instead of using four setters. This reduces wordiness considerably.
        imageViewParams.setLeft_margin(30);
        imageViewParams.setTop_margin(0);
        imageViewParams.setRight_margin(30);
        imageViewParams.setBottom_margin(0);
        imageViewParams.setWidth(150);
        imageViewParams.setHeight(150);
        return imageViewParams;
    }

    private ArrayList<String> getGridDataAsList() {
        return products.getData();
    }

    @Override
    public Animations getAnimData() {
        Animations Animations = new Animations();
        Animations.setDuration(500);
        Animations.setFirstAlpha(0f);
        Animations.setSecondAlpha(1f);
        Animations.setDelay(2000);
        return Animations;
    }

    @Override
    public void doWhenScrollStateIsChanged(AbsListView absListView, int i) {
        Log.d(TAG, "onScrolled " + i);
    }

    @Override
    public void doOnScroll(Activity activity, AbsListView absListView, int firstVis, int visibles, int total) {
        Log.d(TAG, "onScroll firstVis: " + firstVis + "visisble: " + visibles + "totalGrid : " +
                total);
        if (!hasRequestMore) {
            int lasItem = firstVis + visibles;
            if (lasItem >= total) {
                Log.d(TAG, "LOAD More ... ");
                Toast.makeText(activity, activity.getResources().getString(R.string.loading), Toast.LENGTH_SHORT).show();
                hasRequestMore = true;
                loadMoreItem(activity);

            }
        }
    }

    private void loadMoreItem(Activity activity) {
        Adaptor adaptor = getGridAdaptor(activity);
        adaptor.notifyDataSetChanged();
        hasRequestMore = false;
//        setHasRequestMore(false);
//        final ArrayList<String> sampleData = mainPresenter.getGridDataAsList();
//        for (String data : sampleData) {
//            Adaptor.add(data);
//        }
//        sampleData.addAll(sampleData);
//        Adaptor.notifyDataSetChanged();
//        HasRequestMore = false;


    }
}
