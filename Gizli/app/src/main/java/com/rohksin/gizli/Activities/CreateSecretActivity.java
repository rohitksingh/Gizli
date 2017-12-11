package com.rohksin.gizli.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rohksin.gizli.Fragments.CreateNewSecretFragment;
import com.rohksin.gizli.Fragments.CreateShoppingListFragment;
import com.rohksin.gizli.Fragments.CreateTODOListFragment;
import com.rohksin.gizli.POJO.Secret;
import com.rohksin.gizli.R;
import com.rohksin.gizli.Utility.FileUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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

    @BindView(R.id.creteShoppingList)
    TextView creteShoppingList;

    @BindView(R.id.creteTODOList)
    TextView createTodoList;

    @BindView(R.id.privateFiles)
    LinearLayout privateFiles;

    @BindView(R.id.publicFiles)
    LinearLayout publicFiles;

    @Override
    public void onCreate(Bundle savedInstaceState)
    {
        super.onCreate(savedInstaceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.create_new_secret_activity_layout);
        ButterKnife.bind(this);
        setUpUi();
    }


    //*************************************************************************************
    // Private Methods
    //*************************************************************************************

    private void setUpUi()
    {
        setUpOptions(publicFiles, "Public\nFiles", R.drawable.ic_mode_edit_white);
        setUpOptions(privateFiles,"Private\nFiles",R.drawable.private_file_icon);

        privateFiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CreateSecretActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

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
