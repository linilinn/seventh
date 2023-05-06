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
import com.example.seventh.data.models.DrinkModel;
import com.example.seventh.databinding.FragmentAddDrinkBinding;
import com.example.seventh.ui.viewmodels.DrinkViewModel;

public class AddDrinkFragment extends Fragment {
    private FragmentAddDrinkBinding binding;
    private DrinkViewModel drinkViewModel;
    public AddDrinkFragment() {
        super(R.layout.fragment_add_drink);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drinkViewModel = new ViewModelProvider(this).get(DrinkViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddDrinkBinding.inflate(inflater, container, false);
        Bundle args = getArguments();
        if (args != null && args.containsKey("RESULT_OK_DRINK") && args.containsKey("RESULT_OK_DRINKDESCRIPTION")) {
            DrinkModel drink = new DrinkModel(args.getString("RESULT_OK_DRINK"), args.getString("RESULT_OK_DRINKDESCRIPTION"), R.drawable.drink);
            drinkViewModel.insert(drink);
        }
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.buttonSaveDrink.setOnClickListener(v -> {
            String drink = binding.editTextDrink.getText().toString();
            String drinkDescription = binding.editTextDrinkDescription.getText().toString();
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(drink) && !TextUtils.isEmpty(drinkDescription)) {
                binding.editTextDrink.setError(null);
                bundle.putString("RESULT_OK_DRINK", drink);
                bundle.putString("RESULT_OK_DRINKDESCRIPTION", drinkDescription);
                Navigation.findNavController(view).navigate(R.id.action_addDrinkFragment_to_choose);
            }
            else if (TextUtils.isEmpty(drink)) {
                binding.editTextDrink.setError("Пустая строка");
            }
            else if (TextUtils.isEmpty(drinkDescription)) {
                binding.editTextDrinkDescription.setError("Пустая строка");
            }
            else {
                binding.editTextDrink.setError("Пустая строка");
                binding.editTextDrinkDescription.setError("Пустая строка");
            }
        });
    }
}
