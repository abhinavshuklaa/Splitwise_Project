package com.example.splitwise.room_database_files

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.splitwise.room_database_files.User

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: User)

    @Query("Select * From Users")
    fun getAllUsers(): LiveData<List<User>>
    }