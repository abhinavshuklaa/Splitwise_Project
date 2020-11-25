package com.example.splitwise.room_database_files

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class UserListViewModel(private val context: Context) : ViewModel() {


    fun fetchDataFromDB(): LiveData<List<User>> {
        return UserDatabase.getInstance(context)
            .userDao.getAllUsers()
    }



//
//    fun updateUserDB(firstName: String, lastName: String, userId: Int) {
//        CoroutineScope(IO).launch {
//            UserDatabase.getInstance(context).userDao
//                .updateUserDetails(firstName, lastName, userId)
//        }
//    }
//
//    fun deleteUser(user: User) {
//        CoroutineScope(IO).launch {
//            UserDatabase.getInstance(context).userDao
//                .deleteUser(user)
//        }
//    }
}