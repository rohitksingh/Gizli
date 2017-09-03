package com.rohksin.gizli.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rohksin.gizli.Adapters.SecretImagesAdapter;
import com.rohksin.gizli.CallBackListeners.QuestionCompleteListener;
import com.rohksin.gizli.POJO.Certificate;
import com.rohksin.gizli.R;
import com.rohksin.gizli.Utility.AppUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Illuminati on 8/27/2017.
 */
public class SetSecretImageFragment  extends Fragment implements AdapterCallBack {

    private static Certificate certificate ;
    private RecyclerView recyclerView;
    private Context context;
    private Button submitButton;
    private SecretImagesAdapter adapter;

    private QuestionCompleteListener questionCompleteListener;

    private int selectedImage;

    public static SetSecretImageFragment getInstance(Certificate certificateFromActivity)
    {
        Bundle args = new Bundle();
        SetSecretImageFragment fragment = new SetSecretImageFragment();
        fragment.setArguments(args);
        certificate = certificateFromActivity;
        return fragment;
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        this.context = context;
        questionCompleteListener = (QuestionCompleteListener)context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.secret_image_layout,parent,false);

        recyclerView = (RecyclerView)view.findViewById(R.id.secretImages);

        submitButton = (Button)view.findViewById(R.id.submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                certificate.setSecretImage(selectedImage);
                questionCompleteListener.questionComplete(certificate);
            }
        });

        GridLayoutManager glm = new GridLayoutManager(context,2);

        recyclerView.setLayoutManager(glm);

        adapter = new SecretImagesAdapter(context, AppUtil.getAllSecretImages(),this);
        recyclerView.setAdapter(adapter);

        Log.d("Certificate","Test\n"+certificate);

        return view;
    }

    @Override
    public void setVisibility(int image) {

        submitButton.setVisibility(View.VISIBLE);
        selectedImage = image;
    }



}

interface AdapterCallBack
{
    public void setVisibility(int visibility);
}
