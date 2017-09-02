package com.rohksin.gizli.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rohksin.gizli.CallBackListeners.QuestionCompleteListener;
import com.rohksin.gizli.R;

/**
 * Created by Illuminati on 8/27/2017.
 */
public class PasswordSetFragment extends Fragment {

    private static QuestionCompleteListener listener;


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
        View view = inflater.inflate(R.layout.signup_activity_layout,parent,false);

        Button button = (Button)view.findViewById(R.id.signUpButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.questionComplete();
            }
        });
        /*
        Component logic goes here
         */
        return view;
    }

}
