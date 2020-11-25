package com.example.splitwise.room_database_files

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.splitwise.R

class DropDownAdapter(
    private var usersList: List<User>,
    private val listener: RecyclerClickListener
) : RecyclerView.Adapter<DropDownViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DropDownViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.drop_down_icon_item_layout, parent, false)
        return DropDownViewHolder(view,listener)


    }

    override fun onBindViewHolder(holder: DropDownViewHolder, position: Int) {
        val user = usersList[position]
        holder.SetData(user)
    }

    override fun getItemCount(): Int {
        return usersList.size
    }
    fun updateData(userList: List<User>) {
        this.usersList = userList
        notifyDataSetChanged()
    }

}