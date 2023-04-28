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
import com.example.seventh.ui.DrinkModel;
import com.example.seventh.ui.adapters.DrinkAdapter;
import com.example.seventh.databinding.FragmentFoodBinding;

import java.util.ArrayList;
import java.util.List;

public class Drink extends Fragment {
    MainActivity mainActivity;
    FragmentFoodBinding binding;
    FragmentManager fragmentManager;
    public Drink() {
        super(R.layout.fragment_drink);
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
        List<DrinkModel> drink = new ArrayList<>();
        for (int i = 1; i <= 200; i++) {
            DrinkModel temp = new DrinkModel("Напиток " + i, "Описание напитка " + i, R.drawable.food);
            drink.add(temp);
        }
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mainActivity, RecyclerView.VERTICAL, false);
        binding.recyclerView.setLayoutManager(layoutManager);
        DrinkAdapter drinkAdapter = new DrinkAdapter(drink);
        binding.recyclerView.setAdapter(drinkAdapter);
    }
}