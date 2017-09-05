package com.rohksin.gizli.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.rohksin.gizli.Activities.AddNewItem;
import com.rohksin.gizli.Activities.VaultActivity;
import com.rohksin.gizli.POJO.Secret;
import com.rohksin.gizli.R;
import com.rohksin.gizli.Utility.FileUtil;

/**
 * Created by Illuminati on 9/5/2017.
 */
public class CreateNewSecretFragment extends Fragment{

    private EditText secretText;
    private Button saveButton;
    private Button savePrivateButton;
    private Button savePublic;
    private RelativeLayout savePanel;
    private TextInputLayout textInputLayout;

    private Context context;

    public static CreateNewSecretFragment getInstance()
    {
        Bundle args = new Bundle();
        CreateNewSecretFragment fragment = new CreateNewSecretFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.create_new_secret_layout, parent , false);
        secretText = (EditText)view.findViewById(R.id.secretText);

        saveButton = (Button)view.findViewById(R.id.saveButton);
        savePrivateButton = (Button)view.findViewById(R.id.savePrivate);

        savePublic = (Button)view.findViewById(R.id.savePublic);
        savePublic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, VaultActivity.class);
                context.startActivity(i);

            }
        });


        savePanel = (RelativeLayout)view.findViewById(R.id.savePanel);
        textInputLayout = (TextInputLayout)view.findViewById(R.id.displayName);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSavePanel();
            }
        });

        savePrivateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSavePanel();
                saveSecret();
            }
        });


        return view;
    }

    private void showSavePanel()
    {
        saveButton.setVisibility(View.GONE);
        savePanel.setVisibility(View.VISIBLE);
    }

    private void hideSavePanel()
    {
        saveButton.setVisibility(View.VISIBLE);
        savePanel.setVisibility(View.GONE);
    }


    public void saveSecret()
    {
        Secret secret = new Secret();
        secret.setSecret(secretText.getText().toString());
        secret.setDisplayName(textInputLayout.getEditText().getText().toString());
        FileUtil.createNewSecret(secret);
        FileUtil.makeToast(context, "Saved SuccessFully");
    }


}
