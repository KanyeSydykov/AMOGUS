package com.example.ad2l2;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ad2l2.databinding.ActivityMainBinding;
import com.example.ad2l2.databinding.FragmentOnBoardSBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private NavController navController;
    private ActivityMainBinding binding;
   private AppBarConfiguration appBarConfiguration;
   private ArrayList<Integer> bottomList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
    appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications,R.id.navigation_profile)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        bottomList.add(R.id.navigation_home);
        bottomList.add(R.id.navigation_profile);
                bottomList.add(R.id.navigation_dashboard);
                bottomList.add(R.id.navigation_notifications);
                    navController.navigate(R.id.onBoardFragment);

                     navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
                     if (!bottomList.contains(destination.getId())) {
                         binding.navView.setVisibility(View.GONE);

         }else binding.navView.setVisibility(View.VISIBLE);
            if (destination.getId() == R.id.onBoardFragment) {
                getSupportActionBar().hide();
            }else{  getSupportActionBar().show();
        }});

        }

      public  void onPageSelected(int i ){


      }


    @Override
    public boolean onSupportNavigateUp() {


        return NavigationUI.navigateUp(navController,appBarConfiguration )|| super.onSupportNavigateUp();
    }
}