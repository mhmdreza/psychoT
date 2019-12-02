package com.mhmdreza.azmoonyar.data.quizes

import com.mhmdreza.azmoonyar.data.AnswerType
import com.mhmdreza.azmoonyar.data.Question
import com.mhmdreza.azmoonyar.data.Quiz

fun getQuiz7(): Quiz {
    val quiz = Quiz(
        7,
        "راهنمای پرسشنامه والدگری آلاباما",
        "desc2",
        AnswerType.FREQUENCY_LEVEL
    )
    questions7.forEachIndexed { index, s ->
        quiz.questions.add(Question(index + 1, s))
    }
    return quiz
}

val questions7 = arrayListOf(
    "وقتی فرزندتان کار خوبی انجام می\u200Cدهد، او را تحسین می\u200cکنید.",
    "فرزندتان را تهدید به تنبیه می\u200Cکنید اما بعد عملاً این کار را نمی\u200Cکنید.",
    "فرزندتان برایتان یادداشت نمی\u200Cگذارد و به شما نمی\u200Cگوید که کجا می\u200Cرود.",
    "وقتی فرزندتان کار بدی می\u200Cکند با حرف زدن، شما را از تنبیه منصرف می\u200Cکند.",
    "فرزندتان شب\u200Cها سر موقع به خانه نمی\u200Cآید.",
    "وقتی فرزندتان کاری را خوب انجام می\u200Cدهد از او تعریف می\u200Cکنید.",
    "اگر فرزندتان خوب رفتار کند تحسینش می\u200Cکنید.",
    "فرزندتان با دوستانی بیرون می\u200Cرود که نمی\u200Cشناسید.",
    "زود از تنبیه فرزندتان منصرف می\u200Cشوید (مثل برداشتن محدودیت\u200Cها زودتر از موعدی که اول گفته بودید)."
)