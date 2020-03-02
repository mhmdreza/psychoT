package com.mhmdreza.azmoonyar.data.quizes

import com.mhmdreza.azmoonyar.data.Answer
import com.mhmdreza.azmoonyar.data.Question
import com.mhmdreza.azmoonyar.data.Quiz
import com.mhmdreza.azmoonyar.data.descriptionList

const val FATHER = "father"
const val MOTHER = "mother"


fun getQuiz8(): Quiz {
    val quiz = Quiz(
        7,
        "مقياس شيوه فرزندپروري پارکر",
        descriptionList[7],
        AnswerType.AGREEMENT_LEVEL_4,
        price = 2000
    )
    motherQuestions.forEachIndexed { index, s ->
        quiz.questions.add(Question(index  +1, s, arrayListOf(MOTHER)))
    }
    fatherQuestions.forEachIndexed { index, s ->
        quiz.questions.add(Question(index  +1, s, arrayListOf(FATHER)))
    }
    return quiz
}

val motherQuestions = arrayListOf(
    "از من حمايت مفرط مي\u200Cكرد.",
    "به صورت لفظي دشنام مي\u200Cداد.",
    "من را بسيار كنترل مي\u200Cكرد.",
    "سعي مي\u200Cكرد كه در من احساس گناه به وجود آورد.",
    "من را ناديده مي\u200Cگرفت.",
    "از من انتقاد مي\u200Cكرد.",
    "براي من غيرقابل پيش بيني بود (رفتارش).",
    "به من بي\u200Cتوجه بود.",
    " با من خشونت فيزيكي داشت يا از من سوء استفاده جسماني مي\u200Cكرد.",
    "من را نمي\u200Cپذيرفت.",
    "زياد من را تنها مي\u200Cگذاشت.",
    "من را فراموش مي\u200Cكرد.",
    "به من بي\u200Cعلاقه بود.",
    "به من اين احساس را مي\u200Cداد كه در معرض خطر هستم.",
    "به من احساس ناامني مي\u200Cداد."
)

val fatherQuestions = motherQuestions



fun getQuiz8Result(answerList: ArrayList<Answer>): String {
    var firstScore = 0f
    var secondScore = 0f
    var thirdScore = 0f
    var first2Score = 0f
    var second2Score = 0f
    var third2Score = 0f
    answerList.forEachIndexed { index, answer ->
        val questionNum = index + 1
        when {
            first.contains(questionNum) -> {
                firstScore += answer.answer
            }
            second.contains(questionNum) -> {
                secondScore += answer.answer
            }
            third.contains(questionNum) -> {
                thirdScore += answer.answer
            }
            first2.contains(questionNum) -> {
                first2Score += answer.answer
            }
            second2.contains(questionNum) -> {
                second2Score += answer.answer
            }
            third2.contains(questionNum) -> {
                third2Score += answer.answer
            }
        }
    }
    var result = ""
    result += if (firstScore >= 12) {
        "مادر شما بی تفاوت است\n"
    } else {
        "مادر شما بی تفاوت نیست\n"
    }
    result += if (secondScore >= 10) {
        "مادر شما بدرفتار است\n"
    } else {
        "مادر شما بدرفتار نیست\n"
    }
    result += if (thirdScore >= 8) {
        "مادر شما افراطی است\n"
    } else {
        "مادر شما افراطی نیست\n"
    }
    result += if (first2Score >= 12) {
        "پدر شما بی تفاوت است\n"
    } else {
        "پدر شما بی تفاوت نیست\n"
    }
    result += if (second2Score >= 10) {
        "پدر شما بدرفتار است\n"
    } else {
        "پدر شما بدرفتار نیست\n"
    }
    result += if (third2Score >= 8) {
        "پدر شما افراطی است\n"
    } else {
        "پدر شما افراطی نیست\n"
    }
    return result
}

private val first = arrayListOf(5,8,10,11,12,13) //1.	بی تفاوت
private val second = arrayListOf(2,7,9,14,15) //2.	سو استفاده
private val third = arrayListOf(1,3,4,6)// 3.	کنترل مفرط
private val first2 = first.map{ it + 15 }.toList() //1.	بی تفاوت
private val second2 = second.map{ it + 15 }.toList()  //2.	سو استفاده
private val third2 = third.map{ it + 15 }.toList() // 3.	کنترل مفرط