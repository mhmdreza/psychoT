package com.mhmdreza.azmoonyar.util

import com.mhmdreza.azmoonyar.data.QuizResult
import com.mhmdreza.azmoonyar.data.quizes.*
import ir.huri.jcal.JalaliCalendar
import java.util.*

fun normalizeTime(time: Long): CharSequence? {
    val jc = JalaliCalendar(Date(time))
    return normalizeNumber("${jc.day} ${jc.monthString} ${jc.year}")
}

fun normalizeNumber(input: String): String {
    var result = ""
    input.forEach {
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
        1 ->{
            getQuiz1Result(quizResult.answerList)
        }
        2 ->{
            getQuiz2Result(quizResult.answerList)
        }
        3 ->{
            getQuiz3Result(quizResult.answerList)
        }
        4 ->{
            getQuiz4Result(quizResult.answerList)
        }
        5 ->{
            getQuiz5Result(quizResult.answerList)
        }
        7 ->{
            getQuiz7Result(quizResult.answerList)
        }
        8 ->{
            getQuiz8Result(quizResult.answerList)
        }
        9 ->{
            getQuiz9Result(quizResult.answerList)
        }
        else ->{
            "very good"
        }
    }
}