package com.parham.mamoon.learnings.presenter;

import android.app.Activity;
import android.util.Log;
import android.widget.AbsListView;

import com.parham.mamoon.learnings.DTO.Product;
import com.parham.mamoon.learnings.R;
import com.parham.mamoon.learnings.model.ProductModel;
import com.parham.mamoon.learnings.model.ProductModelImpl;
import com.parham.mamoon.learnings.view.MainView;

import java.util.ArrayList;

/**
 * Created by m.amoon on 11/22/2016.
 */


public class MainPresenterImpl implements MainPresenter {
    private String TAG = "M3hrStraggeredGrid";
    private ProductModel productModel;
    private MainView mainView;
    private boolean hasRequestMore;


    /* Product is the core business of the project and the domain model. So its relation with this class is 'has'. */
    public MainPresenterImpl(ProductModel productModel) {
        this.productModel = productModel;
    }


    @Override
    public void getData() {

        mainView.waiteForData();

        productModel.getProductsFromServer(new ProductModel.DataCallBack() {
            //callback for get data
            @Override
            public void onDataFetchSuccessfull(ArrayList<Product> dataList) {

                //render product list to View
                mainView.renderView(dataList);

                productModel.getBannersFromServer(new ProductModel.BanerDataCallBack() {
                    //callback for get banners
                    @Override
                    public void onDataFetchSuccessfull(ArrayList<Integer> imageList) {

                        //render slides to View
                        mainView.renderSlides(imageList);
                        //end of waiting of view
                        mainView.finishWaiteForData();
                    }

                    @Override
                    public void onDataFetchFail() {

                        mainView.showMessage("error fetch sliders");

                    }
                });
            }

            @Override
            public void onDataFetchFail() {

                mainView.showMessage("error fetch products");
            }
        });

    }

    @Override
    public void itemClick(Product product) {

    }

    @Override
    public void setView(MainView mainView) {
        this.mainView = mainView;
    }








    private ArrayList<Integer> getRandomNumbers(ArrayList<Integer> want) {
        ArrayList<Integer> choice = new ArrayList<Integer>();
        ArrayList<Integer> rand;
        rand = want;
        for (int i = 0; i < rand.size(); i++) {
            int pic = (int) (Math.random() * rand.size());
            choice.add(Integer.valueOf(rand.get(pic)));
        }
        return choice;
    }






    public void doWhenScrollStateIsChanged(AbsListView absListView, int i) {
        Log.d(TAG, "onScrolled " + i);
    }

    public void doOnScroll(Activity activity, AbsListView absListView, int firstVis, int visibles, int total) {
        Log.d(TAG, "onScroll firstVis: " + firstVis + "visisble: " + visibles + "totalGrid : " +
                total);
        if (!hasRequestMore) {
            int lasItem = firstVis + visibles;
            if (lasItem >= total) {
                Log.d(TAG, "LOAD More ... ");
                //todo: here you had to call some View method, not directly handle view from presenter
//                Toast.makeText(activity, activity.getResources().getString(R.string.loading), Toast.LENGTH_SHORT).show();
                hasRequestMore = true;
                loadMoreItem(activity);

            }
        }
    }

    private void loadMoreItem(Activity activity) {
        hasRequestMore = false;

    }
}
