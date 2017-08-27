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
public class PasswordSetFragment extends Fragment {

    public static PasswordSetFragment getInstance()
    {
        Bundle args = new Bundle();
        PasswordSetFragment fragment = new PasswordSetFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.password_set_fragment,parent,false);

        /*
        Component logic goes here
         */
        return view;
    }

}
