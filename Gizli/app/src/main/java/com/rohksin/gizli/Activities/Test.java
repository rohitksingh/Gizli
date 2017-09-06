package com.rohksin.gizli.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.rohksin.gizli.CallBackListeners.QuestionCompleteListener;
import com.rohksin.gizli.POJO.Certificate;
import com.rohksin.gizli.R;
import com.rohksin.gizli.Utility.AppUtil;

/**
 * Created by Illuminati on 8/27/2017.
 */
public class Test extends AppCompatActivity implements QuestionCompleteListener{


    private Fragment[] fragments;
    private Button prev;
    private Button next;

    private Certificate certificate;

    private FragmentManager fm;

    private int index = 0;

    protected  void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.test);

        certificate = new Certificate();

        setAllFragments(certificate);

        certificate = new Certificate();

        fm = getSupportFragmentManager();

        fm.beginTransaction().replace(R.id.passwordResetLayout,fragments[0]).commit();



        /*
        prev =(Button)findViewById(R.id.prev);
        next = (Button)findViewById(R.id.next);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left)
                        .replace(R.id.passwordResetLayout,givePrevioousFragment())
                        .commit();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction()
                        .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                        .replace(R.id.passwordResetLayout, giveNextFragment())
                        .commit();
            }
        });

        */


    }



    private void  setAllFragments(Certificate certificate)
    {
        fragments = AppUtil.getAllSignUpFragments(certificate);
    }

    private Fragment givePrevioousFragment()
    {
        return fragments[--index];
    }

    private Fragment giveNextFragment()
    {
        return fragments[++index];
    }


    @Override
    public void questionComplete(Certificate certificate) {
        Log.d("Certificate",certificate +" ");
        Toast.makeText(Test.this,"Question Complete",Toast.LENGTH_LONG) .show();

        fm.beginTransaction()
                .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left)
                .replace(R.id.passwordResetLayout, giveNextFragment())
                .commit();
    }

    @Override
    public void back() {

    }


}
