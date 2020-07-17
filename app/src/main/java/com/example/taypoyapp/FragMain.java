package com.example.taypoyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.ReceiverCallNotAllowedException;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemReselectedListener;
import Fragments.GameFragment;
import Fragments.HomeFragment;
import Fragments.ProfileFragment;
import Fragments.RecipesFragment;

public class FragMain extends AppCompatActivity implements SendMessage {

    BottomNavigationView mBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_main);
        showSelectedFragment(new HomeFragment());
        MediaController mediaController= new MediaController(this);
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        getSupportFragmentManager().beginTransaction().add(R.id.for_message, new HomeFragment()).commit();


        mBottomNavigation = (BottomNavigationView) findViewById(R.id.bottomNavigation);

        mBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
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
                return true;
            }
        });
    }

    /*Metodo que permite elegir el fragment*/
    private void showSelectedFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    @Override
    public void sendData(String message) {
        RecipesFragment recipesFragment = (RecipesFragment) getSupportFragmentManager().findFragmentById(R.id.container);
        recipesFragment.getDataFragments(message);


    }
}