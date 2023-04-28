package com.example.seventh.data.datarepositories;

import androidx.lifecycle.LiveData;

import com.example.seventh.data.datamodels.DrinkModel;
import com.example.seventh.data.datasources.DrinkDataSource;

import java.util.List;

public class DrinkRepository {
    private LiveData<List<DrinkModel>> drinks;
    public DrinkRepository() {
        drinks = DrinkDataSource.createDrinkList();
    }
    public LiveData<List<DrinkModel>> getData() {
        return drinks;
    }
}
