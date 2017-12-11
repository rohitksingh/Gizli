package com.rohksin.gizli.Activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rohksin.gizli.Adapters.VaultListAdapter;
import com.rohksin.gizli.POJO.Certificate;
import com.rohksin.gizli.POJO.Secret;
import com.rohksin.gizli.R;
import com.rohksin.gizli.Utility.AppUtil;
import com.rohksin.gizli.Utility.FileUtil;
import com.rohksin.gizli.Utility.MainVault;

import java.io.File;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Illuminati on 8/19/2017.
 */
public class VaultActivity extends AppCompatActivity {

    private VaultListAdapter adapter = null;

    @BindView(R.id.itemsAvailable)
    TextView itemsAvailable;

    @BindView(R.id.lastVisited)
    TextView lastVisited;

    @BindView(R.id.AddItem)
    FloatingActionButton button;

    @BindView(R.id.vaultList)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setAnimation();
        setContentView(R.layout.vault_item_list_layout);
        ButterKnife.bind(this);
        setUpUi();


    }

    //*************************************************************************************
    // Activity callback methods
    //*************************************************************************************


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1709) {
            if(resultCode == Activity.RESULT_OK){
                Toast.makeText(VaultActivity.this,"Refresing",Toast.LENGTH_LONG).show();
                setUpList();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(VaultActivity.this,"NOT refresh",Toast.LENGTH_LONG).show();
            }
        }
    }

    //*************************************************************************************
    // private methods
    //*************************************************************************************


    private void setUpUi()
    {
        FileUtil.Loader(VaultActivity.this);
        updateLastVisitedTime();
        button.setImageResource(R.drawable.ic_add_box_white);
        lastVisited.setText(getLastVisited());
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        setUpList();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VaultActivity.this,AddNewItem.class);
                startActivityForResult(i,1709);
            }
        });
    }

    private void setUpList()
    {
        List<Secret> secretList = FileUtil.getAllSecret();

        String msg = null;
        if(secretList.size() <= 1)
        {
            msg = secretList.size()+" item available";
        }
        else
        {
            msg = secretList.size()+" items available";
        }

        itemsAvailable.setText(msg);
        adapter = new VaultListAdapter(VaultActivity.this, secretList);
        recyclerView.setAdapter(adapter);
    }

    public void setAnimation()
    {
        if(Build.VERSION.SDK_INT>20) {
            Slide slide = new Slide();
            slide.setDuration(500);
            slide.setInterpolator(new AccelerateDecelerateInterpolator());
            slide.setSlideEdge(Gravity.LEFT);
            getWindow().setEnterTransition(slide);
            getWindow().setExitTransition(slide);
        }
    }

    public void updateLastVisitedTime()
    {
        Certificate certificate = FileUtil.getCertificate();
        certificate.setLastVisit(AppUtil.getCurrentTime());
        FileUtil.createCertificate(certificate);
    }

    public  String getLastVisited()
    {
        Certificate certificate = FileUtil.getCertificate();
        return certificate.getLastVisit();
    }


}
