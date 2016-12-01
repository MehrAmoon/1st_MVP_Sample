package com.parham.mamoon.learnings.view;

import android.view.View;
import android.widget.AdapterView;

import com.parham.mamoon.learnings.model.products;

/**
 * Created by m.amoon on 11/22/2016.
 */

public interface MainView {
    void ShowSlideShow();
    void ShowMiddleCat();
    void initGridView();

    void ShowGridClickedMessage(products pro);
    void ShowErrors();
    void ShowProgress();
    void hideProgress();

    void ShowGridClicked(products item);

}
