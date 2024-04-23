package com.example.bmiapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerMessengerAdapter extends FragmentPagerAdapter {

    public ViewPagerMessengerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position==0){
            return new StandardFragment();
        }

        else {
            return new DerivedFragment();
        }
    }

    @Override
    public int getCount() {
        return 2; //total no of Tab we have in app
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if (position==0){
            return "Standard";
        }
        else { // for index 2
            return "Data Analysis";
        }

    }
}

