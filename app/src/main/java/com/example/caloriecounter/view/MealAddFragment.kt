package com.example.caloriecounter.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.caloriecounter.adapter.ApiAdapter
import com.example.caloriecounter.databinding.AddMealFragmentBinding
import com.example.caloriecounter.viewmodel.AddMealApiViewModel
import kotlinx.android.synthetic.main.add_meal_fragment.*


class MealAddFragment : Fragment() {

    private var fragmentBinding:AddMealFragmentBinding? = null

    private lateinit var viewModel: AddMealApiViewModel
    private val adapter = ApiAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if (fragmentBinding == null)
            fragmentBinding = AddMealFragmentBinding.inflate(inflater)
        return fragmentBinding?.root


        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            viewModel = ViewModelProvider(this)[AddMealApiViewModel::class.java]
            viewModel.refreshData()

            foodListApiRV.layoutManager = LinearLayoutManager(context)
            foodListApiRV.adapter


    }

    private fun observeLiveData() {
        viewModel.apiFoods.observe(viewLifecycleOwner, Observer {it ->
                adapter.setApiList(it)
            it?.let {
                foodListApiRV.visibility = View.VISIBLE
                          }

        })

    }
     }



