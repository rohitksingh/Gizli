package com.rohksin.gizli.CustomViews;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Illuminati on 9/3/2017.
 */
public class SecretImage extends ImageView {
    public SecretImage(Context context) {
        super(context);
    }

    public SecretImage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SecretImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onMeasure(int a, int b)
    {
        super.onMeasure(a,b);
        setMeasuredDimension(getMeasuredWidth(),getMeasuredWidth());
    }
}
