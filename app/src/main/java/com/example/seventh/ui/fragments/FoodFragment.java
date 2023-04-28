package com.example.seventh.ui.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.seventh.databinding.FragmentFoodBinding;
import com.example.seventh.ui.activities.MainActivity;
import com.example.seventh.R;
import com.example.seventh.ui.adapters.FoodAdapter;
import com.example.seventh.ui.viewmodels.FoodViewModel;

public class FoodFragment extends Fragment {
    MainActivity mainActivity;
    FragmentFoodBinding binding;
    FoodViewModel foodViewModel;
    public FoodFragment() {
        super(R.layout.fragment_food);
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        foodViewModel = new ViewModelProvider(this).get(FoodViewModel.class);
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
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        binding.recyclerView.setLayoutManager(layoutManager);
        FoodAdapter foodAdapter = new FoodAdapter(getActivity());
        binding.recyclerView.setAdapter(foodAdapter);
        foodViewModel.food.observe(getViewLifecycleOwner(), food -> foodAdapter.updateFood(food));
    }
}