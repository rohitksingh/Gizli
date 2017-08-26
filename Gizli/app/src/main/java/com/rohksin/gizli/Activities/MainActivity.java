package com.rohksin.gizli.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rohksin.gizli.R;
import com.rohksin.gizli.Utility.AppUtil;
import com.rohksin.gizli.Utility.FileUtil;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText)findViewById(R.id.vaultPassword);

        loadKeyPad();


        Button button = (Button)findViewById(R.id.Submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result = FileUtil.passwordCorrect(text.getText() + "");
                if(result==true)
                {
                   // Toast.makeText(MainActivity.this,"Login SuccessFul",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(MainActivity.this,VaultActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(MainActivity.this,"Incorrect Password",Toast.LENGTH_LONG).show();
                    AppUtil.giveVibrateWrning(1000);
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


}
