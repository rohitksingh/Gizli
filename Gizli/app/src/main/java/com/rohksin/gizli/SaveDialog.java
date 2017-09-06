package com.rohksin.gizli;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.rohksin.gizli.CallBackListeners.SaveDialogListener;
import com.rohksin.gizli.Fragments.CreateNewSecretFragment;
import com.rohksin.gizli.Utility.FileUtil;
import com.rohksin.gizli.Utility.MainVault;

/**
 * Created by Illuminati on 9/6/2017.
 */
/*
TODO VALIDATION IS NEEDED
NULL SHOULD NOT BE ALLOWD
CHECK IF FILE ALREADY EXISTS

*/


public class SaveDialog extends Dialog {

    private SaveDialogListener listener;

    private Button savePublic;
    private Button savePrivate;

    private Context context;

    private TextInputLayout textInputLayout;


    public SaveDialog(Context context,SaveDialogListener listener) {
        super(context);
        this.context = context;
        this.listener = listener;
    }


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.save_dialog);

        savePublic = (Button)findViewById(R.id.savePublic);
        savePrivate = (Button)findViewById(R.id.savePrivate);
        textInputLayout = (TextInputLayout)findViewById(R.id.displayName);


        savePublic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.savePublic("");
                dismiss();
            }
        });

        savePrivate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validationPass()) {
                    listener.savePrivate(textInputLayout.getEditText().getText().toString());
                    dismiss();
                }

            }
        });

    }


    private boolean validationPass()
    {
        String displayName = textInputLayout.getEditText().getText().toString();
        if(displayName.length()>0)
        {
            boolean fileExists =FileUtil.fileExists(displayName);
            if(fileExists)
            {
                Toast.makeText(context,"File Already Exits",Toast.LENGTH_SHORT).show();
                return false;
            }
            else
            {
                return true;
            }
        }
        Toast.makeText(context,"Provide File Name",Toast.LENGTH_SHORT).show();
        return false;
    }

}
