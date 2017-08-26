package com.rohksin.gizli.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.rohksin.gizli.Adapters.VaultListAdapter;
import com.rohksin.gizli.R;
import com.rohksin.gizli.Utility.FileUtil;
import com.rohksin.gizli.Utility.MainVault;

/**
 * Created by Illuminati on 8/19/2017.
 */
public class VaultActivity extends AppCompatActivity {

    private RecyclerView recyclerView = null;
    private VaultListAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.valut_layout);
        FileUtil.Loader(VaultActivity.this);
        TextView textView = (TextView)findViewById(R.id.TotalItems);
        Button button = (Button)findViewById(R.id.AddItem);
        recyclerView = (RecyclerView)findViewById(R.id.vaultList);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        setUpList();


        textView.setText(MainVault.getAllFileNames().length+" items currently");
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
        adapter = new VaultListAdapter(VaultActivity.this, FileUtil.getAllSecret());
        recyclerView.setAdapter(adapter);
    }


}
