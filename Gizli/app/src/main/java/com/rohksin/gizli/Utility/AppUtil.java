package com.rohksin.gizli.Utility;


import android.content.Context;
import android.widget.Toast;

import com.rohksin.gizli.POJO.MainPassword;
import com.rohksin.gizli.POJO.Secret;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Illuminati on 8/19/2017.
 */
public class AppUtil {

    public static final String SECRET_PASS_OBJECT = "com.rohksin.gizli.Utility.AppUtil.SECRET_PASS_OBJECT";

    private static final String MAIN_PASSWORD_FILE_NAME="GIZLI_MAIN_PASSWORD_FILE";

    public static void Loader(Context context)
    {
        MainVault mainVault = new MainVault(context);
    }

    public static void createNewSecret(Secret secret)
    {
        ArtifactCreator.writeArtifact(MainVault.giveCentralVault(),secret);
    }

    public static List<Secret> getAllSecret()
    {
        File[] vaultFiles = MainVault.getAllFiles();

        List<Secret> secrets = new ArrayList<Secret>();
        for(File file: vaultFiles)
        {
            secrets.add(ArtifactCreator.readArtifact(file));
        }

        return secrets;
    }

    public static List<Secret> getDummySecret()
    {
        List<Secret> secrets = new ArrayList<Secret>();

        for(int i=0;i<10;i++)
        {
            Secret secret = new Secret();
            secret.setDisplayName("Secret"+i);
            secret.setDescription("HDFC"+i);
            secret.setSecret("Password"+i);
            secrets.add(secret);
        }
        return secrets;
    }

    public static void makeToast(Context context,String msg)
    {
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }

    public static void setUpUser(MainPassword mainPassword)
    {
        mainPassword.setDisplayName(MAIN_PASSWORD_FILE_NAME);
        ArtifactCreator.writeMainPasswordArtifact(MainVault.giveCentralVault(),mainPassword);
    }


    private boolean mainPasswordExists()
    {
        String[] files = MainVault.getAllFileNames();
        for(String file: files)
        {
            if(file.equals(MAIN_PASSWORD_FILE_NAME))
            {
                return true;
            }
        }
        return false;
    }




}
