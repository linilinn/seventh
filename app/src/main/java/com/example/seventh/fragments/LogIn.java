package com.example.seventh.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.Navigation;

import com.example.seventh.MainActivity;
import com.example.seventh.R;
import com.example.seventh.databinding.FragmentLogInBinding;

public class LogIn extends Fragment {
    MainActivity mainActivity;
    FragmentLogInBinding binding;
    FragmentManager fragmentManager;
    public LogIn() {
        super(R.layout.fragment_log_in);
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLogInBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view1, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view1, savedInstanceState);
        Bundle bundle1 = getArguments();
        String name = bundle1.getString("name");
        binding.textView6.setText("Здравствуйте, " + bundle1.getString("name") + "!");
        binding.button2.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_logIn_to_choose);
        });
    }
}
