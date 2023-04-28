package com.example.seventh.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.seventh.ui.activities.MainActivity;
import com.example.seventh.R;
import com.example.seventh.databinding.FragmentStartBinding;

public class StartFragment extends Fragment {
    MainActivity mainActivity;
    @NonNull FragmentStartBinding binding;

    public StartFragment() {
        super(R.layout.fragment_start);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentStartBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view1, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view1, savedInstanceState);
        binding.button.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putString("name", binding.editTextTextPersonName.getText().toString());
            Navigation.findNavController(view).navigate(R.id.action_start2_to_logIn, bundle);
        });
    }
}
