package com.example.caloriecounter.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.caloriecounter.model.MealModel


class CalorieFragmentViewModel  : ViewModel() {
            val meals = MutableLiveData<MutableList<MealModel>>()


     fun refreshData() {
         val mealOne = MealModel("Kahvaltı")
         val mealTwo = MealModel("Öğlen")
         val mealThree = MealModel("Akşam")
         val mealFour = MealModel("ara")
         val mealFive = MealModel("ara")
         val mealSix = MealModel("ara")
         val mealSeven = MealModel("ara")

         val mealList = mutableListOf<MealModel>(mealOne,mealTwo,mealThree,mealFive,mealFour,mealSix,mealSeven)

         this.meals.value = mealList

     }





}