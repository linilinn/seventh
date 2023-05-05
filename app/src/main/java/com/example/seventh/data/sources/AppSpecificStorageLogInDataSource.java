package com.example.seventh.data.sources;

import android.content.Context;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AppSpecificStorageLogInDataSource {
    private File app_specific_storage_file;

    public AppSpecificStorageLogInDataSource(Context context) {
        File app_specific_directory = context.getFilesDir();
        app_specific_storage_file = new File(app_specific_directory, "logins.txt");
    }

    public void addLogInAppSpecific(String login) {
        try {
            FileWriter writer = new FileWriter(app_specific_storage_file);
            writer.write(login);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
