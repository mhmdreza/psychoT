package com.mhmdreza.azmoonyar.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import com.mhmdreza.azmoonyar.R
import kotlinx.android.synthetic.main.fragment_info.*

class InfoFragment : Fragment() {

    private val navController by lazy { findNavController(view!!) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backIcon.setOnClickListener{  navController.popBackStack(R.id.mainFragment, false)
        }
    }


}
