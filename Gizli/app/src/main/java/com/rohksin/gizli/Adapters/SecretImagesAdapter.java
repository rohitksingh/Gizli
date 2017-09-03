package com.rohksin.gizli.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.rohksin.gizli.Fragments.SetSecretImageFragment;
import com.rohksin.gizli.R;

import java.util.List;

/**
 * Created by Illuminati on 9/2/2017.
 */
public class SecretImagesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Integer> images;
    private Context context;
    private SetSecretImageFragment fragment;


    public SecretImagesAdapter(Context context, List<Integer> images ,Fragment fragment)
    {
        this.images = images;
        this.context = context;
        this.fragment = (SetSecretImageFragment)fragment;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.single_secret_image_layout,parent,false);
        RecyclerView.ViewHolder holder = new ImageViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final ImageViewHolder holder1 = (ImageViewHolder)holder;

        holder1.secretImage.setImageResource(images.get(position));

        holder1.secretImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.setVisibility(0);
                holder1.secretImage.setBackgroundColor(context.getColor(android.R.color.holo_green_dark));

                /// TODO WRITE A FUNCTION TO SHOW CHANGES
            }
        });

    }

    @Override
    public int getItemCount() {
        return images.size();
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder{

        private ImageView secretImage;


        public ImageViewHolder(View itemView) {
            super(itemView);
            secretImage = (ImageView)itemView.findViewById(R.id.secretImage);
        }
    }
}


/// Can i  get referrence to attached Fragment ?