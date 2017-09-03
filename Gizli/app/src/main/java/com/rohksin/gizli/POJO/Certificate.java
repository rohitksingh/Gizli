package com.rohksin.gizli.POJO;

/**
 * Created by Illuminati on 8/24/2017.
 */
public class Certificate extends Secret {

    private String secretAnswer;
    private String secretQuestion;
    private String lastVisit;

    public int getSecretImage() {
        return secretImage;
    }

    public void setSecretImage(int secretImage) {
        this.secretImage = secretImage;
    }

    private int secretImage;

    public String getSecretQuestion() {
        return secretQuestion;
    }

    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
    }

    public String getSecretAnswer() {
        return secretAnswer;
    }

    public void setSecretAnswer(String secretAnswer) {
        this.secretAnswer = secretAnswer;
    }

    public String getLastVisit()
    {
        return lastVisit;
    }

    public void setLastVisit(String lastVisit)
    {
        this.lastVisit = lastVisit;
    }

    @Override
    public String toString()
    {
        return this.getDisplayName()+ "\n" + this.getSecret() + "\n"+ lastVisit + "\n" + secretQuestion + "\n" + secretAnswer + "\n" + secretImage ;
    }
}
