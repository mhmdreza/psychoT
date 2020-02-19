package com.mhmdreza.azmoonyar.views


import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.os.Handler
import android.os.ResultReceiver
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.view.inputmethod.InputMethodManager
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.core.view.updateMargins
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.mhmdreza.azmoonyar.R
import com.mhmdreza.azmoonyar.data.SharedPref
import kotlinx.android.synthetic.main.fragment_name.*
import kotlinx.android.synthetic.main.fragment_name.view.*


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

    private fun showSoftKeyboard(view: View) {
        if (view.requestFocus()) {
            val imm =
                activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(
                view,
                InputMethodManager.SHOW_FORCED,
                object : ResultReceiver(Handler()) {
                    override fun onReceiveResult(resultCode: Int, resultData: Bundle?) {
                        rootLayout.viewTreeObserver
                            .addOnGlobalLayoutListener {
                                val r = Rect()
                                rootLayout.getWindowVisibleDisplayFrame(r)
                                rootLayout.layoutParams.height = r.bottom - r.top
                                rootLayout.invalidate()
                                rootLayout.requestLayout()
                            }
                    }
                })

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showSoftKeyboard(nameEditText)
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
