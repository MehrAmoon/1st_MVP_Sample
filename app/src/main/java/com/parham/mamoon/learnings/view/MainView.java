package com.parham.mamoon.learnings.view;

import com.parham.mamoon.learnings.model.Products;

/**
 * Created by m.amoon on 11/22/2016.
 */

public interface MainView {
    void showSlideShow();
    void ShowMiddleCat();
    void initGridView();

    void ShowGridClickedMessage(Products pro);
    void ShowErrors();
    void showProgress();
    void hideProgress();

    void ShowGridClicked(Products item);

}
