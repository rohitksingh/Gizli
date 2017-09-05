package com.rohksin.gizli.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.ButtonBarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rohksin.gizli.R;

/**
 * Created by Illuminati on 9/5/2017.
 */
public class CreateShoppingListFragment extends Fragment {

    public static CreateShoppingListFragment getInstance()
    {
        Bundle args = new Bundle();
        CreateShoppingListFragment fragment = new CreateShoppingListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.content_main, parent, false);

        return view;
    }
}
