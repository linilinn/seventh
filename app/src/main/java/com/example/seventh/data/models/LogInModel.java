package com.example.seventh.data.models;

public class LogInModel {
    private String login;

    public LogInModel() {
        this("Empty login");
    }

    public LogInModel(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}
