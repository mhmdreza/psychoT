package ir.nilva.azmoonyar.views


import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import ir.nilva.azmoonyar.R
import ir.nilva.azmoonyar.data.SharedPref

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed({
            if (SharedPref.getInstance().getUsername().isNotEmpty()) {
                navController.navigate(R.id.action_splashFragment_to_mainFragment)
            } else navController.navigate(R.id.action_splashFragment_to_nameFragment)
        }, 2000)
    }
}
