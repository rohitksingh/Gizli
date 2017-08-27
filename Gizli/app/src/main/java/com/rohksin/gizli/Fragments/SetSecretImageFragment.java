package com.rohksin.gizli.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rohksin.gizli.R;

/**
 * Created by Illuminati on 8/27/2017.
 */
public class SetSecretImageFragment  extends Fragment {

    public static SetSecretImageFragment getInstance()
    {
        Bundle args = new Bundle();
        SetSecretImageFragment fragment = new SetSecretImageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.secret_image_layout,parent,false);

        /*
        Component logic goes here
         */
        return view;
    }

}
