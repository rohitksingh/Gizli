package com.rohksin.gizli.Utility;

import android.util.Log;

import com.rohksin.gizli.POJO.Certificate;

/**
 * Created by Illuminati on 8/24/2017.
 */
public class Loader {

    private static boolean loadedResult = false;
    private static boolean alreadySignedUp = false;


    public static boolean alreadySignedUp()
    {
        if(loadedResult)
        {
            Log.d("CHECK","Result Loaded");
            return alreadySignedUp;
        }
        else {
            //Check if the files exists then decide
            //Got to update the alreadySignedUp then return  alreadySignedUp = someMethod;

            Log.d("CHECK","Result Not Loaded");

            loadedResult = true;

            alreadySignedUp = lookForCrtificateIfExist();

            return alreadySignedUp;
        }

    }

    private static boolean lookForCrtificateIfExist()
    {
        String[] allfiles = MainVault.getAllFileNames();
        //String certiface = MainVault.MainCertificate;

        Certificate certificate = FileUtil.getCertificate();

        Log.d("Validation",(certificate==null)+"");

        if(certificate!=null)
        {

            if(certificate.getSecret()!=null)
            {
                return true;
            }

            return false;
        }


        return false;
    }
}
