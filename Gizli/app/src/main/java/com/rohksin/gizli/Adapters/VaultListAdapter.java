package com.rohksin.gizli.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rohksin.gizli.Activities.SeeSercretActivity;
import com.rohksin.gizli.POJO.Secret;
import com.rohksin.gizli.R;
import com.rohksin.gizli.Utility.FileUtil;

import java.util.List;

/**
 * Created by Illuminati on 8/19/2017.
 */
public class VaultListAdapter extends RecyclerView.Adapter<VaultListAdapter.VaultItem> {

    private List<Secret> secrets;
    private Context context;

    public VaultListAdapter(Context context, List<Secret> secrets )
    {
        this.secrets = secrets;
        this.context = context;
    }

    @Override
    public VaultItem onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vault_list_item,parent,false);
        VaultItem vaultItem = new VaultItem(view);
        return vaultItem;
    }

    @Override
    public void onBindViewHolder(VaultItem holder, final int position) {
          holder.name.setText((secrets.get(position)).getDisplayName());

          holder.itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent i = new Intent(context, SeeSercretActivity.class);
                  i.putExtra(FileUtil.SECRET_PASS_OBJECT,secrets.get(position));
                  context.startActivity(i);
              }
          });
    }

    @Override
    public int getItemCount() {
        return secrets.size();
    }

    public class VaultItem extends RecyclerView.ViewHolder{

        public TextView name;
        public VaultItem(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.displayName);
        }
    }
}
