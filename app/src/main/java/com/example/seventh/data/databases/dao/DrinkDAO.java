package com.example.seventh.data.databases.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.seventh.data.databases.entities.DrinkEntity;

import java.util.List;

public interface DrinkDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(DrinkEntity drinkItem);
    @Query("DELETE FROM drink_table")
    void deleteAll();
    @Query("SELECT * FROM drink_table ORDER BY drink")
    LiveData<List<DrinkEntity>> getAllDrinks();
}
