package com.example.seventh.data.databases.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.seventh.data.databases.entities.FoodEntity;

import java.util.List;

public interface FoodDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(FoodEntity foodItem);
    @Query("DELETE FROM food_table")
    void deleteAll();
    @Query("SELECT * FROM food_table ORDER BY food")
    LiveData<List<FoodEntity>> getAllFood();
}
