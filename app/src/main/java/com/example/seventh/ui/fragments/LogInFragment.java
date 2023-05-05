package com.example.seventh.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.seventh.ui.activities.MainActivity;
import com.example.seventh.R;
import com.example.seventh.databinding.FragmentLogInBinding;
import com.example.seventh.ui.viewmodels.LogInViewModel;

public class LogInFragment extends Fragment {
    MainActivity mainActivity;
    FragmentLogInBinding binding;
    private LogInViewModel logInViewModel;
    public LogInFragment() {
        super(R.layout.fragment_log_in);
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logInViewModel = new ViewModelProvider(this).get(LogInViewModel.class);
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
        binding.textView6.setText("Здравствуйте, " + name + "!");
        binding.button2.setOnClickListener(view -> {
            String login = binding.editTextLogin.getText().toString();

            logInViewModel.addLogInExternalStorage(login);
            logInViewModel.addLogInAppSpecific(login);
            Navigation.findNavController(view).navigate(R.id.action_logIn_to_choose);
        });
    }
}
