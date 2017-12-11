package com.rohksin.gizli.Activities;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.rohksin.gizli.R;
import com.rohksin.gizli.Utility.AppUtil;
import com.rohksin.gizli.Utility.FileUtil;
import com.rohksin.gizli.Utility.Loader;

/**
 * Created by Illuminati on 8/24/2017.
 */
public class SplashScreenActivity extends AppCompatActivity {

    private static final int SPLASH_TIME = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_layout);
        FileUtil.Loader(SplashScreenActivity.this);
        initiateUtils();
        new LoadActivity(this).execute();

    }


    //*************************************************************************************
    // private methods
    //*************************************************************************************

    // To provide context to every Utility class
    private void initiateUtils()
    {
        AppUtil appUtil = new AppUtil(SplashScreenActivity.this);
    }


    private class LoadActivity extends AsyncTask{

        private boolean isAlreadySignedUp;
        private Context context;

        public LoadActivity(Context context)
        {
            this.context = context;
        }

        @Override
        protected Void doInBackground(Object[] objects) {
            try {
                Thread.sleep(SPLASH_TIME);
                isAlreadySignedUp = Loader.alreadySignedUp();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        //TODO write some spinner
        @Override
        protected void onProgressUpdate(Object... objects)
        {

        }

        @Override
        protected void onPostExecute(Object o)
        {
              Intent i = null;

              if(isAlreadySignedUp)
              {
                  i = new Intent(SplashScreenActivity.this,CreateSecretActivity.class);
              }
              else
              {
                  i = new Intent(SplashScreenActivity.this,Test.class);
              }

            if(Build.VERSION.SDK_INT>20)
            {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashScreenActivity.this);
                startActivity(i,options.toBundle());
            }
            else {
                startActivity(i);
            }

            finish();

        }
    }
}
