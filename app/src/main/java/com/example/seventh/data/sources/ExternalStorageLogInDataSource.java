package com.example.seventh.data.sources;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExternalStorageLogInDataSource {
    private File external_storage_file;
    private Context context;

    public ExternalStorageLogInDataSource(Context context) {
        this.context = context;
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            external_storage_file = new File(Environment.getExternalStorageDirectory(), "new_logins.txt");
        } else {
            ActivityCompat.requestPermissions((Activity)context, new String[]
                    {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
    }

    public void addLogInExternalStorage(String login) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            try {
                FileWriter writer = new FileWriter(external_storage_file);
                writer.write(login);
                writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            ActivityCompat.requestPermissions((Activity)context, new String[]
                    {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
    }
}
