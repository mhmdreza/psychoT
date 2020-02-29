package com.mhmdreza.azmoonyar.data.quizes

import android.text.Spannable
import android.text.SpannableStringBuilder
import androidx.core.text.bold
import androidx.core.text.toSpannable
import com.mhmdreza.azmoonyar.data.Answer
import com.mhmdreza.azmoonyar.data.AnswerType
import com.mhmdreza.azmoonyar.data.Question
import com.mhmdreza.azmoonyar.data.Quiz

fun getQuiz7(): Quiz {
    val quiz = Quiz(
        6,
        "پرسشنامه والدگری آلاباما",
        getDescription(),
        AnswerType.FREQUENCY_LEVEL,
        price = 1000
    )
    questions7.forEachIndexed { index, s ->
        quiz.questions.add(Question(index + 1, s))
    }
    return quiz
}

private fun getDescription(): Spannable {
    return SpannableStringBuilder()
        .bold { append( "\n\nمعرفی\n") }
        .append(
        "\n" +
                "اين پرسشنامه يك ابزار خودگزارشي و داراي 9 عبارت بوده و سه زيرمقياس: والدگری مثبت، عدم ثبات در نحوه برخورد با فرزند و ضعف در نظارت و راهنمايي را مورد ارزيابي قرار مي\u200Cدهد. \n" +
                "در ادامه، تعدادی جمله در مورد خانواده\u200Cتان آمده است. لطفاً بر حسب اینکه هر مورد معمولاً چقدر در خانه\u200Cتان اتفاق می\u200Cافتد به آن\u200Cها امتیاز دهید. پاسخ\u200Cهایی که می\u200Cتوانید از آن\u200Cها استفاده کنید عبارتند از:\n" +
                "هرگز (1)، تقریباً هیچ وقت (2)، گاهی اوقات (3)، اغلب اوقات (4)، همیشه (5). لطفاً به همه موارد پاسخ بدهید.\n"
        )
        .append("\n\n")
        .toSpannable()
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



fun getQuiz7Result(answerList: ArrayList<Answer>): String {
    var firstScore = 0f
    var secondScore = 0f
    var thirdScore = 0f
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
        }
    }
    var result = ""
    result += if (firstScore >= 12) {
        "والدگری مثبت\n"
    } else {
        "والدگری منفی\n"
    }
    result += if (secondScore >= 12) {
        "عدم ثبات در نحوه برخورد با فرزند\n"
    } else {
        " ثبات در نحوه برخورد با فرزند\n"
    }
    result += if (thirdScore >= 12) {
        "ضعف در هدایت و راهنمایی\n"
    } else {
        "عدم ضعف در هدایت و راهنمایی\n"
    }
    return result
}

private val first = arrayListOf(1,6,7) //1.	والدگری مثبت
private val second = arrayListOf(2,4,9) //2.	عدم ثبات در نحوه برخورد با فرزند
private val third = arrayListOf(3,5,8)// 3.	ضعف در هدایت و راهنمایی