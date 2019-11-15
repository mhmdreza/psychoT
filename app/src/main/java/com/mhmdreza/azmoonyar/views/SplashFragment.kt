package com.mhmdreza.azmoonyar.views


import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.mhmdreza.azmoonyar.R

/**
 * A simple [Fragment] subclass.
 */
class SplashFragment : Fragment() {

    private val navController by lazy { Navigation.findNavController(view!!) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onResume() {
        super.onResume()
        Handler().postDelayed({
            navController.navigate(R.id.action_splashFragment_to_mainFragment)
        }, 2000)
    }
}
