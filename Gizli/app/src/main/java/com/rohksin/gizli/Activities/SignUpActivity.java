package com.rohksin.gizli.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.rohksin.gizli.POJO.Certificate;
import com.rohksin.gizli.R;
import com.rohksin.gizli.Utility.FileUtil;

/**
 * Created by Illuminati on 8/21/2017.
 */
public class SignUpActivity extends AppCompatActivity{

    private EditText password;
    private EditText confirmPassword;
    private Button signUpButton;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity_layout);

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

        password = (EditText)findViewById(R.id.password);
        password.requestFocus();
        confirmPassword = (EditText)findViewById(R.id.confirmPassword);
        signUpButton = (Button)findViewById(R.id.signUpButton);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(passesValdatipn())
                {
                    FileUtil.makeToast(SignUpActivity.this, "Creating certiface");

                    signUpUserForFirstTime();

                    redirectToLoginActivity();
                }
            }
        });

    }

    private boolean passesValdatipn()
    {
        String passwordString = password.getText().toString();
        String confirmPasswordString = confirmPassword.getText().toString();

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
        //cert.setDisplayName(password.getText().toString());
        cert.setSecret(password.getText().toString());
        FileUtil.createCertificate(cert);
    }



}
