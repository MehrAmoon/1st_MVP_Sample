package com.parham.mamoon.learnings.view;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.etsy.android.grid.StaggeredGridView;
import com.parham.mamoon.learnings.DTO.Product;
import com.parham.mamoon.learnings.R;
import com.parham.mamoon.learnings.presenter.MainPresenter;
import com.parham.mamoon.learnings.view.utils.Adaptor;
import com.parham.mamoon.learnings.view.utils.Animations;
import com.parham.mamoon.learnings.view.utils.ImageViewParams;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by m.amoon on 11/30/2016.
 */

public class MainViewImpl extends Fragment implements MainView, AbsListView
        .OnItemClickListener,
        AbsListView.OnScrollListener {

    private MainPresenter mainPresenter;
    private View rootView;
    private StaggeredGridView gridView;

    @SuppressLint("ValidFragment")
    public MainViewImpl(MainPresenter mainpresenter) {
        this.mainPresenter = mainpresenter;
        mainPresenter.setView(this);
    }

    public MainViewImpl() {

    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle
            savedInstanceState) {
        rootView = layoutInflater.inflate(R.layout.fragment_main, container, false);
        mainPresenter.getData();
        showProgress();
        return rootView;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        /// TODO: 12/3/2016 This should be handled in the presenter. See the onScroll method above.
        Toast.makeText(getActivity(), getResources().getString(R.string.gridItemClicked) + i,
                Toast.LENGTH_SHORT).show();

        mainPresenter.itemClick((Product)adapterView.getAdapter().getItem(i));
    }

    @Override
    public void waiteForData() {
        /*
        may View want to show progress or
        do some thing else till data come back
         */

        showProgress();

    }

    @Override
    public void showMessage(String messageText) {

        Toast.makeText(getActivity(), messageText, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void finishWaiteForData() {

        hideProgress();
    }

    @Override
    public void renderView(ArrayList<Product> products) {
        initGridView(products);
        ShowMiddleCat(products);
    }

    @Override
    public void renderSlides(ArrayList<Integer> slideImagesResources) {
        showSlideShow(slideImagesResources);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int
            totalItemCount) {

    }

    public void initGridView(ArrayList<Product> products) {

        gridView = (StaggeredGridView) rootView.findViewById(R.id.gridview);
        Adaptor adaptor = new Adaptor(getActivity(), android.R.layout.simple_list_item_1, products);
        gridView.setAdapter(adaptor);
        gridView.setOnScrollListener(this);
        gridView.setOnItemClickListener(this);
    }

    public void showProgress() {
        /* you can show some progress here
         */
    }

    public void hideProgress() {

    }

    public void showSlideShow(ArrayList<Integer> slideImageList) {
        final ImageView slideShow = (ImageView) rootView.findViewById(R.id.slideShow);
        final ArrayList<Integer> picList = slideImageList;

        slideShow.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < picList.size(); i++) {
                    slideShow.setBackgroundResource(Integer.valueOf(picList.get(i)));
                    Animations animData = getAnimData();
                    slideShow.animate().alpha(animData.getFirstAlpha()).setDuration(animData
                            .getDuration());
                    slideShow.animate().alpha(animData.getSecondAlpha()).setDuration(animData
                            .getDuration());
                }
            }
        }, getAnimData().getDelay());

    }

    public void ShowMiddleCat(ArrayList<Product> productList) {

        LinearLayout RandomCat = (LinearLayout) rootView.findViewById(R.id.RandomCat);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams
                .MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.RIGHT;
//        params.setMargins(16, 16, 16, 16);

        for (int i = 0; i < productList.size() - 1; i++) {
            final int clickedItem = i + 1;
            ImageView slideImage = new ImageView(getActivity());
            slideImage.setLayoutParams(params);
            slideImage.setBackgroundResource(productList.get(i).getSlideShowPic());
            slideImage.setAdjustViewBounds(true);
            RandomCat.addView(slideImage);
            slideImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), getResources().getString(R.string.catSelected)
                            + clickedItem, Toast
                            .LENGTH_SHORT).show();
                }
            });
        }
    }

    public ImageViewParams getMiddleCatImageviewParams() {
        ImageViewParams imageViewParams = new ImageViewParams();
        imageViewParams.setGravity("Gravity.RIGHT");
        imageViewParams.setLeft_margin(30);
        imageViewParams.setTop_margin(0);
        imageViewParams.setRight_margin(30);
        imageViewParams.setBottom_margin(0);
        imageViewParams.setWidth(150);
        imageViewParams.setHeight(150);
        return imageViewParams;
    }

    public Animations getAnimData() {
        Animations Animations = new Animations();
        Animations.setDuration(500);
        Animations.setFirstAlpha(0f);
        Animations.setSecondAlpha(1f);
        Animations.setDelay(2000);
        return Animations;
    }


}
