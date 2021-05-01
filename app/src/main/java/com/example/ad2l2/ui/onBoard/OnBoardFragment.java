package com.example.ad2l2.ui.onBoard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ad2l2.R;
import com.example.ad2l2.databinding.FragmentOnBoardSBinding;
import com.example.ad2l2.utils.PrefsHelper;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.auth.FirebaseAuth;


public class OnBoardFragment extends Fragment implements onBoardListener {
    private FragmentOnBoardSBinding binding;
    private TextView[] mDots;
    private int pos = 0;
    NavController navController;

    public OnBoardFragment() {

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = NavHostFragment.findNavController(this);
        setOnClick();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnBoardSBinding.inflate(inflater, container, false);
        binding.viewPager.setAdapter(new onBoardAdapter());
        new TabLayoutMediator(binding.tabLayout, binding.viewPager, (tab, position) -> {
        }).attach();
        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == 2) {
                    binding.nextButton.setText("Finish");
                    Log.e("TAG", "onPageSelected: " + position);
                }
            }
        });
        return binding.getRoot();
    }

    public void setOnClick() {
        binding.nextButton.setOnClickListener(v -> {
            if (binding.viewPager.getCurrentItem() >= 2) {
                navController.navigate(R.id.action_onBoardFragment_to_authFragment);

                new PrefsHelper(requireContext()).setIsFirstTimeLaunch(false);
            } else {
                binding.viewPager.setCurrentItem(binding.viewPager.getCurrentItem() + 1, true);
                Log.e("TAG", "setOnClick: dsaffa" + binding.viewPager.getCurrentItem());
            }
        });
        binding.backButton.setOnClickListener(v -> {
            binding.viewPager.setCurrentItem(binding.viewPager.getCurrentItem() - 1, true);
        });
        binding.skipButton.setOnClickListener(v -> {
            if (FirebaseAuth.getInstance().getCurrentUser() == null) {
                navController.navigate(R.id.action_onBoardFragment_to_authFragment);
            }
            new PrefsHelper(requireContext()).setIsFirstTimeLaunch(false);
        });
    }

    @Override
    public void onPageChanged(int position) {
        pos = position;
        Toast.makeText(requireContext(), position, Toast.LENGTH_SHORT).show();
        binding.nextButton.setEnabled(true);
        binding.backButton.setEnabled(false);
        binding.skipButton.setEnabled(true);
        binding.backButton.setVisibility(View.INVISIBLE);

    }

}