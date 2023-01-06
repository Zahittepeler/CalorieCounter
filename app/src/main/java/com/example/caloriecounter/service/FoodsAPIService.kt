package com.example.caloriecounter.service

import com.example.caloriecounter.model.Foods
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class FoodsAPIService {

// https://raw.githubusercontent.com/kadrsnr/foodgson/main/gson
    private val BASE_URL = "https://raw.githubusercontent.com/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(FoodAPI::class.java)


        fun getData() : Single<List<Foods>> {
            return api.getFoods()
        }









}