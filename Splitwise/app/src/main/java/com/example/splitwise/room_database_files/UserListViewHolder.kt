package com.example.splitwise.room_database_files

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.room_database_fetch_item_layout.view.*

class UserListViewHolder(
    private val view: View,
    private val listener: RecyclerClickListener
) : RecyclerView.ViewHolder(view) {

    fun setData(user: User) {
        view.apply {
            tvNameOfFriendsFromDatabase.text = user.name
            if (tvNameOfFriendsFromDatabase.text == "abhinav shukla") {
                Glide.with(ivAvatar)
                    .load("https://firebasestorage.googleapis.com/v0/b/fir-intro-cf655.appspot.com/o/FB_IMG_1557591618924.jpg?alt=media&token=4eacfa44-9f80-497e-96f5-9cb9ecbb64d1")
                    .into(ivAvatar)
            } else if (tvNameOfFriendsFromDatabase.text == "vaibhav") {
                Glide.with(ivAvatar)
                    .load("https://firebasestorage.googleapis.com/v0/b/fir-intro-cf655.appspot.com/o/vaibhav.jpg?alt=media&token=72b7ba8a-6460-4429-81e7-75a423074371")
                    .into(ivAvatar)
            } else if (tvNameOfFriendsFromDatabase.text == "nagalaxmi") {
                Glide.with(ivAvatar)
                    .load("https://firebasestorage.googleapis.com/v0/b/fir-intro-cf655.appspot.com/o/nagalaxmi.jpg?alt=media&token=ecffe7e3-e866-4f47-aecb-7d840892c407")
                    .into(ivAvatar)
            } else if (tvNameOfFriendsFromDatabase.text == "mukesh") {
                Glide.with(ivAvatar)
                    .load("https://firebasestorage.googleapis.com/v0/b/fir-intro-cf655.appspot.com/o/mukesh.jpg?alt=media&token=b5f21d35-51db-42d0-a256-4d90a9487740")
                    .into(ivAvatar)
            }
            view.setOnClickListener{
                listener.onItemCLicked(adapterPosition,user)
            }

        }
    }
}