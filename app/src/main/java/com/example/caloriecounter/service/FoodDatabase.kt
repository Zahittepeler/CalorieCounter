package com.example.caloriecounter.service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.caloriecounter.model.Foods

@Database(entities = arrayOf(Foods::class),version = 1)
abstract class FoodDatabase : RoomDatabase() {

    abstract fun foodDao() : FoodDAO



    companion object {

        @Volatile private var instance : FoodDatabase? = null

        private val lock = Any()

        operator fun invoke(context : Context) = instance ?: synchronized(lock) {
            instance ?: makeDatabase(context).also {
                instance = it
            }
        }


        private fun makeDatabase(context : Context) = Room.databaseBuilder(
            context.applicationContext,FoodDatabase::class.java,"fooddatabase"
        ).build()
    }
}