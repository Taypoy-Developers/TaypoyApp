package com.example.taypoyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import Fragments.GameFragment;
import Fragments.HomeFragment;
import Fragments.ProfileFragment;
import Fragments.RecipesFragment;

public class FragMain extends AppCompatActivity {

    BottomNavigationView mBottomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_main);
        showSelectedFragment(new HomeFragment());

        mBottomNavigation = (BottomNavigationView) findViewById(R.id.bottomNavigation);

        mBottomNavigation.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            /*ESTO DEBERIA SER UN VOID*/
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

                if(menuItem.getItemId() == R.id.menu_home){
                    showSelectedFragment(new HomeFragment());
                }
                if(menuItem.getItemId() == R.id.menu_profile){
                    showSelectedFragment(new ProfileFragment());
                }
                if(menuItem.getItemId() == R.id.menu_recipes){
                    showSelectedFragment(new RecipesFragment());
                }
                if(menuItem.getItemId() == R.id.menu_game){
                    showSelectedFragment(new GameFragment());
                }
                /*return true;*/
            }
        });
    }

    /*Metodo que permite elegir el fragment*/
    private void showSelectedFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}