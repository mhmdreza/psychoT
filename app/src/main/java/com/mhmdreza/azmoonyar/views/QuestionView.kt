package com.mhmdreza.azmoonyar.views

import android.widget.FrameLayout
import com.mhmdreza.azmoonyar.data.Question

class QuestionView(val container: FrameLayout, val question: Question) {

    init {
        showQuestion(question)
    }

    fun showQuestion(question: Question) {
        container.removeAllViews()
    }
}