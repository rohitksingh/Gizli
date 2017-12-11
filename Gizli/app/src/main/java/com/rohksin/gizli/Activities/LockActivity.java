package com.rohksin.gizli.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.rohksin.gizli.R;

/**
 * Created by Illuminati on 9/3/2017.
 */
public class LockActivity extends AppCompatActivity {

    private Button signUpButton;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity_layout);
        signUpButton = (Button)findViewById(R.id.signUpButton);
    }

    //*************************************************************************************
    // Private Methods
    //*************************************************************************************

    private void visibilityGome()
    {
        signUpButton.setVisibility(View.GONE);
    }

    //*************************************************************************************
    // Activity callback Methods
    //*************************************************************************************

    @Override
    protected void onUserLeaveHint()
    {
        visibilityGome();

    }

}
