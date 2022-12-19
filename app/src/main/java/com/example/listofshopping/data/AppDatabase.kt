package com.example.listofshopping.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ListOfShoppingDbModel::class], version = 1, exportSchema = false)
abstract class AppDatabase:RoomDatabase() {
    abstract fun listOfShoppingDao():ListOfShoppingDao
companion object{
    private var INSTANCE: AppDatabase? = null
    private val LOCK = Any()
    private const val DB_NAME = "list_of_shopping.db"
    fun getInstance(application: Application): AppDatabase {
        INSTANCE?.let {
            return it
        }
        synchronized(LOCK) {
            INSTANCE?.let {
                return it
            }
            val db = Room.databaseBuilder(
                application,
                AppDatabase::class.java,
                DB_NAME
            ).build()
            INSTANCE = db
            return db
        }
    }
}
}
