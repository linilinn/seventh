/*
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

import com.example.seventh.databinding.FragmentDrinkBinding;
import com.example.seventh.ui.activities.MainActivity;
import com.example.seventh.R;
import com.example.seventh.ui.adapters.DrinkAdapter;
import com.example.seventh.ui.viewmodels.DrinkViewModel;

public class DrinkFragment extends Fragment {
    MainActivity mainActivity;
    FragmentDrinkBinding binding;
    DrinkViewModel drinkViewModel;
    public DrinkFragment() {
        super(R.layout.fragment_drink);
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drinkViewModel = new ViewModelProvider(this).get(DrinkViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDrinkBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        binding.recyclerView.setLayoutManager(layoutManager);
        DrinkAdapter drinkAdapter = new DrinkAdapter(getActivity());
        binding.recyclerView.setAdapter(drinkAdapter);
        drinkViewModel.drinks.observe(getViewLifecycleOwner(), drinks -> drinkAdapter.updateDrinks(drinks));
    }
}

 */