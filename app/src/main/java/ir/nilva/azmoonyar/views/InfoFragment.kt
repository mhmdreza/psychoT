package ir.nilva.azmoonyar.views

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import kotlinx.android.synthetic.main.fragment_info.*
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.LinearLayout
import ir.nilva.azmoonyar.R


open class InfoFragment : Fragment() {

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
//        val layoutParams = sponsorImageView.layoutParams as LinearLayout.LayoutParams
//        val topMargin = layoutParams.topMargin
//        val bottomMargin = layoutParams.bottomMargin
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            scrollView.setOnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
//                val a = object : Animation() {
//                     override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
//                         (sponsorImageView.layoutParams as LinearLayout.LayoutParams).apply {
//                             setMargins(leftMargin, (topMargin / 2 * interpolatedTime).toInt(),
//                                 rightMargin, (bottomMargin / 2 * interpolatedTime).toInt())
//                         }
//                    }
//                    override fun getScaleFactor() = 0.5f
//                    override fun getDuration() = 500L
//                }
//                val b = object : Animation() {
//                     override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
//                         (sponsorImageView.layoutParams as LinearLayout.LayoutParams).apply {
//                             setMargins(leftMargin, (topMargin * interpolatedTime).toInt(),
//                                 rightMargin, (bottomMargin * interpolatedTime).toInt())
//                         }
//                    }
//                    override fun getScaleFactor() = 2f
//                    override fun getDuration() = 500L
//                }
//                if (scrollY in 0..100 && oldScrollY > 100){
//                    sponsorImageView.startAnimation(b)
//                } else if (scrollY in 0..100 && oldScrollY > 100) {
//                    sponsorImageView.startAnimation(a)
//
//                }
//            }
//        }
    }


}
