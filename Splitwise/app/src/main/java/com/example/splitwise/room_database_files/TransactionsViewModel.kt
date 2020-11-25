package com.example.splitwise.room_database_files

import android.content.Context
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class TransactionsViewModel(private  val context: Context):ViewModel() {
    fun insertToTransactionsDatabase(firstPerson:String,secondPerson:String,description:String,amount:String){
        CoroutineScope(IO).launch {
            val transactions=Transactions(firstPerson = firstPerson,secondPerson = secondPerson,description = description,amount = amount)
            TransactionsDatabase.getInstance(context).transactionsDao.insertTransactions(transactions)
        }
    }
}