package com.example.seventh.data.datarepositories;

import androidx.lifecycle.LiveData;

import com.example.seventh.data.datamodels.DrinkModel;
import com.example.seventh.ui.fragments.Drink;

import java.util.List;

public class DrinkRepository {
    private LiveData<List<DrinkModel>> drinks;
    public DrinkRepository() {
        //drinks = DrinkDataSource.createList();
    }
    public LiveData<List<DrinkModel>> gerData() {
        return drinks;
    }
}
