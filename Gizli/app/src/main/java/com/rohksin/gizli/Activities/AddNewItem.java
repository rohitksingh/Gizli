package com.rohksin.gizli.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.rohksin.gizli.POJO.Secret;
import com.rohksin.gizli.R;
import com.rohksin.gizli.Utility.FileUtil;
import com.rohksin.gizli.Utility.MainVault;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Illuminati on 8/19/2017.
 */

/*
 Delete this file
 */
public class AddNewItem extends AppCompatActivity {

    private boolean resultSaved = false;

    @BindView(R.id.Text)
    EditText displayText;

    @BindView(R.id.Desc)
    EditText desc;

    @BindView(R.id.Secret)
    EditText secretText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.add_item_layout);
        ButterKnife.bind(this);

        if(savedInstanceState!=null)
        {
            resultSaved = savedInstanceState.getBoolean("REsultSAVED");
        }

        Button button = (Button)findViewById(R.id.AddButton);
        button.setText("Save");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Secret secret = new Secret();
                secret.setDisplayName(displayText.getText().toString());
                secret.setDescription(desc.getText().toString());
                secret.setSecret(secretText.getText().toString());
                validation(secret);
            }
        });


    }

    //*************************************************************************************
    // Activity Callback Methods
    //*************************************************************************************

    @Override
    public void onBackPressed() {

        Intent mIntent = new Intent();
        if(resultSaved) {
            setResult(RESULT_OK, mIntent);
        }
        else
        {
            setResult(RESULT_CANCELED,mIntent);
        }
        super.onBackPressed();
    }

    //Handing orientation change

    @Override
    protected void onSaveInstanceState(Bundle outBundle)
    {
        FileUtil.makeToast(AddNewItem.this, "SAVING DATA");
        super.onSaveInstanceState(outBundle);
        outBundle.putBoolean("REsultSAVED",resultSaved);
    }


    //*************************************************************************************
    // Private Methods
    //*************************************************************************************

    private void validation(Secret secret)
    {
        String fileName = displayText.getText().toString();
        if(fileName.trim().length()==0)
        {
            saveFailure("Provide some name please");
        }
        else
        {
            if(fileAlreadyExists(MainVault.getAllFileNames(),fileName))
            {
                saveFailure("File Already exists");
            }
            else {
                saveSuccess(secret);
            }
        }
    }

    private void saveFailure(String failureMsg)
    {
        FileUtil.makeToast(AddNewItem.this, failureMsg);
    }

    private void saveSuccess(Secret secret)
    {
        FileUtil.createNewSecret(secret);
        FileUtil.makeToast(AddNewItem.this, "Saved SuccessFully");
        resultSaved = true;
    }

    private boolean fileAlreadyExists(String[] allfiles,String file)
    {
        for(String fileName:allfiles)
        {
            if(fileName.equals(file)) {
                return true;
            }
        }
        return false;
    }

}
