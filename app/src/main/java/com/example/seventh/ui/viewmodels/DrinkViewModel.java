package com.example.seventh.ui.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.seventh.data.DrinkModel;

import java.util.List;

public class DrinkViewModel extends ViewModel {
    public LiveData<List<DrinkModel>> drinks;
    public DrinkViewModel() {
        DrinkRepository drinkRepository = new DrinkRepository();
        drinks = drinkRepository.getData();
    }
}
