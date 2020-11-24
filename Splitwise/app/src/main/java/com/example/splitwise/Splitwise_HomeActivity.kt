package com.example.splitwise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_splitwise__home.*


class Splitwise_HomeActivity : AppCompatActivity() {
    private lateinit var fregmentAdapter_Splitwise_HomeActivity: FragmentAdapter_Splitwise_HomeActivity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splitwise__home)
        setViewPagerAdapter()
        InitializingAndsettingViewPager()


    }

    private fun InitializingAndsettingViewPager() {
        viewPagerFragmentFriends.adapter = fregmentAdapter_Splitwise_HomeActivity
        tabLayoutFragmentFriends.setupWithViewPager(viewPagerFragmentFriends)


    }

    private fun setViewPagerAdapter() {
        fregmentAdapter_Splitwise_HomeActivity = FragmentAdapter_Splitwise_HomeActivity(
            supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT

        )

    }

}