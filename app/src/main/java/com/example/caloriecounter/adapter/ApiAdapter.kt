package com.example.caloriecounter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.caloriecounter.model.Foods
import com.example.caloriecounter.R
import com.example.caloriecounter.model.MealModel
import com.example.caloriecounter.databinding.FragmentCalorieBinding.inflate
import kotlinx.android.synthetic.main.item_list_api.view.*


class ApiAdapter(var context: Context, var apiMealList : MutableList<Foods>) : RecyclerView.Adapter<ApiAdapter.ApiViewHolder>() {

    fun setApiList(mealNameList: MutableList<MealModel>) {

        this.apiMealList = apiMealList

        notifyDataSetChanged()
    }

    class ApiViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_list_api, parent, false)
        return ApiViewHolder(view)

    }

    override fun onBindViewHolder(holder: ApiViewHolder, position: Int)  {

                holder.itemView.meal_name.text = apiMealList[position].besinIsimleri
                holder.itemView.meal_calorie.text = apiMealList[position].kaloriMiktari.toString()
        }

    override fun getItemCount(): Int {
        return apiMealList.size

    }
}