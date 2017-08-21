package com.rohksin.gizli.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rohksin.gizli.R;
import com.rohksin.gizli.Utility.MainVault;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText text = (EditText)findViewById(R.id.vaultPassword);
        Button button = (Button)findViewById(R.id.Submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result = MainVault.passwordCorrect(text.getText()+"");
                if(result==true)
                {
                   // Toast.makeText(MainActivity.this,"Login SuccessFul",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(MainActivity.this,VaultActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(MainActivity.this,"Incorrect Password",Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
