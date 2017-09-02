package com.rohksin.gizli.Activities;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rohksin.gizli.R;
import com.rohksin.gizli.Utility.AppUtil;
import com.rohksin.gizli.Utility.FileUtil;
import com.rohksin.gizli.Utility.GizliAnimUtil;

public class MainActivity extends AppCompatActivity {

    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button cancel;
    private Button view;
    private EditText text;

    private TextView forgotPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setAnimation();

        setContentView(R.layout.activity_main);

        text = (EditText)findViewById(R.id.vaultPassword);

        text.setShowSoftInputOnFocus(false);

        loadKeyPad();

        forgotPassword = (TextView)findViewById(R.id.forgotPassword);

        Button button = (Button)findViewById(R.id.Submit);
        GizliAnimUtil.popUpAnmi(button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result = FileUtil.passwordCorrect(text.getText() + "");
                if(result==true)
                {
                   // Toast.makeText(MainActivity.this,"Login SuccessFul",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(MainActivity.this,VaultActivity.class);
                    if(Build.VERSION.SDK_INT>20) {
                        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                        startActivity(i,options.toBundle());
                    }
                    else
                    {
                        startActivity(i);
                    }
                }
                else {
                    Toast.makeText(MainActivity.this,"Incorrect Password",Toast.LENGTH_LONG).show();
                    AppUtil.giveVibrateWrning(1000);

                    // HOW TO CANCEL ANIMATION IF one is already going on ?
                    //GizliAnimUtil.waringAnim(forgotPassword);

                }
            }
        });
    }

    public void loadKeyPad()
    {
        one = (Button)findViewById(R.id.one);
        two = (Button)findViewById(R.id.two);
        three = (Button)findViewById(R.id.three);
        four = (Button)findViewById(R.id.four);
        five = (Button)findViewById(R.id.five);
        six = (Button)findViewById(R.id.six);
        seven = (Button)findViewById(R.id.seven);
        eight = (Button)findViewById(R.id.eight);
        nine = (Button)findViewById(R.id.nine);
        zero = (Button)findViewById(R.id.zero);
        cancel = (Button)findViewById(R.id.cancel);
        view = (Button)findViewById(R.id.view);

        /*int time = 3000;

        one.animate().alpha(1)
        .setDuration(time);
        //one.animate().rotationY(360).setDuration(time);
        two.animate().rotationY(360).setDuration(time);
        three.animate().rotationY(360).setDuration(time);
        four.animate().rotationY(360).setDuration(time);
        five.animate().rotationY(360).setDuration(time);
        six.animate().rotationY(360).setDuration(time);
        seven.animate().rotationY(360).setDuration(time);
        eight.animate().rotationY(360).setDuration(time);
        nine.animate().rotationY(360).setDuration(time);
        zero.animate().rotationY(360).setDuration(time);
        cancel.animate().rotationY(360).setDuration(time);

        */

        GizliAnimUtil.fadeInAnim(one,3000);
        GizliAnimUtil.fadeInAnim(two,3000);
        GizliAnimUtil.fadeInAnim(three,3000);
        GizliAnimUtil.fadeInAnim(four,3000);
        GizliAnimUtil.fadeInAnim(five,3000);
        GizliAnimUtil.fadeInAnim(six,3000);
        GizliAnimUtil.fadeInAnim(seven,3000);
        GizliAnimUtil.fadeInAnim(eight,3000);
        GizliAnimUtil.fadeInAnim(nine,3000);
        GizliAnimUtil.fadeInAnim(zero,3000);
        GizliAnimUtil.fadeInAnim(cancel,3000);


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.append("1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.append("2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.append("3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.append("4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.append("5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.append("6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.append("7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.append("8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.append("9");
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.append("0");
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(null);
            }
        });




    }

    public void setAnimation()
    {
        if(Build.VERSION.SDK_INT>20)
        {
            Explode explode = new Explode();
            explode.setDuration(500);
            explode.setInterpolator(new LinearInterpolator());
            getWindow().setEnterTransition(explode);
            getWindow().setExitTransition(explode);
        }
    }


}
