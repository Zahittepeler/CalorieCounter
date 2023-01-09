package com.example.caloriecounter.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.caloriecounter.model.MealModel
import java.nio.channels.spi.AbstractSelectionKey


class CalorieFragmentViewModel  : ViewModel() {
            val meals = MutableLiveData<List<MealModel>>()


     fun refreshData() {
         val mealOne = MealModel("Kahvaltı")
         val mealTwo = MealModel("Öğlen")
         val mealThree = MealModel("Akşam")

         val mealList = arrayListOf<MealModel>(mealOne,mealTwo,mealThree)

         meals.value = mealList

     }





}