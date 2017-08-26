package com.rohksin.gizli.Utility;

import android.content.Context;

import java.io.File;

/**
 * Created by Illuminati on 8/19/2017.
 */
public class MainVault {

    private static Context context;

    public MainVault(Context context)
    {
        this.context = context;
    }

    public static File giveCentralVault()
    {
        return context.getFilesDir();
    }

    public static String[] getAllFileNames()
    {
        return context.getFilesDir().list();
    }


    public static File[] getAllFiles()
    {
        return context.getFilesDir().listFiles();
    }


}
