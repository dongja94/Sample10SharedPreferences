package com.example.dongja94.samplesharedpreferences;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by dongja94 on 2016-02-11.
 */
public class RoundedImageView extends ImageView {
    public RoundedImageView(Context context) {
        super(context);
    }

    public RoundedImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setImageBitmap(Bitmap bm) {
//        super.setImageBitmap(bm);
        RoundedBitmapDrawable rbd = RoundedBitmapDrawableFactory.create(getResources(), bm);
        rbd.setCircular(true);
        setImageDrawable(rbd);
    }
}
