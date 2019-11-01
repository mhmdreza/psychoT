package com.mhmdreza.azmoonyar.views


import android.graphics.Color
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.mhmdreza.azmoonyar.R
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.setBackgroundColor(Color.TRANSPARENT)
        toolbar.title = "azmoonyar"
        quizListLayout.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_startQuizFragment)
        }
        infoTextView.setOnClickListener { navigateToInfoFragment() }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.info) {
            navigateToInfoFragment()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun navigateToInfoFragment() {
        navController.navigate(R.id.action_mainFragment_to_infoFragment)
    }
}
