package com.rohksin.gizli.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import com.rohksin.gizli.CallBackListeners.YesNoListener;
import com.rohksin.gizli.R;

/**
 * Created by Illuminati on 9/6/2017.
 */
public abstract class YesNoDialog extends Dialog{

    public Context context;
    public YesNoListener listener;

    public YesNoDialog(Context context) {
        super(context);
        this.context = context;
        this.listener = (YesNoListener)listener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(provideLayout());
    }

    public abstract int provideLayout();

    public abstract Object dataToSend();




}
