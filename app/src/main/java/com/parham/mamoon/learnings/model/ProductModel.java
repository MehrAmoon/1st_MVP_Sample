package com.parham.mamoon.learnings.model;

import com.parham.mamoon.learnings.DTO.Product;

import java.util.ArrayList;
import java.util.Objects;

public interface ProductModel {



    void setFavorite(Product product, Boolean favorite);

    void getProductsFromServer(DataCallBack callBack);

    void getBannersFromServer(BanerDataCallBack callBack);


    interface DataCallBack {

         void onDataFetchSuccessfull(ArrayList<Product> dataList);

        void onDataFetchFail();
    }

    interface BanerDataCallBack {

        void onDataFetchSuccessfull(ArrayList<Integer> imageList);

        void onDataFetchFail();
    }
}
