package com.mhmdreza.azmoonyar.util

import com.mhmdreza.azmoonyar.data.QuizResult
import com.mhmdreza.azmoonyar.data.quizes.*
import ir.huri.jcal.JalaliCalendar
import java.util.*

fun normalizeTime(time: Long): CharSequence? {
    val jc = JalaliCalendar(Date(time))
    return "${jc.day} ${jc.monthString} ${jc.year}".normalizeNumber()
}

fun String.normalizeNumber(): String {
    var result = ""
    this.forEach {
        result += when (it) {
            '0' -> '۰'
            '1' -> '۱'
            '2' -> '۲'
            '3' -> '۳'
            '4' -> '۴'
            '5' -> '۵'
            '6' -> '۶'
            '7' -> '۷'
            '8' -> '۸'
            '9' -> '۹'
            else -> it
        }
    }
    return result
}

fun calculateQuizResultText(quizResult: QuizResult): String{
    return when(quizResult.quizId){
        0 ->{
            getQuiz1Result(quizResult.answerList)
        }
        1 ->{
            getQuiz2Result(quizResult.answerList)
        }
        2 ->{
            getQuiz3Result(quizResult.answerList)
        }
        3 ->{
            getQuiz4Result(quizResult.answerList)
        }
        4 ->{
            getQuiz5Result(quizResult.answerList)
        }
        5 ->{
            getQuiz7Result(quizResult.answerList)
        }
        6 ->{
            getQuiz8Result(quizResult.answerList)
        }
        8 ->{
            getQuiz9Result(quizResult.answerList)
        }
        else ->{
            "very good"
        }
    }
}