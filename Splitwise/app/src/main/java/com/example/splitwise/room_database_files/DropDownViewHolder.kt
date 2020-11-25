package com.example.splitwise.room_database_files

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.drop_down_icon_item_layout.view.*

class DropDownViewHolder(private val view:View,private val listener: RecyclerClickListener):RecyclerView.ViewHolder(view) {

    fun SetData(user:User){
        view.apply {
            tvItemDropDown.text=user.name
        }
        view.setOnClickListener{
            listener.onItemCLicked(adapterPosition,user)
        }
    }
}