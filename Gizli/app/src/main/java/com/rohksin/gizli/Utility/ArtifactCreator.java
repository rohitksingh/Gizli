package com.rohksin.gizli.Utility;

import android.util.Log;

import com.rohksin.gizli.POJO.MainPassword;
import com.rohksin.gizli.POJO.Secret;
import com.rohksin.gizli.POJO.SecretMetaData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Illuminati on 8/19/2017.
 */


/*
     TODO WRITE A SEPERATE METHOD FOT EDIT ARTIFACT IF IT IS NOT AN OVERHEAD , IF PERFORMANCE IS INCREASED

 */
public class ArtifactCreator {

    public static void writeArtifact(File name,Secret secret)
    {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        SecretMetaData metaData;
        try {

            File file = new File(name,secret.getDisplayName()+".txt");

            metaData = new SecretMetaData();
            metaData.setFilePath(file.toString());
            secret.setMetaData(metaData);

            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            oos = new ObjectOutputStream(fos);
            oos.writeObject(secret);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Secret readArtifact(File name)
    {
        File file = name;
        Secret secret = null;
        //List<Secret> secrets;
        try {

            FileInputStream fos = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fos);
            Object o = null;
            try {
               // while ((o = (ois.readObject())) != null) {
                     //secrets.add((Secret)o);
                secret = (Secret)ois.readObject();

            }
            catch (ClassNotFoundException e)
            {

            }
            finally {
                return secret;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }


    public static void writeMainPasswordArtifact(File name,MainPassword secret)
    {
        writeArtifact(name,secret);
    }

    public static void deleteArtifact(String path)
    {
        File file = new File(path);
        file.delete();

    }


}
