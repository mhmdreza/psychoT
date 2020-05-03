package ir.nilva.azmoonyar.views


import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import ir.nilva.azmoonyar.R
import kotlinx.android.synthetic.main.fragment_loading.*

/**
 * A simple [Fragment] subclass.
 */
class LoadingFragment : Fragment() {

    private val navController by lazy { Navigation.findNavController(view!!) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_loading, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments ?: return
        if (arguments!!.containsKey(QUIZ_RESULT).not()) return

        val quizResult = arguments!!.getSerializable(QUIZ_RESULT)!!
        Handler().postDelayed({
            val bundle = Bundle()
            bundle.putSerializable(QUIZ_RESULT, quizResult)
            navController.navigate(R.id.action_loadingFragment_to_quizResultFragment, bundle)
        }, 5000)
    }

}
