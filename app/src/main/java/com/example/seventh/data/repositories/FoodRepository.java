package com.example.seventh.data.repositories;

import androidx.lifecycle.LiveData;

import com.example.seventh.data.models.FoodModel;
import com.example.seventh.data.sources.FoodDataSource;

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
