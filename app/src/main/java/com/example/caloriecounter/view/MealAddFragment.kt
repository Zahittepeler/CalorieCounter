package com.example.caloriecounter.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.caloriecounter.R
import com.example.caloriecounter.databinding.ActivityMainBinding.inflate
import com.example.caloriecounter.databinding.ActivitySplashScreenBinding.inflate
import com.example.caloriecounter.databinding.AddMealFragmentBinding
import com.example.caloriecounter.databinding.FragmentCalorieBinding
import kotlinx.android.synthetic.main.add_meal_fragment.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MealAddFragment : Fragment() {

    private var fragmentBinding:AddMealFragmentBinding? = null

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



    }



