package com.rohksin.gizli.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

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

    private boolean doubleTap = false;
    private int selectedItem = -1;


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
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        final ImageViewHolder holder1 = (ImageViewHolder)holder;

        holder1.secretImage.setImageResource(images.get(position));

        if(position == selectedItem)
        {
            holder1.itemView.setBackgroundColor(context.getColor(android.R.color.holo_green_dark));
            //holder1.secretImage.setLa
        }
        else
        {
            holder1.itemView.setBackgroundColor(context.getColor(android.R.color.holo_orange_dark));
        }


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
            secretImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (doubleTap) {
                        fragment.setVisibility(images.get(getAdapterPosition()));
                        selectedItem = getAdapterPosition();
                        notifyDataSetChanged();
                    } else {

                        doubleTap = true;
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                doubleTap = false;
                                Toast.makeText(context, "Double Tap to select Image", Toast.LENGTH_SHORT).show();
                            }
                        }, 200);

                    }

                    /// TODO WRITE A FUNCTION TO SHOW CHANGES
                }
            });

        }
    }
}

