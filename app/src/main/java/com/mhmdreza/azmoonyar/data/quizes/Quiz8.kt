package com.mhmdreza.azmoonyar.data.quizes

import com.mhmdreza.azmoonyar.data.AnswerType
import com.mhmdreza.azmoonyar.data.Question
import com.mhmdreza.azmoonyar.data.Quiz
const val FATHER = "father"
const val MOTHER = "mother"


fun getQuiz8(): Quiz {
    val quiz = Quiz(
        8,
        " راهنمای مقياس شيوه فرزندپروري پارکر",
        "desc2",
        AnswerType.AGREEMENT_LEVEL_4
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