package com.example.seventh.ui.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.example.seventh.data.repositories.LogInRepository;

public class LogInViewModel extends AndroidViewModel {
    private LogInRepository logInRepository;

    public LogInViewModel(Application application) {
        super(application);
        logInRepository = new LogInRepository(application);
    }

    public void addLogInAppSpecific(String login) {
        logInRepository.addLogInAppSpecific(login);
    }

    public void addLogInExternalStorage(String login) {
        logInRepository.addLogInExternalStorage(login);
    }

    public void addLogInSharedPreferences(String login) {
        logInRepository.addLogInSharedPreferences(login);
    }

    public String getLogin(String login) {
        return logInRepository.getLogin(login);
    }
}
