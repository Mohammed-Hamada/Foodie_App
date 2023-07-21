package com.example.fooddelivery.UI;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.fooddelivery.Fragment.FavoriteFragment;
import com.example.fooddelivery.Fragment.HomeFragment;
import com.example.fooddelivery.Fragment.ProfileFragment;
import com.example.fooddelivery.Fragment.ShopFragment;
import com.example.fooddelivery.R;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class HomePage extends AppCompatActivity {

    private ChipNavigationBar navigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        navigationBar = findViewById(R.id.bottom_menu);
        HomeFragment homeFragment = new HomeFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.
                beginTransaction().
                replace(R.id.fragment_container, homeFragment).
                commit();
        navigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i) {
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.profile:
                        fragment = new ProfileFragment();
                        break;
                    case R.id.shop:
                        fragment = new ShopFragment();
                        navigationBar.showBadge(R.id.shop);

                        break;
                    case R.id.favorites:
                        fragment = new FavoriteFragment();
                        break;
//                    case R.id.settings:
//                        fragment=new SettingFragment();
//                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        });
    }
}
