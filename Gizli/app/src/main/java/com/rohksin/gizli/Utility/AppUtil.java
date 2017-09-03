package com.rohksin.gizli.Utility;

import android.content.Context;
import android.os.Vibrator;
import android.support.v4.app.Fragment;

import com.rohksin.gizli.Fragments.PasswordSetFragment;
import com.rohksin.gizli.Fragments.SetSecretImageFragment;
import com.rohksin.gizli.Fragments.SetUpFinish;
import com.rohksin.gizli.POJO.Certificate;
import com.rohksin.gizli.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public static Fragment[] getAllSignUpFragments(Certificate certificate)
    {
       return new Fragment[]{

               PasswordSetFragment.getInstance(certificate),
               SetSecretImageFragment.getInstance(certificate),
               SetUpFinish.getInstance(certificate)

        };
    }

    public static List<Integer> getAllSecretImages()
    {
        List<Integer> secretImages = new ArrayList<Integer>();
        secretImages.add(R.drawable.gizli);
        secretImages.add(R.drawable.gizli_base);
        secretImages.add(R.drawable.ic_add_box_white);
        secretImages.add(R.drawable.ic_clear_white);
        secretImages.add(R.drawable.ic_delete_white);
        secretImages.add(R.drawable.ic_mode_edit_white);
        secretImages.add(R.drawable.gizli);

        return secretImages;
    }
}
