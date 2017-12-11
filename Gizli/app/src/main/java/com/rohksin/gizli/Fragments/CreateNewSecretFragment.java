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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rohksin.gizli.Activities.VaultActivity;
import com.rohksin.gizli.CallBackListeners.SaveDialogListener;
import com.rohksin.gizli.POJO.Secret;
import com.rohksin.gizli.R;
import com.rohksin.gizli.Dialog.SaveDialog;
import com.rohksin.gizli.Utility.FileUtil;

/**
 * Created by Illuminati on 9/5/2017.
 */
public class CreateNewSecretFragment extends Fragment implements SaveDialogListener {

    private EditText secretText;
    private LinearLayout saveButton;
    private TextInputLayout textInputLayout;
    private LinearLayout clearAll;
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
        saveButton = (LinearLayout)view.findViewById(R.id.saveButton);
        clearAll = (LinearLayout)view.findViewById(R.id.clearAll);
        setOptions(clearAll,"Clear All",R.drawable.clear_all_icon);
        setOptions(saveButton,"Save",R.drawable.clear_all_icon);

        textInputLayout = (TextInputLayout)view.findViewById(R.id.displayName);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveDialog dialog = new SaveDialog(context, CreateNewSecretFragment.this);
                dialog.show();
            }
        });

        clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secretText.setText("");
            }
        });

        return view;
    }

    public void saveSecret(String displayName)
    {
        Secret secret = new Secret();
        secret.setSecret(secretText.getText().toString());
        secret.setDisplayName(displayName);
        FileUtil.createNewSecret(secret);
        FileUtil.makeToast(context, "Saved SuccessFully");
    }

    @Override
    public void savePublic(String name) {
        Intent i = new Intent(context, VaultActivity.class);
        context.startActivity(i);
    }

    @Override
    public void savePrivate(String name) {
        saveSecret(name);
    }


    private void setOptions(View view,String name, int icon)
    {
        ImageView iconImage = (ImageView)view.findViewById(R.id.optionImage);
        TextView iconText = (TextView)view.findViewById(R.id.optionText);
        iconImage.setImageResource(icon);
        iconText.setText(name);
    }
}

