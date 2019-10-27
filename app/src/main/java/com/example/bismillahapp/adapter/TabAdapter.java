package com.example.bismillahapp.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.bismillahapp.fragment.LaundryCustomer;
import com.example.bismillahapp.fragment.LaundryHotel;

public class TabAdapter extends FragmentPagerAdapter {
    private String[] mTitle = new String[]{"Laundry Customer", "Laundry Hotel"};
    private Context context;

    public TabAdapter(@NonNull FragmentManager fm, Context context1) {
        super(fm); /*DEPRECATED WOIIII*/
        context = context1;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                return new LaundryCustomer();
            case 1:
                return new LaundryHotel();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mTitle.length;
    }
}
