package com.example.ad2l2.ui.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ad2l2.R;
import com.example.ad2l2.databinding.FragmentDashboardBinding;
import com.example.ad2l2.ui.home.FireBaseModel;
import com.example.ad2l2.ui.home.HomeAdapter;
import com.example.ad2l2.ui.home.HomeModel;
import com.example.ad2l2.ui.home.Listen;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment implements Listen {

 private FragmentDashboardBinding binding;
private HomeAdapter adapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new HomeAdapter(this);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDashboardBinding.inflate( inflater,container,false);
        binding.recyclerView.setAdapter(adapter);
        setFirestoreData();
        return binding.getRoot();
    }

    private void setFirestoreData() {
        FirebaseFirestore.getInstance().collection("Karl").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                List<HomeModel> list = task.getResult().toObjects(HomeModel.class);
                adapter.addItemList(list);
            } else {
                Toast.makeText(requireContext(), task.getException().getMessage() , Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void setDatForFrom(HomeModel homeModel, int position) {

    }

    @Override
    public void del(int position) {

    }
}