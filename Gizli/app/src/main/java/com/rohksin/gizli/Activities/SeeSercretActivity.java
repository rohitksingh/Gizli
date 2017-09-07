package com.rohksin.gizli.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rohksin.gizli.Dialog.SaveEditDialog;
import com.rohksin.gizli.POJO.Secret;
import com.rohksin.gizli.R;
import com.rohksin.gizli.Utility.FileUtil;

/**
 * Created by Illuminati on 8/20/2017.
 */
public class SeeSercretActivity extends AppCompatActivity {

    private TextView displayName;
    private TextView creationDate;
    private TextView secretText;
    private Secret secret;
    private Button editButton;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

       // setContentView(R.layout.see_secret_layout);

        setContentView(R.layout.see_secret_activity_test);


        secret = (Secret)getIntent().getSerializableExtra(FileUtil.SECRET_PASS_OBJECT);

        //displayName = (TextView)findViewById(R.id.displayName);
        //desc = (TextView)findViewById(R.id.Desc);
        //secretText = (TextView)findViewById(R.id.Secret);


        secretText = (EditText)findViewById(R.id.secretText);
        editButton = (Button)findViewById(R.id.editButton);

        //displayName.setText(secret.getDisplayName());
        secretText.setText(secret.getSecret());

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ADD A DIALOG YES NO DIALOG

                SaveEditDialog dialog = new SaveEditDialog(SeeSercretActivity.this);
                dialog.show();
                /*
                secret.setSecret(secretText.getText().toString());
                FileUtil.editSecret(secret);
                Toast.makeText(SeeSercretActivity.this,"Edited successfully",Toast.LENGTH_SHORT).show();

                */

            }
        });

    }



    @Override
    public void onBackPressed() {

        Intent mIntent = new Intent();

            setResult(RESULT_OK, mIntent);

        super.onBackPressed();
    }

}
