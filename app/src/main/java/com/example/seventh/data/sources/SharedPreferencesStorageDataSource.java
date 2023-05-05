package com.example.seventh.data.sources;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.File;

public class SharedPreferencesStorageDataSource {
    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SharedPreferencesStorageDataSource(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("login", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void addNameSharedPreferences(String login) {
        editor.putString("login", login);
        editor.apply();
    }

    public String getLogin(String login) {
        return sharedPreferences.getString(login, "Empty login");
    }
}