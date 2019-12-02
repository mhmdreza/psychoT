package com.mhmdreza.azmoonyar.data

import java.io.Serializable

class QuizResult(val time: Long, val quizId: Int, val answerList: ArrayList<Answer> = arrayListOf()) : Serializable