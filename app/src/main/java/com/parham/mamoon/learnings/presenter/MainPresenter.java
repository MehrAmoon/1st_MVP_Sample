package com.parham.mamoon.learnings.presenter;

import android.app.Activity;
import android.widget.AbsListView;

import com.parham.mamoon.learnings.DTO.Product;
import com.parham.mamoon.learnings.view.MainView;
import com.parham.mamoon.learnings.view.utils.Adaptor;
import com.parham.mamoon.learnings.view.utils.Animations;
import com.parham.mamoon.learnings.view.utils.ImageViewParams;

import java.util.ArrayList;

/**
 * Created by m.amoon on 11/29/2016.
 *
 * Mahdi revise: Presenter is had nothing to do
 * with how view will show data and do not
 * know what is View components. cause one day
 * we will want to change the way app show data
 * and it is not presenter business.
 *
 */


public interface MainPresenter {


    void getData();

    void itemClick(Product product);

    void setView(MainView mainView);


}
