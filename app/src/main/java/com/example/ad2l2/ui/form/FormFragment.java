package com.example.ad2l2.ui.form;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ad2l2.R;
import com.example.ad2l2.databinding.FragmentFormBinding;

import javax.security.auth.login.LoginException;


public class FormFragment extends Fragment {
 private FragmentFormBinding binding;
 private NavController navController;
 private String s = "Поле не должно быть пустым";
private int id;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       navController = NavHostFragment.findNavController(this);
       binding = FragmentFormBinding.inflate(inflater,container,false);
         getData();
       initListeners();
        return binding.getRoot();
    }

    public void initListeners(){

        binding.buttonSave.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("name", binding.editTitle.getText().toString());
            bundle.putString("number", binding.editDescription.getText().toString());
            bundle.putInt("id", id);
            getParentFragmentManager().setFragmentResult("key",bundle);
            navController.navigateUp();
        });
    }
    public void getData(){
        getParentFragmentManager().setFragmentResultListener("2", getViewLifecycleOwner(), new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                if (requestKey.equals("2") && result != null)
                 binding.editDescription.setText(result.getString("number1"));
                binding.editTitle.setText(result.getString("name1"));

               id = result.getInt("id");
            }
        });
    }
}