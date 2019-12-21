package com.mhmdreza.azmoonyar.data

import java.io.Serializable

class QuizResult(val time: Long, val quizId: Int, val answerList: ArrayList<Answer> = arrayListOf()) : Serializable, Comparable<QuizResult> {
    override fun compareTo(other: QuizResult): Int {
        return this.time.compareTo(other.time) * -1
    }

}