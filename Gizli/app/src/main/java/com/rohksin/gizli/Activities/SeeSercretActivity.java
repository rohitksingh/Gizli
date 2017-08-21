package com.rohksin.gizli.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.rohksin.gizli.POJO.Secret;
import com.rohksin.gizli.R;
import com.rohksin.gizli.Utility.AppUtil;

/**
 * Created by Illuminati on 8/20/2017.
 */
public class SeeSercretActivity extends AppCompatActivity {

    private TextView displayName;
    private TextView desc;
    private TextView secretText;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.see_secret_layout);
        Secret secret = (Secret)getIntent().getSerializableExtra(AppUtil.SECRET_PASS_OBJECT);

        displayName = (TextView)findViewById(R.id.displayName);
        desc = (TextView)findViewById(R.id.Desc);
        secretText = (TextView)findViewById(R.id.Secret);

        displayName.setText(secret.getDisplayName());
        desc.setText(secret.getDescription());
        secretText.setText(secret.getSecret());

    }
}
