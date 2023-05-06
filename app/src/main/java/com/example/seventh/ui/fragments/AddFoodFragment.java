package com.example.seventh.ui.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.seventh.R;
import com.example.seventh.data.models.FoodModel;
import com.example.seventh.databinding.FragmentAddFoodBinding;
import com.example.seventh.ui.viewmodels.FoodViewModel;

public class AddFoodFragment extends Fragment {
    private FragmentAddFoodBinding binding;
    private FoodViewModel foodViewModel;
    public AddFoodFragment() {
        super(R.layout.fragment_add_food);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        foodViewModel = new ViewModelProvider(this).get(FoodViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddFoodBinding.inflate(inflater, container, false);
        Bundle args = getArguments();
        if (args != null && args.containsKey("RESULT_OK_FOOD") && args.containsKey("RESULT_OK_FOODDESCRIPTION")) {
            FoodModel food = new FoodModel(args.getString("RESULT_OK_FOOD"), args.getString("RESULT_OK_FOODDESCRIPTION"), R.drawable.food);
            foodViewModel.insert(food);
        }
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
