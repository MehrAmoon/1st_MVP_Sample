package com.parham.mamoon.learnings.presenter;

import android.app.Activity;
import android.widget.AbsListView;

import com.parham.mamoon.learnings.view.MainView;

import java.util.ArrayList;

/**
 * Created by m.amoon on 11/29/2016.
 */

public interface MainPresenter {
    Adaptor getGridAdaptor(Activity activity);

    ArrayList<Integer> getPicArrayList();

    ArrayList<Integer> getCategoryArrayList();

    ImageViewParams getMiddleCatImageviewParams();

//    boolean isHasRequestMore();
//
//    void setHasRequestMore(boolean hasRequestMore);

    void setView(MainView mainView);

//    ArrayList<String> getGridDataAsList();

    Animations getAnimData();

    void doWhenScrollStateIsChanged(AbsListView absListView, int i);

    void doOnScroll(Activity activity, AbsListView absListView, int firstVis, int visibles, int
            total);
}
