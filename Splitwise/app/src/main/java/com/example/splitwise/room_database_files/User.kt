package com.example.splitwise.room_database_files

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class User(

    @PrimaryKey(autoGenerate = true)
    var userId: Int = 0,


    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "number")
    val number: String
)