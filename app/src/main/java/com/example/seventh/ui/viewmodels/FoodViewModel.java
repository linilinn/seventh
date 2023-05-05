package com.example.seventh.ui.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.seventh.data.models.FoodModel;
import com.example.seventh.data.repositories.FoodRepository;

import java.util.List;

public class FoodViewModel extends ViewModel {
    public LiveData<List<FoodModel>> food;
    public FoodViewModel() {
        FoodRepository foodRepository = new FoodRepository();
        food = foodRepository.getData();
    }
}
