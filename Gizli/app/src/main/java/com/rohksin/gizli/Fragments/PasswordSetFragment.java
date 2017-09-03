package com.rohksin.gizli.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.rohksin.gizli.Activities.Test;
import com.rohksin.gizli.CallBackListeners.QuestionCompleteListener;
import com.rohksin.gizli.POJO.Certificate;
import com.rohksin.gizli.R;
import com.rohksin.gizli.Utility.AppUtil;

/**
 * Created by Illuminati on 8/27/2017.
 */
public class PasswordSetFragment extends Fragment {

    private static QuestionCompleteListener listener;
    private static Certificate certificate;
    private TextInputLayout password;
    private TextInputLayout confirmPassword;
    private  Context context;
    /// Is there any issue using onAttach Context ?



    public static PasswordSetFragment getInstance(Certificate certificateFromActivity)
    {
        Bundle args = new Bundle();
        PasswordSetFragment fragment = new PasswordSetFragment();
        fragment.setArguments(args);

        certificate = certificateFromActivity;

        return fragment;
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        this.context = context;
        listener = (Test)context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.signup_activity_layout,parent,false);

        Button button = (Button)view.findViewById(R.id.signUpButton);
        button.setText("NEXT");

        password = (TextInputLayout)view.findViewById(R.id.password);

        confirmPassword = (TextInputLayout)view.findViewById(R.id.confirmPassword);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(checkifValid(password.getEditText().getText().toString(),confirmPassword.getEditText().getText().toString())) {

                    certificate.setSecret(password.getEditText().getText().toString());
                    listener.questionComplete(certificate);
                }
                else {
                    Toast.makeText(context,"Passwords do not match",Toast.LENGTH_SHORT).show();
                   // AppUtil.giveVibrateWrning(200);
                }
            }
        });
        /*
        Component logic goes here
         */
        return view;
    }

    public boolean checkifValid(String str1 , String str2)
    {
        return str1.equals(str2);
    }

}
