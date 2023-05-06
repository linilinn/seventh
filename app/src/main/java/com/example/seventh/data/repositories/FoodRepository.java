package com.example.seventh.data.repositories;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.example.seventh.data.databases.dao.FoodDAO;
import com.example.seventh.data.databases.entities.FoodEntity;
import com.example.seventh.data.databases.roomdatabases.FoodRoomDatabase;
import com.example.seventh.data.models.FoodModel;
import com.example.seventh.data.sources.FoodDataSource;

import java.util.List;
import java.util.stream.Collectors;

public class FoodRepository {
    private final FoodDAO foodDAO;
    private final LiveData<List<FoodModel>> allFood;
    private final Context context;
    private FoodRoomDatabase foodRoomDatabase;
    public FoodRepository(Application applicationContext) {
        context = applicationContext;
        foodRoomDatabase = FoodRoomDatabase.getDatabase(context);
        foodDAO = FoodRoomDatabase.getDatabase(context).foodDAO();
        allFood = Transformations.map(foodDAO.getAllFood(), foodEntities ->
                foodEntities.stream().map(FoodEntity::toFood).collect(Collectors.toList()));
    }
    public LiveData<List<FoodModel>> getAllFood() {
        return allFood;
    }
    public void insert(FoodEntity food) {
        FoodRoomDatabase.databaseWriteExecutor.execute(() -> {
            foodDAO.insert(food);
        });
    }
}
