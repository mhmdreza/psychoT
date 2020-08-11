package ir.nilva.azmoonyar.util

import ir.nilva.azmoonyar.data.QuizResult
import ir.nilva.azmoonyar.data.quizes.*
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


fun calculateQuizResult(quizResult: QuizResult): FinalResult {
    return when (quizResult.quizId) {
        0 -> {
            getQuizResult(QuizType.QUIZ1, quizResult.answerList)
        }
        1 -> {
            getQuizResult(QuizType.QUIZ2, quizResult.answerList)
        }
        2 -> {
            getQuizResult(QuizType.QUIZ3, quizResult.answerList)
        }
        3 -> {
            getQuizResult(QuizType.QUIZ4, quizResult.answerList)
        }
        4 -> {
            getQuizResult(QuizType.QUIZ5, quizResult.answerList)
        }
        5 -> {
            getQuiz6Result(quizResult.answerList)
        }
        6 -> {
            getQuizResult(QuizType.QUIZ7, quizResult.answerList)
        }
        7 -> {
            getQuiz8Result(quizResult.answerList)
        }
        8 -> {
            getQuiz9Result(quizResult.answerList)
        }
        else -> FinalResult("", emptyList())

    }
}