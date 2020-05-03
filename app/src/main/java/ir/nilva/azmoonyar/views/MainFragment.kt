package ir.nilva.azmoonyar.views

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ComponentName
import android.content.Context.BIND_AUTO_CREATE
import android.content.Intent
import android.content.ServiceConnection
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.IBinder
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ir.nilva.azmoonyar.BackgroundSoundService
import ir.nilva.azmoonyar.R
import kotlinx.android.synthetic.main.fragment_main.*


/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    private val navController by lazy { Navigation.findNavController(view!!) }
//    private var bounded = false
//    private var backgroundSoundService: BackgroundSoundService? = null

//    var connection: ServiceConnection = object : ServiceConnection {
//        override fun onServiceDisconnected(name: ComponentName) {
//            bounded = false
//            backgroundSoundService = null
//        }
//
//        override fun onServiceConnected(name: ComponentName, service: IBinder) {
//            bounded = true
//            val localBinder: BackgroundSoundService.LocalBinder =
//                service as BackgroundSoundService.LocalBinder
//            backgroundSoundService = localBinder.serviceInstance
//            backgroundSoundService?.onStart()
//            musicButton.setImageResource(R.drawable.baseline_pause_circle_outline_black_24)
//        }
//    }

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

//        val svc = Intent(activity, BackgroundSoundService::class.java)
//        activity!!.startService(svc)

//        if (backgroundSoundService?.isPlaying == true) {
//            musicButton.setImageResource(R.drawable.baseline_pause_circle_outline_black_24)
//        } else {
//            musicButton.setImageResource(R.drawable.baseline_play_circle_outline_black_24)
//        }

//        musicButton.setOnClickListener {
//            if (backgroundSoundService?.isPlaying == true) {
//                backgroundSoundService?.onPause()
//                musicButton.setImageResource(R.drawable.baseline_play_circle_outline_black_24)
//
//            } else {
//                backgroundSoundService?.onStart()
//                musicButton.setImageResource(R.drawable.baseline_pause_circle_outline_black_24)
//
//            }
//        }

//        payment.setOnClickListener {
//            val intent = Intent(activity!!, PaymentInitiator::class.java)
//            intent.putExtra("Type", 1)
//            intent.putExtra("Token", "98404259")
//            intent.putExtra("Amount", 1)
//            startActivityForResult(intent, 1)
//        }
    }

//    override fun onStart() {
//        super.onStart()
//        val intent = Intent(activity, BackgroundSoundService::class.java)
//        activity?.bindService(intent, connection, BIND_AUTO_CREATE)
//    }


    private fun navigateToInfoFragment() {
        navController.navigate(R.id.action_mainFragment_to_infoFragment2)
    }
}
