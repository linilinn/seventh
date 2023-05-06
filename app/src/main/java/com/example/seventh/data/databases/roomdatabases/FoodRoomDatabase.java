package com.example.seventh.data.databases.roomdatabases;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.seventh.R;
import com.example.seventh.data.databases.dao.FoodDAO;
import com.example.seventh.data.databases.entities.FoodEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {FoodEntity.class}, version = 1, exportSchema = false)
public abstract class FoodRoomDatabase extends RoomDatabase {
    public abstract FoodDAO foodDAO();
    private static volatile FoodRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    public static FoodRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (FoodRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            FoodRoomDatabase.class, "food_database").addCallback(roomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }

    public static final RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(() -> {
                FoodDAO dao = INSTANCE.foodDAO();
                dao.deleteAll();
                FoodEntity food = new FoodEntity("Блюдо 1","Описание блюда 1", R.drawable.food);
                dao.insert(food);
                food = new FoodEntity("Блюдо 2","Описание блюда 2", R.drawable.food);
                dao.insert(food);
            });
        }
    };
}
