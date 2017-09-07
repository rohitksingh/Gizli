package com.rohksin.gizli.POJO;

import java.io.Serializable;

/**
 * Created by Illuminati on 8/19/2017.
 */

/*
     Add cretion date , Last modified or may be keep the history of edits
     V 1.01

 */
public class Secret implements Serializable{


    private String displayName;
    private String description;
    private String secret;

    public SecretMetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(SecretMetaData metaData) {
        this.metaData = metaData;
    }

    private SecretMetaData metaData;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
