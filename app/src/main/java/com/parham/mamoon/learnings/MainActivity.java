package com.parham.mamoon.learnings;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.parham.mamoon.learnings.model.ProductModelImpl;
import com.parham.mamoon.learnings.presenter.MainPresenter;
import com.parham.mamoon.learnings.presenter.MainPresenterImpl;
import com.parham.mamoon.learnings.view.MainView;
import com.parham.mamoon.learnings.view.MainViewImpl;

/*
Hi,

As your requested I revised your code and here are my points:

1- I split your model to ProductModel and ProductModelImpl and a DTO called Product.
In MVP you have to communicate with interfaces not public methods.
2- Presenter should not be concerned with how model gets the data(with android httpRequest or UrlConnection
or some other class or library). It is not also the concern of Presenter how View shows the data to user.
so we should use more generic naming like "RenderView()" (not create TextView, create and fill list view and more...)
because with the power of MVC we are going to implement loose coupling between parts and just
communicate with Interfaces and DTOs.
3- View Adapters are also concerned of View and they should decide how to show data to user. but you have to handle
Items click or list refresh and more with Presenter methods. (what should happen next).
I also recommend to use RecyclerView and RecyclerAdapters.
4- I agree with Ali's comment about using Dependency Injection with Dagger2 but it is not mandatory for MVP.
it is another design pattern that is good to use.

good job
Mahdi Tajik

* */

public class MainActivity extends AppCompatActivity {

    private MainPresenter mPresenter;
    private MainView mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new MainPresenterImpl(new ProductModelImpl(this));
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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


}
