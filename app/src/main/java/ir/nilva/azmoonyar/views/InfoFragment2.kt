package ir.nilva.azmoonyar.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.fragment_info_2.*
import android.view.animation.AlphaAnimation
import ir.nilva.azmoonyar.R
import kotlinx.android.synthetic.main.fragment_info.*
import kotlinx.android.synthetic.main.fragment_info_2.backIcon
import kotlinx.android.synthetic.main.fragment_info_2.toolbar
import kotlinx.android.synthetic.main.fragment_start_quiz.*
import kotlin.math.abs


open class InfoFragment2 : Fragment() {

    private val navController by lazy { findNavController(view!!) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backIcon.setOnClickListener{
            activity?.onBackPressed()
        }
        toolbar.title = ""
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
    }
}
