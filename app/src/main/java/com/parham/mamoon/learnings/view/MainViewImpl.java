package com.parham.mamoon.learnings.view;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
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
import com.parham.mamoon.learnings.model.ImageViewParams;
import com.parham.mamoon.learnings.model.products;
import com.parham.mamoon.learnings.presenter.MainPresenter;
import com.parham.mamoon.learnings.presenter.adaptor;

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
    private adaptor Adaptor;

    private String TAG = "M3hrStraggeredGrid";
    private boolean HasRequestMore;

    public MainViewImpl(MainPresenter mainpresenter) {
        this.mainPresenter = mainpresenter;
        mainPresenter.setView(this);
    }



    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle
            savedInstanceState) {
        rootView = layoutInflater.inflate(R.layout.fragment_main, container, false);
        initGridView();
        ShowSlideShow();
        ShowMiddleCat();
        return rootView;
    }


    public void initGridView() {
        gridView = (StaggeredGridView) rootView.findViewById(R.id.gridview);
        Adaptor = new adaptor(getActivity(), android.R.layout.simple_list_item_1, mainPresenter.loadGridData());
        Iterator<String> data = mainPresenter.loadGridData().iterator();
        Adaptor.add(data.next());
        gridView.setAdapter(Adaptor);
        gridView.setOnScrollListener(this);
        gridView.setOnItemClickListener(this);
    }

    @Override
    public void ShowProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void ShowSlideShow() {
        mainPresenter.loadSlideShow();
        final ImageView SlideShow = (ImageView) rootView.findViewById(R.id.slideShow);
        for (int i = 0; i < mainPresenter.loadSlideShow().size(); i++) {
            SlideShow.setBackgroundResource(Integer.valueOf(mainPresenter.loadSlideShow().get(i)));
            SlideShow.animate().alpha(mainPresenter.getAnimData().getFirstalpha()).setDuration(mainPresenter.getAnimData().getSetDuration());
            SlideShow.postDelayed(new Runnable() {
                @Override
                public void run() {
                    SlideShow.animate().alpha(mainPresenter.getAnimData().getSecondAlpha()).setDuration(mainPresenter.getAnimData().getSetDuration());
                }
            }, 3000);
        }
    }


    @Override
    public void ShowMiddleCat() {
        mainPresenter.loadMidleCat();
        mainPresenter.setMiddleCatImageviewParams();
        LinearLayout RandomCat = (LinearLayout) rootView.findViewById(R.id.RandomCat);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(mainPresenter
                .setMiddleCatImageviewParams().getHeight(), mainPresenter
                .setMiddleCatImageviewParams().getWidth());
        params.gravity = Gravity.RIGHT;
        params.setMargins(mainPresenter.setMiddleCatImageviewParams().getLeft_margin(),
                mainPresenter.setMiddleCatImageviewParams().getTop_margin(), mainPresenter
                        .setMiddleCatImageviewParams().getRight_margin(), mainPresenter
                        .setMiddleCatImageviewParams().getBottom_margin());

        for (int i = 0; i < mainPresenter.loadMidleCat().size(); i++) {
            final int clickedItem = i + 1;
            ImageView slideImage = new ImageView(getActivity());
            slideImage.setLayoutParams(params);
            slideImage.setBackgroundResource(Integer.valueOf(mainPresenter.loadMidleCat().get(i)));
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
    public void ShowGridClickedMessage(products pro) {
//        Toast.makeText(getActivity(), R.string.gridItemClicked + pro.getCost(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ShowGridClicked(products item) {
//        mainPresenter.clickGridItem(item);
    }

    @Override
    public void ShowErrors() {
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Log.d(TAG, "onScrolled " + i);
    }

    @Override
    public void onScroll(AbsListView absListView, int firstVis, int Visibles, int Total) {
        Log.d(TAG, "onScroll firstVis: " + firstVis + "visisble: " + Visibles + "totalGrid : " +
                Total);
        if (!HasRequestMore) {
            int lasItem = firstVis + Visibles;
            if (lasItem >= Total) {
                Log.d(TAG, "LOAD More ... ");
                Toast.makeText(getActivity(), getResources().getString(R.string.loading) , Toast.LENGTH_SHORT).show();
                HasRequestMore = true;
                LoadMoreItem();

            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getActivity(), getResources().getString(R.string.gridItemClicked) + i, Toast.LENGTH_SHORT).show();
    }

    private void LoadMoreItem() {
        final ArrayList<String> sampleData = mainPresenter.loadGridData();
        for (String data : sampleData) {
            Adaptor.add(data);
        }
        sampleData.addAll(sampleData);
        Adaptor.notifyDataSetChanged();
        HasRequestMore = false;


    }

}
