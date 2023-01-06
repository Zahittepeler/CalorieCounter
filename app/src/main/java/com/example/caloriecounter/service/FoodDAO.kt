package com.example.caloriecounter.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.caloriecounter.model.Foods

@Dao
interface FoodDAO {

            @Insert
            suspend fun insertAll(vararg foods : Foods) : List<Long>


            @Query("SELECT * FROM foods")
            suspend fun getAllFood() : List<Foods>

            @Query ("SELECT * FROM foods WHERE uuid = :foodId")
            suspend fun getFood(foodId : Int) : Foods


            @Query("DELETE FROM foods")
            suspend fun deleteAllFoods()



}