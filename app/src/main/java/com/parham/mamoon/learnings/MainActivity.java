package com.parham.mamoon.learnings;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.parham.mamoon.learnings.model.Products;
import com.parham.mamoon.learnings.presenter.MainPresenter;
import com.parham.mamoon.learnings.presenter.MainPresenterImpl;
import com.parham.mamoon.learnings.view.MainView;
import com.parham.mamoon.learnings.view.MainViewImpl;

/*
Dear Mehrnaz,

After reviewing the code meticulously, I believe that you have got the gist of MVP and we can
work in parallel on MVP projects with you undertaking the View-related code.
However, I came across the following issues in your code that have to be resolved to match the
best practice as well as eliminate potential waste of time and repetitions in real projects:
1- In addition to Presenter and PresenterImpl, any other class related to showing a view shall be
put under the presenter subpackage.
For example, here I have moved Adaptor, Animations and ImageViewParams from model to presenter
subpackage.
This is because they all provide data/layout/params needed for rendering the view and are
addressed in PresenterImpl.
2- When the project grows inside, further breakdowns could be necessary in each
model-view-presenter package, based on feature, for instance.
3- Classes should start with capital letters and methods with smaller ones. I partly corrected
this, please do the remaining.
4- As Dependency Injection is the pattern used for object instantiation, please implement DI using
 Dagger 2.0 in this project after correcting the above.
5- I do not know what the use of 'StaggeredGridActivity' is in this project. It may have
remained from your previous cleanup, however.
6- Any view transitions shall be done through Fragments, using preferably only one MainActivity
and there is a one-to-one relation between each View and its corresponding Presenter.
7- As you have not dealt with it up to this stage of development, it would be wise to extend the
project so inter-View interactions are also cared for and improved in case there is room for.

Thanks and Good Luck.
Ali Nemati Hayati
* */

public class MainActivity extends AppCompatActivity {

    //    private MainPresenterImpl mPresenter;
    /* Interface shall be used whenever possible */
    private MainPresenter mPresenter;
    /* Interface shall be used whenever possible */
    private MainView mainView;
//    private MainViewImpl mainViewImp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new MainPresenterImpl(new Products());
        mainView = new MainViewImpl(mPresenter);
        InitiateView();
    }

    private void InitiateView() {
        setContentView(R.layout.activity_main);
        getFragmentManager().beginTransaction()
                .add(R.id.main_fragment, (Fragment) mainView)
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
