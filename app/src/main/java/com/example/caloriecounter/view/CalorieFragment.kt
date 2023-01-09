package com.example.caloriecounter.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.caloriecounter.adapter.MealModelAdapter
import com.example.caloriecounter.databinding.FragmentCalorieBinding
import com.example.caloriecounter.viewmodel.CalorieFragmentViewModel
import kotlinx.android.synthetic.main.fragment_calorie.*

class CalorieFragment : Fragment() {

    private lateinit var viewModel : CalorieFragmentViewModel
    val adapter = MealModelAdapter(arrayListOf())

    private var binding:FragmentCalorieBinding? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null)
            binding = FragmentCalorieBinding.inflate(inflater)
        return binding?.root


    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity() as MainActivity).setBottomNavigationVisibility(true)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[CalorieFragmentViewModel::class.java]
        mealList.adapter = adapter
        viewModel.refreshData()
        mealList.layoutManager = LinearLayoutManager(context)

        observeLiveData()

    }


    fun observeLiveData() {
        viewModel.meals.observe(viewLifecycleOwner, Observer {
            mealList.visibility = View.VISIBLE
        })
    }
}