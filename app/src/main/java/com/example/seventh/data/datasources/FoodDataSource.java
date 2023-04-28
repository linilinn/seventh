package com.example.seventh.data.datasources;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.seventh.R;
import com.example.seventh.data.datamodels.FoodModel;

import java.util.ArrayList;
import java.util.List;

public class FoodDataSource {
    public static LiveData<List<FoodModel>> createFoodList() {
        MutableLiveData<List<FoodModel>> list = new MutableLiveData<>();
        ArrayList<FoodModel> food = new ArrayList<>();
        for (int i = 1; i < 201; i++) {
            FoodModel temp = new FoodModel("Блюдо " + i, "Описание блюда " + i, R.drawable.food);
            food.add(temp);
        }
        list.setValue(food);
        return list;
    }
}
