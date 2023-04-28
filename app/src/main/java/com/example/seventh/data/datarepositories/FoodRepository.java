package com.example.seventh.data.datarepositories;

import androidx.lifecycle.LiveData;

import com.example.seventh.data.datamodels.FoodModel;
import com.example.seventh.data.datasources.FoodDataSource;

import java.util.List;

public class FoodRepository {
    private LiveData<List<FoodModel>> food;
    public FoodRepository() {
        food = FoodDataSource.createFoodList();
    }
    public LiveData<List<FoodModel>> getData() {
        return food;
    }
}
