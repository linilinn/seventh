package com.example.seventh.ui.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.seventh.data.databases.entities.DrinkEntity;
import com.example.seventh.data.models.DrinkModel;
import com.example.seventh.data.repositories.DrinkRepository;

import java.util.List;
public class DrinkViewModel extends AndroidViewModel {
    private DrinkRepository repository;
    private final LiveData<List<DrinkModel>> allDrinks;
    public DrinkViewModel (Application application) {
        super(application);
        repository = new DrinkRepository(application);
        allDrinks = repository.getAllDrinks();
    }
    public LiveData<List<DrinkModel>> getAllDrinks() { return allDrinks; }
    public void insert(DrinkModel drink) { repository.insert(new DrinkEntity(drink.getDrink(),
            drink.getDrinkDescription(), drink.getImageResource())); }
}
