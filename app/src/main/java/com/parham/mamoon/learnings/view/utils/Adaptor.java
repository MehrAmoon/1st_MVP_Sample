package com.parham.mamoon.learnings.view.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.etsy.android.grid.util.DynamicHeightImageView;
import com.parham.mamoon.learnings.DTO.Product;
import com.parham.mamoon.learnings.R;

import java.util.ArrayList;
import java.util.Random;

import static android.content.ContentValues.TAG;

//import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by m.amoon on 11/15/2016.
 * <p>
 * Mahdi revise: Adaptor is one of View component
 * and it able us to showing data in some way.
 * using or not using is View manner. so we
 * had to put in View package.
 * also we can pass the Presenter method for clicking Item
 * to adapter Constructor, but I find that you handled
 * Item click in "onItemClick" in MainViewImpl
 * that it is right too.
 * algthoug it is better to migrate to Recycle view and RecycleAdapter
 */

public class Adaptor extends ArrayAdapter<Product> {

    private final LayoutInflater inflator;
    private final Random random;
    private SparseArray<Double> sPositionHeightRatio = new SparseArray<Double>();
    private ArrayList<Product> itemList = new ArrayList<>();

    public Adaptor(Context context, int textVieID, ArrayList<Product> objects) {
        super(context, textVieID, objects);

        inflator = LayoutInflater.from(context);
        random = new Random();
        this.itemList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder vh = null;
        if (convertView == null) {
            convertView = inflator.inflate(R.layout.custom_grid_row, parent, false);
            vh = new ViewHolder();
            vh.imagView = (DynamicHeightImageView) convertView.findViewById(R.id.GridImage);
            vh.itemName = (TextView) convertView.findViewById(R.id.GridDiscount);

            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        double positionHeight = getPositionRatio(position);
        vh.imagView.setHeightRatio(positionHeight);

        String url = getItem(position).getImage();
        Glide
                .with(convertView.getContext())
                .load(url)
                .centerCrop()
                .crossFade()
                .into(vh.imagView);

        vh.itemName.setText(getItem(position).getData());


        return convertView;
    }

    private double getPositionRatio(int position) {
        double ratio = sPositionHeightRatio.get(position, 0.0);
        if (ratio == 0) {
            ratio = getRandomHeightRatio();
            sPositionHeightRatio.append(position, ratio);
            Log.d(TAG, "getPositionRatio" + position + "ratio" + ratio);
        }
        return ratio;
    }

    private double getRandomHeightRatio() {
        return (random.nextDouble() / 2.0) + 1.0;
    }

    static class ViewHolder {

        DynamicHeightImageView imagView;
        TextView itemName;
    }


}
