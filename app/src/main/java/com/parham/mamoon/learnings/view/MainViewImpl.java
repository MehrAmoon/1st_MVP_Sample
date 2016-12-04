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
import com.parham.mamoon.learnings.R;
import com.parham.mamoon.learnings.model.Products;
import com.parham.mamoon.learnings.presenter.Animations;
import com.parham.mamoon.learnings.presenter.MainPresenter;

import java.util.ArrayList;

/**
 * Created by m.amoon on 11/30/2016.
 */

public class MainViewImpl extends Fragment implements MainView, AbsListView
        .OnItemClickListener,
        AbsListView.OnScrollListener {

    private MainPresenter mainPresenter;
    private View rootView;
    private StaggeredGridView gridView;
//    private boolean HasRequestMore;

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
        initGridView();
        showSlideShow();
        ShowMiddleCat();
        return rootView;
    }


    public void initGridView() {
        /* adaptor is internal to the gridview, so it had better be defined here instead of being accessible in the whole class. */
        gridView = (StaggeredGridView) rootView.findViewById(R.id.gridview);
        /* mainPresenter.getGridDataAsList() has been used twice here, so it's better to make a field for it first */
//        com.parham.mamoon.learnings.presenter.Adaptor adaptor = new Adaptor(getActivity(), android.R.layout.simple_list_item_1, arrayList);
        com.parham.mamoon.learnings.presenter.Adaptor adaptor = mainPresenter.getGridAdaptor(getActivity());
//        Iterator<String> data = arrayList.iterator();
//        adaptor.add(data.next());
        gridView.setAdapter(adaptor);
        gridView.setOnScrollListener(this);
        gridView.setOnItemClickListener(this);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showSlideShow() {
        final ImageView slideShow = (ImageView) rootView.findViewById(R.id.slideShow);
        final ArrayList<Integer> picList = mainPresenter.getPicArrayList();

        slideShow.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < picList.size(); i++) {
                    slideShow.setBackgroundResource(Integer.valueOf(picList.get(i)));
                    Animations animData = mainPresenter.getAnimData();
                    slideShow.animate().alpha(animData.getFirstAlpha()).setDuration(animData.getDuration());
                    slideShow.animate().alpha(animData.getSecondAlpha()).setDuration(animData.getDuration());
                }
            }
        }, mainPresenter.getAnimData().getDelay());

    }


    @Override
    public void ShowMiddleCat() {
        mainPresenter.getCategoryArrayList();
        mainPresenter.getMiddleCatImageviewParams();
        LinearLayout RandomCat = (LinearLayout) rootView.findViewById(R.id.RandomCat);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(mainPresenter
                .getMiddleCatImageviewParams().getHeight(), mainPresenter
                .getMiddleCatImageviewParams().getWidth());
        params.gravity = Gravity.RIGHT;
        params.setMargins(mainPresenter.getMiddleCatImageviewParams().getLeft_margin(),
                mainPresenter.getMiddleCatImageviewParams().getTop_margin(), mainPresenter
                        .getMiddleCatImageviewParams().getRight_margin(), mainPresenter
                        .getMiddleCatImageviewParams().getBottom_margin());

        for (int i = 0; i < mainPresenter.getCategoryArrayList().size(); i++) {
            final int clickedItem = i + 1;
            ImageView slideImage = new ImageView(getActivity());
            slideImage.setLayoutParams(params);
            slideImage.setBackgroundResource(Integer.valueOf(mainPresenter.getCategoryArrayList().get(i)));
            slideImage.setAdjustViewBounds(true);
            RandomCat.addView(slideImage);
            slideImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), getResources().getString(R.string.catSelected) + clickedItem, Toast
                            .LENGTH_SHORT).show();
                }
            });
        }
    }

    public void ShowGridData() {

    }

    @Override
    public void ShowGridClickedMessage(Products pro) {
//        Toast.makeText(getActivity(), R.string.gridItemClicked + pro.getCost(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ShowGridClicked(Products item) {
//        mainPresenter.clickGridItem(item);
    }

    @Override
    public void ShowErrors() {
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {
        mainPresenter.doWhenScrollStateIsChanged(absListView, i);
    }

    @Override
    public void onScroll(AbsListView absListView, int firstVis, int visibles, int total) {
        mainPresenter.doOnScroll(getActivity(), absListView, firstVis, visibles, total);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        /// TODO: 12/3/2016 This should be handled in the presenter. See the onScroll method above.
        Toast.makeText(getActivity(), getResources().getString(R.string.gridItemClicked) + i, Toast.LENGTH_SHORT).show();
    }

}
