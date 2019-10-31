package com.mhmdreza.azmoonyar.views


import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mhmdreza.azmoonyar.R
import com.mhmdreza.azmoonyar.base.BaseFragment

/**
 * A simple [Fragment] subclass.
 */
class SplashFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onResume() {
        super.onResume()
        Handler().postDelayed({ mainActivity.startFragment(MainFragment()) }, 3000)
    }
}
