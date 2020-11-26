package com.example.splitwise

import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.splitwise.room_database_files.TransactionFragment

class FragmentAdapter_Splitwise_HomeActivity(fm: FragmentManager, behavior: Int) :

    FragmentStatePagerAdapter(fm, behavior) {

    override fun getCount(): Int {
        return 3

    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0->{
                return Friends_Fragment.newInstance("This is friends Fragment","FriendsFragment")
            }
            1->{
                return Friends_Fragment.newInstance("This is friends Fragment","FriendsFragment")

            }
            2->{
                return TransactionFragment.newInstance("This is Transaction Fragment","TransactionFragment")

            }
        }
        return Friends_Fragment.newInstance("This is friends Fragment","FriendsFragment")

    }

    @Nullable
    override fun getPageTitle(position: Int): CharSequence? {
        var tabTitle = ""
        tabTitle = when (position) {
            0 -> "FRIENDS"
            1 -> "GROUPS"
            2 -> "ACTIVITY"
            else -> "TAB - n"
        }
        return tabTitle
    }
}