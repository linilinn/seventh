package com.example.seventh.ui.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.seventh.R;
import com.example.seventh.databinding.FragmentAddFoodBinding;

public class AddFoodFragment extends Fragment {
    private FragmentAddFoodBinding binding;
    public AddFoodFragment() {
        super(R.layout.fragment_add_food);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddFoodBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.buttonSaveFood.setOnClickListener(v -> {
            String food = binding.editTextFood.getText().toString();
            String foodDescription = binding.editTextFoodDescription.getText().toString();
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(food) && !TextUtils.isEmpty(foodDescription)) {
                binding.editTextFood.setError(null);
                bundle.putString("RESULT_OK_FOOD", food);
                bundle.putString("RESULT_OK_FOODDESCRIPTION", foodDescription);
                Navigation.findNavController(view).navigate(R.id.action_addFoodFragment_to_choose);
            }
            else if (TextUtils.isEmpty(food)) {
                binding.editTextFood.setError("Пустая строка");
            }
            else if (TextUtils.isEmpty(foodDescription)) {
                binding.editTextFoodDescription.setError("Пустая строка");
            }
            else {
                binding.editTextFood.setError("Пустая строка");
                binding.editTextFoodDescription.setError("Пустая строка");
            }
        });
    }
}
