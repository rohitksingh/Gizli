package com.rohksin.gizli.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.rohksin.gizli.R;
import com.rohksin.gizli.Utility.AppUtil;

/**
 * Created by Illuminati on 8/27/2017.
 */
public class Test extends AppCompatActivity {

    private Fragment[] fragments;
    private Button prev;
    private Button next;

    private FragmentManager fm;

    private int index = 0;

    protected  void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);


        setAllFragments();

        fm = getSupportFragmentManager();

        fm.beginTransaction().replace(R.id.passwordResetLayout,fragments[0]).commit();



        prev =(Button)findViewById(R.id.prev);
        next = (Button)findViewById(R.id.next);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction().replace(R.id.passwordResetLayout,givePrevioousFragment())
                        .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left)
                        .commit();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction().replace(R.id.passwordResetLayout, giveNextFragment())
                        .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                        .commit();
            }
        });


    }



    private void  setAllFragments()
    {
        fragments = AppUtil.getAllSignUpFragments();
    }

    private Fragment givePrevioousFragment()
    {
        return fragments[--index];
    }

    private Fragment giveNextFragment()
    {
        return fragments[++index];
    }


}
