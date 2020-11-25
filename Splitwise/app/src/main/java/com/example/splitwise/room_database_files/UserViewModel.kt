package com.example.splitwise.room_database_files

import android.content.Context
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(private val context: Context) : ViewModel() {


    fun insertDataToDatabase(name: String, number: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val user =
                User(name = name, number = number)
            UserDatabase.getInstance(context).userDao.insertUser(user)
        }
    }
}