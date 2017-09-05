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
        Log.d("Life", "oncreate");
    }


    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d("Life","start");
    }

    @Override
    public void onResume()
    {
        super.onResume();
        Log.d("Life", "resume");
    }

    @Override
    protected void onPause()
    {

        super.onPause();
        Log.d("Life", "on Pause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Life","stop");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d("Life", "destroy");
    }

    public void visibilityGome()
    {
        signUpButton.setVisibility(View.GONE);
    }



    @Override
    protected void onUserLeaveHint()
    {
       // super.onUserLeaveHint();
        visibilityGome();
        Log.d("Life", "leave hint");

    }

}
