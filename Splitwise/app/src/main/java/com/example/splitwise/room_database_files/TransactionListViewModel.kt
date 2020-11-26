package com.example.splitwise.room_database_files

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class TransactionListViewModel(private val context: Context) : ViewModel() {
    fun fetchFromTransactionDB(): LiveData<List<Transactions>> {
        return TransactionsDatabase.getInstance(context).transactionsDao.getAllTransactions()
    }

}