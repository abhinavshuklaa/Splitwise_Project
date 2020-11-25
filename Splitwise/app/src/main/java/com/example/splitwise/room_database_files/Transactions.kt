package com.example.splitwise.room_database_files

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Transactions")

data class Transactions(

    @PrimaryKey(autoGenerate = true)
    var transactionId: Int = 0,


    @ColumnInfo(name = "firstPerson")
    val firstPerson: String,

    @ColumnInfo(name = "secondPerson")
    val secondPerson: String,


    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "amount")
    val amount: String


)