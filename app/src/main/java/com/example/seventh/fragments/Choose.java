package com.example.seventh.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.seventh.MainActivity;
import com.example.seventh.R;
import com.example.seventh.databinding.FragmentChooseBinding;

public class Choose extends Fragment {
    FragmentChooseBinding binding;
    MainActivity mainActivity;
    public Choose() {
        super(R.layout.fragment_choose);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentChooseBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view1, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view1, savedInstanceState);
        binding.button3.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_choose_to_drink);
        });
        binding.button4.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_choose_to_food);
        });
    }
}