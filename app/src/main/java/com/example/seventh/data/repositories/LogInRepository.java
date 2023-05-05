package com.example.seventh.data.repositories;

import android.content.Context;

import com.example.seventh.data.sources.AppSpecificStorageLogInDataSource;
import com.example.seventh.data.sources.ExternalStorageLogInDataSource;

public class LogInRepository {
    private AppSpecificStorageLogInDataSource appSpecificStorageLogInDataSource;
    private ExternalStorageLogInDataSource externalStorageLogInDataSource;

    public LogInRepository(Context context) {
        appSpecificStorageLogInDataSource = new AppSpecificStorageLogInDataSource(context);
        externalStorageLogInDataSource = new ExternalStorageLogInDataSource(context);
    }

    public void addLogInAppSpecific(String login) {
        appSpecificStorageLogInDataSource.addLogInAppSpecific(login);
    }

    public void addLogInExternalStorage(String login) {
        externalStorageLogInDataSource.addLogInExternalStorage(login);
    }
}
