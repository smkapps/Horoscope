package com.user.work.testing.horoscope.utils;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Solo_Family on 05.11.2017.
 */

public class UtilLoadingImage {

    @BindingAdapter({"android:src", "app:error"})
    public static void loadImage(ImageView view, String url, Drawable error){
        Picasso.with(view.getContext())
                .load(url)
                .into(view);
    }
}
