package com.example.splitwise.room_database_files

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Transactions::class], version = 1, exportSchema = false)
abstract class TransactionsDatabase : RoomDatabase() {

    abstract val transactionsDao: TransactionsDao

    companion object {

        private var INSTANCE: TransactionsDatabase? = null

        fun getInstance(context: Context): TransactionsDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance =
                        Room.databaseBuilder(context, TransactionsDatabase::class.java, "Transactions_DB").build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}