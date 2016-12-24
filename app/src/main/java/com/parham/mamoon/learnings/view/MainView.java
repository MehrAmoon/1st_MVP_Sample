package com.parham.mamoon.learnings.view;

import com.parham.mamoon.learnings.DTO.Product;
import com.parham.mamoon.learnings.model.ProductModelImpl;

import java.util.ArrayList;

/**
 * Created by m.amoon on 11/22/2016.
 */

public interface MainView {


    void waiteForData();

    void showMessage(String messageText);

    void finishWaiteForData();

    void renderView(ArrayList<Product> products);

    void renderSlides(ArrayList<Integer> slideImagesResource);


}
