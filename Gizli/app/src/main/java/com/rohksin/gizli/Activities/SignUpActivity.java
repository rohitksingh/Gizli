package com.rohksin.gizli.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.rohksin.gizli.POJO.Certificate;
import com.rohksin.gizli.R;
import com.rohksin.gizli.Utility.FileUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Illuminati on 8/21/2017.
 */
public class SignUpActivity extends AppCompatActivity{

    @BindView(R.id.password)
    TextInputLayout password;

    @BindView(R.id.confirmPassword)
    TextInputLayout confirmPassword;

    @BindView(R.id.signUpButton)
    Button signUpButton;

    private InputMethodManager imm;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.signup_activity_layout);
        ButterKnife.bind(this);
        setUpUi();
    }


    //*************************************************************************************
    // private methods
    //*************************************************************************************

    private void setUpUi()
    {
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        password.requestFocus();
        signUpButton = (Button)findViewById(R.id.signUpButton);
        signUpButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(passesValdatipn())
                {
                    FileUtil.makeToast(SignUpActivity.this, "Creating certiface");
                    signUpUserForFirstTime();
                    imm.toggleSoftInput(InputMethodManager.RESULT_SHOWN, 0);
                    redirectToLoginActivity();
                }
            }
        });
    }



    private boolean passesValdatipn()
    {

        String passwordString = password.getEditText().getText().toString();
        String confirmPasswordString = confirmPassword.getEditText().getText().toString();

        if(passwordString.length()>0 && confirmPasswordString.length() > 0)
        {
           if(passwordString.equalsIgnoreCase(confirmPasswordString))
           {
               return true;
           }
           else
           {
               FileUtil.makeToast(SignUpActivity.this, "Password Does not match with");
               return false;
           }
        }
        else
        {
            FileUtil.makeToast(SignUpActivity.this, "Something is null");
        }

        return false;
    }

    private void  redirectToLoginActivity()
    {
        Intent i = new Intent(SignUpActivity.this,MainActivity.class);
        startActivity(i);
        finish();
    }

    private void signUpUserForFirstTime()
    {
        Certificate cert = new Certificate();
        cert.setSecret(password.getEditText().getText().toString());
        cert.setLastVisit("Welcome To Gizli Vault");
        FileUtil.createCertificate(cert);
    }

}
