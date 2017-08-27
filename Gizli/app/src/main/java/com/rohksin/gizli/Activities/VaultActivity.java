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

/**
 * Created by Illuminati on 8/19/2017.
 */
public class VaultActivity extends AppCompatActivity {

    private RecyclerView recyclerView = null;
    private VaultListAdapter adapter = null;

    private TextView itemsAvailable;
    private TextView lastVisited;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.valut_layout);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setAnimation();

        setContentView(R.layout.vault_item_list_layout);

        Log.d("Current time", AppUtil.getCurrentTime());


        FileUtil.Loader(VaultActivity.this);
        //TextView textView = (TextView)findViewById(R.id.TotalItems);
        FloatingActionButton button = (FloatingActionButton)findViewById(R.id.AddItem);

        button.setImageResource(R.drawable.ic_add_box_white);

        itemsAvailable = (TextView)findViewById(R.id.itemsAvailable);
        lastVisited = (TextView)findViewById(R.id.lastVisited);
        lastVisited.setText(getLastVisited());

        updateLastVisitedTime();

        recyclerView = (RecyclerView)findViewById(R.id.vaultList);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        setUpList();


        //textView.setText(MainVault.getAllFileNames().length+" items currently");
        Log.d("Items", MainVault.getAllFileNames().length + "items");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VaultActivity.this,AddNewItem.class);
                startActivityForResult(i,1709);
            }
        });
    }

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

    private void setUpList()
    {
        List<Secret> secretList = FileUtil.getAllSecret();
        //Collections.sort(secretList);

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
