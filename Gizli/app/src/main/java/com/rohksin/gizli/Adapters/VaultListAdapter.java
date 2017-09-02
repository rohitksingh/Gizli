package com.rohksin.gizli.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.rohksin.gizli.Activities.SeeSercretActivity;
import com.rohksin.gizli.POJO.Secret;
import com.rohksin.gizli.R;
import com.rohksin.gizli.Utility.FileUtil;

import java.util.List;

/**
 * Created by Illuminati on 8/19/2017.
 */
public class VaultListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Secret> secrets;
    private Context context;

    private static final int MAIN_GIZLI_VAULT_LAYOUT = 0;
    private static final int OTHER_ITEM = 1;



    public VaultListAdapter(Context context, List<Secret> secrets )
    {
        this.secrets = secrets;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position)
    {
        if(position==0)
            return MAIN_GIZLI_VAULT_LAYOUT;
        else
            return OTHER_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        Log.d("Custom",viewType+" inside onCreateViewHolder");

        View view =null;
        RecyclerView.ViewHolder viewHolder = null;

        if(viewType==MAIN_GIZLI_VAULT_LAYOUT)
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_gizli_certificate_layout,parent,false);
            viewHolder = new MainGizliCerificateItem(view);
        }
        else
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vault_list_item,parent,false);
            viewHolder= new VaultItem(view);
        }


       // VaultItem vaultItem = new VaultItem(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {


        Log.d("Custom"," inside onBindViewHolder");


          if(holder.getItemViewType()== MAIN_GIZLI_VAULT_LAYOUT)
          {

          }
        else {

              VaultItem vaultItemHolder = (VaultItem) holder;
              String displayText = (secrets.get(position)).getDisplayName();
              int color = vaultItemHolder.colors[position % 4];

              Log.d("Color", color + "");

              vaultItemHolder.name.setText(displayText);
              // holder.name.setTextColor(context.getColor(color));


              vaultItemHolder.placeHolder.setText(displayText.charAt(0) + "");
              vaultItemHolder.placeHolder.setBackgroundColor(context.getColor(color));

              vaultItemHolder.openButton.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Intent i = new Intent(context, SeeSercretActivity.class);
                      i.putExtra(FileUtil.SECRET_PASS_OBJECT, secrets.get(position));
                      context.startActivity(i);
                  }
              });

          }

         /* holder.itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent i = new Intent(context, SeeSercretActivity.class);
                  i.putExtra(FileUtil.SECRET_PASS_OBJECT,secrets.get(position));
                  context.startActivity(i);
              }
          });
          */
    }

    @Override
    public int getItemCount() {
        Log.d("Custom"," inside getItemCount");
        return secrets.size();
    }



    public class VaultItem extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView placeHolder;
        public Button openButton;

        public int[] colors = new int[]{
                android.R.color.holo_blue_light,
                android.R.color.holo_green_dark,
                android.R.color.holo_red_dark,
                android.R.color.holo_orange_dark
        };



        public VaultItem(View itemView) {
            super(itemView);
            Log.d("Custom", " inside Constructor");
            name = (TextView)itemView.findViewById(R.id.displayName);
            placeHolder = (TextView)itemView.findViewById(R.id.placeHolderFirstText);
            openButton = (Button)itemView.findViewById(R.id.openButton);
        }
    }

    public class MainGizliCerificateItem extends RecyclerView.ViewHolder{

        public MainGizliCerificateItem(View itemView) {
            super(itemView);
        }
    }
}
