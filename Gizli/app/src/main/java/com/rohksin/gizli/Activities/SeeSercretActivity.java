package com.rohksin.gizli.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rohksin.gizli.Dialog.SaveEditDialog;
import com.rohksin.gizli.POJO.Secret;
import com.rohksin.gizli.R;
import com.rohksin.gizli.Utility.AppUtil;
import com.rohksin.gizli.Utility.FileUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Illuminati on 8/20/2017.
 */
public class SeeSercretActivity extends AppCompatActivity {

    @BindView(R.id.secretText)
    TextView secretText;

    @BindView(R.id.editButton)
    Button editButton;

    @BindView(R.id.deleteSecret)
    LinearLayout deleteSecret;

    Intent backIntent;
    private Secret secret;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.see_secret_activity_test);
        ButterKnife.bind(this);
        setUpUi();

    }


    //*************************************************************************************
    // Activity callback Methods
    //*************************************************************************************

    @Override
    public void onBackPressed() {

        setResult(RESULT_OK, backIntent);
        super.onBackPressed();
    }


    //*************************************************************************************
    // private methods
    //*************************************************************************************

    private void setUpUi()
    {
        backIntent = new Intent();
        secret = (Secret)getIntent().getSerializableExtra(FileUtil.SECRET_PASS_OBJECT);
        secretText.setText(secret.getSecret());

        AppUtil.setUpOption(deleteSecret,"Delete",R.drawable.ic_delete_white);

        deleteSecret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK, backIntent);
                FileUtil.deleteSecret(secret.getMetaData().filePath);
                finish();
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD A DIALOG YES NO DIALOG

                SaveEditDialog dialog = new SaveEditDialog(SeeSercretActivity.this);
                dialog.show();

            }
        });

    }



}
