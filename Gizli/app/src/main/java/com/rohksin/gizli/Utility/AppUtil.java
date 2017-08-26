package com.rohksin.gizli.Utility;

import android.content.Context;
import android.os.Vibrator;

/**
 * Created by Illuminati on 8/25/2017.
 */
public class AppUtil {

    private static Context context;

    public AppUtil(Context context)
    {
        this.context = context;
    }

    public static void giveVibrateWrning(int milis)
    {
        Vibrator vibrator = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(milis);
    }
}
