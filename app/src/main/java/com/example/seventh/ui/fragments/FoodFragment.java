package com.example.seventh.ui.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.seventh.ui.activities.MainActivity;
import com.example.seventh.R;
import com.example.seventh.data.datamodels.FoodModel;
import com.example.seventh.ui.adapters.FoodAdapter;
import com.example.seventh.databinding.FragmentFoodBinding;

import java.util.ArrayList;
import java.util.List;

public class FoodFragment extends Fragment {
    MainActivity mainActivity;
    FragmentFoodBinding binding;
    FragmentManager fragmentManager;
    public FoodFragment() {
        super(R.layout.fragment_food);
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFoodBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        generateElements();
    }

    private void generateElements() {
        List<FoodModel> food = new ArrayList<>();
        for (int i = 1; i <= 200; i++) {
            FoodModel temp = new FoodModel("Блюдо " + i, "Описание блюда " + i, R.drawable.food);
            food.add(temp);
        }
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mainActivity, RecyclerView.VERTICAL, false);
        binding.recyclerView.setLayoutManager(layoutManager);
        FoodAdapter foodAdapter = new FoodAdapter(food);
        binding.recyclerView.setAdapter(foodAdapter);
    }
}