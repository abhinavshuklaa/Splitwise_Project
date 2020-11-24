package com.example.splitwise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ViewPagerIntroActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private ViewPager2 viewPager2;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_intro);

        initViews();
        setViewPagerAdapter();


    }

    private void initViews() {
        viewPager2 = findViewById(R.id.viewPager2);
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addOnTabSelectedListener(this);
    }

    private void setViewPagerAdapter() {
        /*
        Please note that FragmentAdapter is not a inbuilt class, we need to create it.
         */
        FragmentAdapter fragmentAdapter = new FragmentAdapter(this);
        viewPager2.setAdapter(fragmentAdapter);

        /*
        A mediator to link a TabLayout with a ViewPager2. The mediator will synchronize the ViewPager2's position
         with the selected tab when a tab is selected, and the TabLayout's scroll position when the user drags the ViewPager2.
         */
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                Log.d("Lloyd", "onConfigureTab called");
            }
        }).attach();
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

}