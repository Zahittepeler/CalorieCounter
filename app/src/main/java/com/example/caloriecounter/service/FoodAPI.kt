package com.example.caloriecounter.service

import com.example.caloriecounter.model.Foods
import io.reactivex.Single
import retrofit2.http.GET

interface FoodAPI {

        @GET("kadrsnr/foodgson/main/gson")
        fun getFoods (): Single<List<Foods>>

}