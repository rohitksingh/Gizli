package com.rohksin.gizli.Utility;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;

/**
 * Created by Illuminati on 9/2/2017.
 */
public class GizliAnimUtil {

    private  static final int DEFAULT_ANIM_TIME = 2000;

    public static void fadeInAnim(View view)
    {
        view.animate().alpha(1)
        .setDuration(1000);
    }

    public static void fadeInAnim(View view,int timeinMilis)
    {
        view.animate()
                .alpha(1)
                .setDuration(timeinMilis)
                .setInterpolator(new AccelerateDecelerateInterpolator());
    }

    public static void popUpAnmi(View view)
    {
        view.animate()
                .alpha(1)
                .setDuration(2000)
                .setInterpolator(new BounceInterpolator());
    }

    public static void waringAnim(View view)
    {
        view.animate()
                .scaleXBy((float)1.5)
                .setDuration(1000)
                .setStartDelay(100)
                .setInterpolator(new CycleInterpolator(1));
    }

}
