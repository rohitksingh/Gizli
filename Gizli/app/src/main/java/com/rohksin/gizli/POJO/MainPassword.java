package com.rohksin.gizli.POJO;

/**
 * Created by Illuminati on 8/21/2017.
 */
public class MainPassword extends Secret {

    private String secretAnswer;
    private String secretQuestion;

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
}
