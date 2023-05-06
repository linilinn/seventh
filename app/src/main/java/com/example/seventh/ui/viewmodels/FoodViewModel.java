package com.example.seventh.ui.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.seventh.data.databases.entities.FoodEntity;
import com.example.seventh.data.models.FoodModel;
import com.example.seventh.data.repositories.FoodRepository;

import java.util.List;
public class FoodViewModel extends AndroidViewModel {
    private FoodRepository repository;
    private final LiveData<List<FoodModel>> allFood;
    public FoodViewModel (Application application) {
        super(application);
        repository = new FoodRepository(application);
        allFood = repository.getAllFood();
    }
    public LiveData<List<FoodModel>> getAllFood() { return allFood; }
    public void insert(@NonNull FoodModel food) { repository.insert(new FoodEntity(food.getFood(),
            food.getFoodDescription(), food.getImageResource())); }
}
