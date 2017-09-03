package com.rohksin.gizli.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rohksin.gizli.Activities.MainActivity;
import com.rohksin.gizli.POJO.Certificate;
import com.rohksin.gizli.R;
import com.rohksin.gizli.Utility.FileUtil;

/**
 * Created by Illuminati on 9/3/2017.
 */
public class SetUpFinish extends Fragment {

    private static Certificate certificate;
    private Context context;

    public static SetUpFinish getInstance(Certificate certificateFromActivity)
    {
        Bundle args = new Bundle();
        SetUpFinish fragment = new SetUpFinish();
        fragment.setArguments(args);
        certificate = certificateFromActivity;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.set_up_finished_layout,parent,false);

        Button button = (Button)view.findViewById(R.id.finishSetUp);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpUserForFirstTime(certificate);
                Log.d("Finsh", certificate + "");
                redirectToLoginActivity();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        this.context = context;
    }


    private void signUpUserForFirstTime(Certificate certificate)
    {
        Certificate cert = certificate;
        //cert.setDisplayName(password.getText().toString());
        cert.setLastVisit("Welcome To Gizli Vault");
        FileUtil.createCertificate(cert);
    }

    private void  redirectToLoginActivity()
    {
        Intent i = new Intent(context,MainActivity.class);
        startActivity(i);
        ((Activity)context).finish();
        /// lets move it to another
    }

}
