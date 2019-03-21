package com.example.rxjavaexample.views.adapter;

import android.widget.ImageView;

import com.example.rxjavaexample.R;
import com.squareup.picasso.Picasso;

public class ImageLoader {

    public static void loadImage(ImageView imageView, String url) {

        Picasso.with(imageView.getContext())
                .load(url)
                .placeholder(R.drawable.placeholder)
                .into(imageView);
    }
}
