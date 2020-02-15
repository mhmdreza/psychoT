package com.mhmdreza.azmoonyar.views

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
import com.mhmdreza.azmoonyar.R
import kotlin.math.abs


open class InfoFragment2 : Fragment(), AppBarLayout.OnOffsetChangedListener {

    private val PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR = 0.9f
    private val PERCENTAGE_TO_HIDE_TITLE_DETAILS = 0.3f
    private val ALPHA_ANIMATIONS_DURATION = 200L

    private var mIsTheTitleVisible = false
    private var mIsTheTitleContainerVisible = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.title = ""
        appbar.addOnOffsetChangedListener(this)

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
//        startAlphaAnimation(textview_title, 0, View.INVISIBLE)

//        imageview_placeholder.setImageResource(R.drawable.answer_bg1)

    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout, offset: Int) {
//        val maxScroll = appBarLayout.totalScrollRange
//        val percentage = abs(offset).toFloat() / maxScroll.toFloat()

//        handleAlphaOnTitle(percentage)
//        handleToolbarTitleVisibility(percentage)
    }

//    private fun handleAlphaOnTitle(percentage: Float) {
//        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {
//            if (mIsTheTitleContainerVisible) {
//                startAlphaAnimation(linearlayout_title, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE)
//                mIsTheTitleContainerVisible = false
//            }
//
//        } else {
//
//            if (!mIsTheTitleContainerVisible) {
//                startAlphaAnimation(linearlayout_title, ALPHA_ANIMATIONS_DURATION, View.VISIBLE)
//                mIsTheTitleContainerVisible = true
//            }
//        }
//    }

//    private fun handleToolbarTitleVisibility(percentage: Float) {
//        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {
//
//            if (!mIsTheTitleVisible) {
//                startAlphaAnimation(toolbarTitle, ALPHA_ANIMATIONS_DURATION, View.VISIBLE)
//                mIsTheTitleVisible = true
//            }
//
//        } else {
//
//            if (mIsTheTitleVisible) {
//                startAlphaAnimation(toolbarTitle, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE)
//                mIsTheTitleVisible = false
//            }
//        }
//    }

//
//    private fun startAlphaAnimation(v: View, duration: Long, visibility: Int) {
//        val alphaAnimation = if (visibility == View.VISIBLE)
//            AlphaAnimation(0f, 1f)
//        else
//            AlphaAnimation(1f, 0f)
//
//        alphaAnimation.duration = duration
//        alphaAnimation.fillAfter = true
//        v.startAnimation(alphaAnimation)
//    }

}
