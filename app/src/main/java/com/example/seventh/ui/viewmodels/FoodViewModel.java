package com.example.seventh.ui.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.seventh.data.datamodels.FoodModel;
import com.example.seventh.data.datarepositories.FoodRepository;

import java.util.List;

public class FoodViewModel extends ViewModel {
    public LiveData<List<FoodModel>> food;
    public FoodViewModel() {
        FoodRepository foodRepository = new FoodRepository();
        food = foodRepository.getData();
    }
}
