package com.parham.mamoon.learnings;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.parham.mamoon.learnings.presenter.MainPresenter;
import com.parham.mamoon.learnings.presenter.MainPresenterImpl;
import com.parham.mamoon.learnings.view.MainView;
import com.parham.mamoon.learnings.view.MainViewImpl;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MainPresenterImpl mPresenter;
    MainViewImpl mainViewImp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new MainPresenterImpl();
        mainViewImp = new MainViewImpl(mPresenter);
        InitiateView();
    }

    private void InitiateView() {
        setContentView(R.layout.activity_main);
        getFragmentManager().beginTransaction()
                .add(R.id.main_fragment, mainViewImp)
                .commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        mPresenter.loadGridView();
    }

    @Override
    protected void onDestroy() {
//        mainPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        outState.putStringArrayList("Saved", mData);
    }


}
