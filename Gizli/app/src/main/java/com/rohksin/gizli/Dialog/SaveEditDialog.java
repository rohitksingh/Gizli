package com.rohksin.gizli.Dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.Window;

import com.rohksin.gizli.R;

/**
 * Created by Illuminati on 9/6/2017.
 */
public class SaveEditDialog extends YesNoDialog {

    private TextInputLayout textInputLayout;

    public SaveEditDialog(Context context) {
        super(context);
    }

    @Override
    public int provideLayout() {
        return R.layout.save_dialog;
    }

    @Override
    public Object dataToSend() {
        return null;
    }


}
