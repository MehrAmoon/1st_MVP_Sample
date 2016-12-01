package com.parham.mamoon.learnings.presenter;

import com.parham.mamoon.learnings.model.ImageViewParams;
import com.parham.mamoon.learnings.model.animations;
import com.parham.mamoon.learnings.view.MainView;

import java.util.ArrayList;

/**
 * Created by m.amoon on 11/29/2016.
 */

public interface MainPresenter {
    ArrayList<Integer> loadSlideShow();
    ArrayList<Integer> loadMidleCat();
    ImageViewParams setMiddleCatImageviewParams();
    void setView(MainView mainView);
    ArrayList<String> loadGridData();
   animations getAnimData();
}
