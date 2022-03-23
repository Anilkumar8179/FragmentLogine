package com.anilkumar.fragmentlogine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CallbackFragment {

    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFragment();

        rePlaceFragment();
    }

    public void addFragment() {

     FragmentLogin   fragment = new FragmentLogin();
     fragment.setCallbackFragment(this);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.action_bar_container, fragment);
        fragmentTransaction.commit();

    }

    public void rePlaceFragment() {

       fragment = new FragmentRegistration();
       fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.add(R.id.action_bar_container, fragment);
        fragmentTransaction.commit();

    }

    @Override
    public void changeFragment() {
        rePlaceFragment();
    }
}