package com.example.splitwise.room_database_files

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class TransactionsListViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TransactionListViewModel::class.java)) {
            return TransactionListViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}