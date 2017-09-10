package com.rohksin.gizli.POJO;

import java.io.Serializable;

/**
 * Created by Illuminati on 9/6/2017.
 */
public class SecretMetaData implements Serializable{

    public String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
