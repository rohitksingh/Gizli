package com.rohksin.gizli.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rohksin.gizli.Fragments.CreateNewSecretFragment;
import com.rohksin.gizli.Fragments.CreateShoppingListFragment;
import com.rohksin.gizli.Fragments.CreateTODOListFragment;
import com.rohksin.gizli.POJO.Certificate;
import com.rohksin.gizli.POJO.Secret;
import com.rohksin.gizli.R;
import com.rohksin.gizli.Utility.FileUtil;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Illuminati on 9/4/2017.
 */

/*
   TODO
   MAKE FULL ACTIVITY  HIDE STATUS BAR
   ADD FRAGMENT
   SEE TRANSITION FOR FRAGMENT
 */
public class CreateSecretActivity extends AppCompatActivity {


    FragmentManager manager;

    private List<Fragment> fragments;

    private TextView creteShoppingList;
    private TextView createTodoList;

    private LinearLayout privateFiles;
    private LinearLayout publicFiles;


    @Override
    public void onCreate(Bundle savedInstaceState)
    {
        super.onCreate(savedInstaceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.create_new_secret_activity_layout);

        privateFiles = (LinearLayout)findViewById(R.id.privateFiles);
        publicFiles = (LinearLayout)findViewById(R.id.publicFiles);

        privateFiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CreateSecretActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

        setUpOptions(publicFiles, "Public\nFiles", R.drawable.ic_mode_edit_white);
        setUpOptions(privateFiles,"Private\nFiles",R.drawable.private_file_icon);

        creteShoppingList = (TextView)findViewById(R.id.creteShoppingList);
        createTodoList = (TextView)findViewById(R.id.creteTODOList);

        creteShoppingList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(fragments.get(1));
            }
        });

        createTodoList.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showFragment(fragments.get(2));
            }
        });


        ///TODO CREATE UTILITY METHOD
        setUpFragments();


        Fragment fragment = giveDefaultFragment(); //CreateNewSecretFragment.getInstance();


        manager = getSupportFragmentManager();

        showFragment(fragment);

        /*manager.beginTransaction()
                .replace(R.id.fragmentPlaceHolder,fragment)
                .commit();
                */




    }


    private void createSecret(Secret secret)
    {
        FileUtil.createNewSecret(secret);
        FileUtil.makeToast(CreateSecretActivity.this, "Saved SuccessFully");
    }

    private void setUpFragments()
    {
        fragments = new ArrayList<Fragment>();
        fragments.add(CreateNewSecretFragment.getInstance());
        fragments.add(CreateTODOListFragment.getInstance());
        fragments.add(CreateShoppingListFragment.getInstance());
    }

    private Fragment giveDefaultFragment()
    {
        return fragments.get(0);
    }

    private void showFragment(Fragment fragment)
    {
        manager.beginTransaction()
                .replace(R.id.fragmentPlaceHolder,fragment)
                .commit();
    }

    private void setUpOptions(View view,String name, int logo)
    {
        ImageView image = (ImageView)view.findViewById(R.id.optionImage);
        TextView text = (TextView)view.findViewById(R.id.optionText);

        image.setImageResource(logo);
        text.setText(name);
    }
}
