package com.example.caloriecounter.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.caloriecounter.databinding.FragmentCalorieBinding

class CalorieFragment : Fragment() {
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


}