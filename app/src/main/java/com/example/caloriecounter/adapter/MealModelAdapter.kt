package com.example.caloriecounter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.caloriecounter.R
import com.example.caloriecounter.model.MealModel
import kotlinx.android.synthetic.main.item_meal.view.*

class MealModelAdapter(private var mealNameList: MutableList<MealModel>) :
    RecyclerView.Adapter<MealModelAdapter.MealViewHolder>() {

    fun setList(mealNameList: MutableList<MealModel>) {

        this.mealNameList = mealNameList

        notifyDataSetChanged()
    }

    class MealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_meal, parent, false)
        return MealViewHolder(view)

    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {


        holder.itemView.day_title_first.text = mealNameList[position].mealName
    }

    override fun getItemCount(): Int {
        return mealNameList.size
    }
}