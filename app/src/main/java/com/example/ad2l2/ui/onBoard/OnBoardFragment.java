package com.example.ad2l2.ui.onBoard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ad2l2.R;
import com.example.ad2l2.databinding.FragmentOnBoardSBinding;
import com.example.ad2l2.utils.App;



public class OnBoardFragment extends Fragment implements onBoardListener{
 private FragmentOnBoardSBinding binding;
 private TextView[] mDots;
 public OnBoardFragment(){

 }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnBoardSBinding.inflate(inflater, container, false);
        binding.viewPager.setAdapter(new onBoardAdapter());
        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == 2){
                    binding.nextButton.setText("Finish");
                }
            }
        });
        return binding.getRoot();


    }
    public void addDotsIndicator(){
     mDots = new TextView[3];
        for (int i = 0; i <mDots.length ; i++) {

            mDots[i].setText(Html.fromHtml("&#226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            binding.mDotLayout.addView(mDots[i]);
        }
    }

    @Override
    public void onPageChanged(int position) {
        Toast.makeText(requireContext(),position,Toast.LENGTH_SHORT).show();
        binding.nextButton.setEnabled(true);
        binding.backButton.setEnabled(false);
        binding.skipButton.setEnabled(true);
        binding.backButton.setVisibility(View.INVISIBLE);

    }

}