package com.example.seventh.data.repositories;

import androidx.lifecycle.LiveData;

import com.example.seventh.data.models.DrinkModel;
import com.example.seventh.data.sources.DrinkDataSource;

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
