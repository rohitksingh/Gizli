package com.rohksin.gizli.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rohksin.gizli.R;

import java.util.ArrayList;

/**
 * Created by Illuminati on 9/5/2017.
 */
public class CreateTODOListFragment extends Fragment {

    public static CreateTODOListFragment getInstance()
    {
        Bundle args = new Bundle();
        CreateTODOListFragment fragment = new CreateTODOListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.activity_main,parent,false);
        return view;
    }
}
