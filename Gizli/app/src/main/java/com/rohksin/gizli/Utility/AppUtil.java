package com.rohksin.gizli.Utility;

import android.content.Context;
import android.os.Vibrator;
import android.support.v4.app.Fragment;

import com.rohksin.gizli.Fragments.PasswordSetFragment;
import com.rohksin.gizli.Fragments.SetSecretImageFragment;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Illuminati on 8/25/2017.
 */
public class AppUtil {

    private static Context context;

    private static final String LAST_VISITED_DATE_FORMAT = "h:m a (d MMM)";

    public AppUtil(Context context)
    {
        this.context = context;
    }

    public static void giveVibrateWrning(int milis)
    {
        Vibrator vibrator = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(milis);
    }

    public static String getCurrentTime()
    {
        SimpleDateFormat sdf = new SimpleDateFormat(LAST_VISITED_DATE_FORMAT);

        String currentDate = sdf.format(new Date());

        return "Last visited at "+currentDate;

    }

    public static Fragment[] getAllSignUpFragments()
    {
       return new Fragment[]{

               PasswordSetFragment.getInstance(),
               SetSecretImageFragment.getInstance()

        };
    }
}
