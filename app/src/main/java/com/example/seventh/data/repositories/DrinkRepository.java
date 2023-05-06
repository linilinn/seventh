package com.example.seventh.data.repositories;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.example.seventh.data.databases.dao.DrinkDAO;
import com.example.seventh.data.databases.entities.DrinkEntity;
import com.example.seventh.data.databases.roomdatabases.DrinkRoomDatabase;
import com.example.seventh.data.models.DrinkModel;

import java.util.List;
import java.util.stream.Collectors;

public class DrinkRepository {
    private final DrinkDAO drinkDAO;
    private final LiveData<List<DrinkModel>> allDrinks;
    private final Context context;
    private DrinkRoomDatabase drinkRoomDatabase;
    public DrinkRepository(Application applicationContext) {
        context = applicationContext;
        drinkRoomDatabase = DrinkRoomDatabase.getDatabase(context);
        drinkDAO = DrinkRoomDatabase.getDatabase(context).drinkDAO();
        allDrinks = Transformations.map(drinkDAO.getAllDrinks(), drinkEntities ->
                drinkEntities.stream().map(DrinkEntity::toDrink).collect(Collectors.toList()));
    }
    public LiveData<List<DrinkModel>> getAllDrinks() {
        return allDrinks;
    }
    public void insert(DrinkEntity drink) {
        DrinkRoomDatabase.databaseWriteExecutor.execute(() -> {
            drinkDAO.insert(drink);
        });
    }
}
