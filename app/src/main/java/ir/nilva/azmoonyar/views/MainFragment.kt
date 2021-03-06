package ir.nilva.azmoonyar.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ir.nilva.azmoonyar.R
import kotlinx.android.synthetic.main.fragment_main.*


/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    private val navController by lazy { Navigation.findNavController(view!!) }

    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity!!.window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        quizListLayout.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_quizListFragment)
        }
        resultListLayout.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_resultListFragment)
        }
        infoButton.setOnClickListener { navigateToInfoFragment() }
        infoTextView.setOnClickListener { navigateToInfoFragment() }

    }


    private fun navigateToInfoFragment() {
        navController.navigate(R.id.action_mainFragment_to_infoFragment2)
    }
}
