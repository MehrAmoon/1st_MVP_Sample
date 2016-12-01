package com.parham.mamoon.learnings.presenter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.bumptech.glide.Glide;
import com.etsy.android.grid.util.DynamicHeightImageView;
import com.parham.mamoon.learnings.R;
//import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import static android.content.ContentValues.TAG;

/**
 * Created by m.amoon on 11/15/2016.
 */

public class adaptor extends ArrayAdapter<String> {

    private final LayoutInflater inflator;
    private final Random random;
    private SparseArray<Double> sPositionHeightRatio = new SparseArray<Double>();

    public adaptor(Context context, int textVieID, ArrayList<String> object) {
        super(context, textVieID, object);

        inflator = LayoutInflater.from(context);
        random = new Random();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder vh;
        if (convertView == null) {
            convertView = inflator.inflate(R.layout.custom_grid_row, parent, false);
            vh = new ViewHolder();
            vh.imagView = (DynamicHeightImageView) convertView.findViewById(R.id.GridImage);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        double positionHeight = getPositionRatio(position);
        vh.imagView.setHeightRatio(positionHeight);

        String url =getItem(position);


        Glide
                .with(convertView.getContext())
                .load(url)
                .centerCrop()
//                .placeholder(R.drawable.home_image_borders)
                .crossFade()
                .into(vh.imagView);

        return convertView;
    }

    private double getPositionRatio(int position) {
        double ratio = sPositionHeightRatio.get(position,0.0);
        if (ratio==0){
            ratio=getRandomHeightRatio();
            sPositionHeightRatio.append(position,ratio);
            Log.d(TAG,"getPositionRatio" + position + "ratio" + ratio);
        }
        return ratio;
    }

    private double getRandomHeightRatio() {
        return (random.nextDouble()/2.0) + 1.0;
    }

    static class ViewHolder {

        DynamicHeightImageView imagView;
    }


}
