package com.example.ad2l2.ui.home;

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
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.ad2l2.R;
import com.example.ad2l2.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements Listen {
   private HomeAdapter homeAdapter;
   private int id;
    private List<HomeModel> list = new ArrayList<>();
    private NavController navController;
    private FragmentHomeBinding binding;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeAdapter = new HomeAdapter(this);

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        navController = NavHostFragment.findNavController(this);
        binding = FragmentHomeBinding.inflate(inflater, container, false);


        getDataInFrom();
        binding.rv.setAdapter(homeAdapter);
        Click();
        return binding.getRoot();

}
public void Click(){

  binding.fapAdd.setOnClickListener(v -> {
      navController.navigate(R.id.action_navigation_home_to_formFragment);
  });

}
    private void getDataInFrom(){
        //добавление
        getParentFragmentManager().setFragmentResultListener("key",
                getViewLifecycleOwner(), new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        String a = result.getString("name");
                        String b = result.getString("number");
                        int id = result.getInt("id");
                        Log.e("TAG", "onFragmentResult: " + a + b);


                        HomeModel model = homeAdapter.getModelTold(id);
                        if (model != null) {
                            model.setTitle(a);
                            model.setDescription(b);
                        }else {
                            homeAdapter.addList(new HomeModel(a,b));
                        }
                    }
                });
    }

    @Override
    public void setDatForFrom(HomeModel homeModel, int position) {
        Bundle bundle = new Bundle();
        bundle.putString("namel" , homeModel.getTitle());
        bundle.putString("number1", homeModel.getDescription());
        bundle.putInt("in", homeModel.getId());
        getParentFragmentManager().setFragmentResult("2", bundle);
        navController.navigate(R.id.action_navigation_home_to_formFragment);
    }
}
