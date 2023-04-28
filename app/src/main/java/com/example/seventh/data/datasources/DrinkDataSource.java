package com.example.seventh.data.datasources;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.seventh.R;
import com.example.seventh.data.datamodels.DrinkModel;

import java.util.ArrayList;
import java.util.List;

public class DrinkDataSource {
    public static LiveData<List<DrinkModel>> createDrinkList() {
        MutableLiveData<List<DrinkModel>> list = new MutableLiveData<>();
        ArrayList<DrinkModel> drinks = new ArrayList<>();
        for (int i = 1; i < 201; i++) {
            DrinkModel temp = new DrinkModel("Напиток " + i, "Описание напитка " + i, R.drawable.drink);
            drinks.add(temp);
        }
        list.setValue(drinks);
        return list;
    }
}
