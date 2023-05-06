package com.example.seventh.data.databases.roomdatabases;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.seventh.R;
import com.example.seventh.data.databases.dao.DrinkDAO;
import com.example.seventh.data.databases.entities.DrinkEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {DrinkEntity.class}, version = 1, exportSchema = false)
public abstract class DrinkRoomDatabase extends RoomDatabase {
    public abstract DrinkDAO drinkDAO();
    private static volatile DrinkRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    public static DrinkRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DrinkRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DrinkRoomDatabase.class, "drink_database").addCallback(roomDatabaseCallback).build();
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
                DrinkDAO dao = INSTANCE.drinkDAO();
                dao.deleteAll();
                DrinkEntity drink = new DrinkEntity("Напиток 1","Описание напитка 1", R.drawable.drink);
                dao.insert(drink);
                drink = new DrinkEntity("Напиток 2","Описание напитка 2", R.drawable.drink);
                dao.insert(drink);
            });
        }
    };
}
