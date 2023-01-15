package com.example.caloriecounter.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.caloriecounter.model.Foods
import com.example.caloriecounter.service.FoodAPI
import com.example.caloriecounter.service.FoodDatabase
import com.example.caloriecounter.service.FoodsAPIService
import com.example.caloriecounter.util.CustomSharedPreferences
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch


class AddMealApiViewModel(appilacation : Application) : BaseViewModel(appilacation){

    val apiFoods = MutableLiveData<List<Foods>>()
    val foodsApiService = FoodsAPIService()
    val disposable = CompositeDisposable()
    private var customPreferences = CustomSharedPreferences(getApplication())







    private fun getDataFromApi() {

        disposable.add(
            foodsApiService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Foods>>(){
                    override fun onSuccess(t: List<Foods>) {
                        storeInSQLite(t)
                        Toast.makeText(getApplication(),"Countries From API", Toast.LENGTH_LONG).show()
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()                    }


                })
        )
    }
    private fun showFoods(foodList: List<Foods>) {
        apiFoods.value = foodList

    }


    private fun storeInSQLite(list: List<Foods>) {
        launch {
            val dao = FoodDatabase(getApplication()).countryDao()
            dao.deleteAllFoods()
            val listLong = dao.insertAll(*list.toTypedArray())
            var i = 0
            while (i < list.size) {
                list[i].uuid = listLong[i].toInt()
                i = i + 1
            }

            (list)
        }

        customPreferences.saveTime(System.nanoTime())
    }

    override fun onCleared() {
        super.onCleared()

        disposable.clear()
    }
}