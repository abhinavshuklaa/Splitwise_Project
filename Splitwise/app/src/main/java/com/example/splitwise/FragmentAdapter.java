package com.example.splitwise;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentAdapter extends FragmentStateAdapter {
    public FragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return Fragment_1.newInstance();
            case 1:
                return Fragment_2.newInstance();
            case 2:
                return Fragment_3.newInstance();
            case 3:
                return Fragment_4.newInstance();
        }
        return Fragment_1.newInstance();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
