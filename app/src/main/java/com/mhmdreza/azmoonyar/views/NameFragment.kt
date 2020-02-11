package com.mhmdreza.azmoonyar.views


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavOptions
import androidx.navigation.Navigation

import com.mhmdreza.azmoonyar.R
import com.mhmdreza.azmoonyar.data.SharedPref
import ir.pec.mpl.pecpayment.view.PaymentInitiator
import kotlinx.android.synthetic.main.fragment_name.*

/**
 * A simple [Fragment] subclass.
 */
class NameFragment : Fragment() {

    private val navController by lazy { Navigation.findNavController(view!!) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_name, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nameEditText.requestFocus()

        submit.setOnClickListener {
            val text = nameEditText.text.toString()
            if (text.isNotEmpty()) {
                SharedPref.getInstance(view.context).setUsername(text)
                navController.navigate(R.id.action_nameFragment_to_mainFragment)
            } else {
                Toast.makeText(view.context, "برای ورود، لازم است که نام خود را وارد کنید!", Toast.LENGTH_LONG).show()
            }
        }
    }


}
