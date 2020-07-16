package com.example.taypoyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemReselectedListener;
import Fragments.GameFragment;
import Fragments.HomeFragment;
import Fragments.ProfileFragment;
import Fragments.RecipesFragment;

public class FragMain extends AppCompatActivity {

    BottomNavigationView mBottomNavigation;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_main);
        showSelectedFragment(new HomeFragment());
        MediaController mediaController= new MediaController(this);
        videoView=findViewById(R.id.vid);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/taypoy-a6ce0.appspot.com/o/ADOBO%20DE%20CHANCHO%20%20RECETA%20PERUANA%20%20Sazn%20y%20Corazn.mp4?alt=media&token=3a1ed70d-1a6b-4253-b99c-3f7849ea1c3e");
        videoView.setVideoURI(uri);
        videoView.start();
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
}