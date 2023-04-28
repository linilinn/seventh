package com.example.seventh.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.seventh.ui.activities.MainActivity;
import com.example.seventh.R;
import com.example.seventh.databinding.FragmentItemBinding;

public class ItemFragment extends Fragment {
    MainActivity mainActivity;
    @NonNull
    FragmentItemBinding binding;

    public ItemFragment() {
        super(R.layout.fragment_item);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentItemBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view1, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view1, savedInstanceState);
        Bundle bundle2 = getArguments();
        if (bundle2 != null) {
            if (bundle2.containsKey("item")) {
                binding.textView11.setText(bundle2.getString("item"));
            }
            if (bundle2.containsKey("description")) {
                binding.textView14.setText(bundle2.getString("description"));
            }
        }
    }
}