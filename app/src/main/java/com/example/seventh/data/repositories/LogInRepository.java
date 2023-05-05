package com.example.seventh.data.repositories;

import android.content.Context;

import com.example.seventh.data.sources.AppSpecificStorageLogInDataSource;
import com.example.seventh.data.sources.ExternalStorageLogInDataSource;
import com.example.seventh.data.sources.SharedPreferencesStorageDataSource;

public class LogInRepository {
    private AppSpecificStorageLogInDataSource appSpecificStorageLogInDataSource;
    private ExternalStorageLogInDataSource externalStorageLogInDataSource;
    private SharedPreferencesStorageDataSource sharedPreferencesStorageDataSource;

    public LogInRepository(Context context) {
        appSpecificStorageLogInDataSource = new AppSpecificStorageLogInDataSource(context);
        externalStorageLogInDataSource = new ExternalStorageLogInDataSource(context);
        sharedPreferencesStorageDataSource = new SharedPreferencesStorageDataSource(context);
    }

    public void addLogInAppSpecific(String login) {
        appSpecificStorageLogInDataSource.addLogInAppSpecific(login);
    }

    public void addLogInExternalStorage(String login) {
        externalStorageLogInDataSource.addLogInExternalStorage(login);
    }

    public void addLogInSharedPreferences(String login) {
        sharedPreferencesStorageDataSource.addNameSharedPreferences(login);
    }

    public String getLogin(String login) {
        return sharedPreferencesStorageDataSource.getLogin(login);
    }
}
