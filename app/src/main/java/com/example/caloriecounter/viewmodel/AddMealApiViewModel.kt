package com.example.caloriecounter.viewmodel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.caloriecounter.model.Foods
import com.example.caloriecounter.service.FoodAPI
import com.example.caloriecounter.service.FoodDatabase
import com.example.caloriecounter.service.FoodsAPIService
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch


class AddMealApiViewModel(appilacation: Application) : BaseViewModel(appilacation) {
    private val foodApiService = FoodsAPIService()

    private var _apiFoods = MutableLiveData<List<Foods>>()
    val apiFoods get() = _apiFoods

    val foodsApiService = FoodsAPIService()
    val disposable = CompositeDisposable()

    fun getDataViewModel() {
        getDataFromApi()
    }

    private fun getDataFromApi() {

        disposable.add(
            foodsApiService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Foods>>() {
                    override fun onSuccess(t: List<Foods>) {
                        println(t)
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }


}