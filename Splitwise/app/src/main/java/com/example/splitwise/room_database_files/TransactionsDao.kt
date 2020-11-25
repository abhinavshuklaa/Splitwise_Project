package com.example.splitwise.room_database_files

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TransactionsDao {
    @Insert
    suspend fun insertTransactions(transactions: com.example.splitwise.room_database_files.Transactions)

    @Query("Select * From Transactions")
    fun getAllTransactions():LiveData<List<Transactions>>

}