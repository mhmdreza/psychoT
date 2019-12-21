package com.mhmdreza.azmoonyar.data.quizes

import android.text.Spannable
import android.text.SpannableStringBuilder
import androidx.core.text.bold
import androidx.core.text.toSpannable
import com.mhmdreza.azmoonyar.data.Answer
import com.mhmdreza.azmoonyar.data.AnswerType
import com.mhmdreza.azmoonyar.data.Question
import com.mhmdreza.azmoonyar.data.Quiz

fun getQuiz1(): Quiz{
    val quiz = Quiz(0,
        "مقیاس روشهای فرزند پروری",
        getDescription(),
        AnswerType.AGREEMENT_LEVEL_4
    )
    questions1.forEachIndexed { index, s ->
        quiz.questions.add(Question(index + 1, s))
    }
    return quiz
}

private fun getDescription(): Spannable {
    return SpannableStringBuilder()
        .bold { append( "معرفی\n") }
        .append("فرم اولیه این پرسشنامه دارای 20 سؤال است که در کشورهای غربی بی\u200Cشک به نوعی مورد توجه بوده است؛ اما با توجه به متفاوت بودن روش فرزندپروری در کشور ایران و کشورهای غربی پرسشنامه با شرایط ایران تنظیم گردید. این پرسشنامه شیوه\u200Cهای فرزند پروری والدین را در سه سطح اندازه\u200Cگیری می\u200Cکند. \n")
        .bold { append("لطفا جملاتی که در ادامه می\u200Cآید را با دقت مطالعه کرده و مناسب\u200Cترین گزینه را انتخاب نمایید.\n") }.toSpannable()
}

val questions1 = arrayListOf(
    "والدین باید زمانی را در کنار کودکان باشند تا لذت در کنار هم بودن را تجربه کنند.",
    "والدین باید محبت خود به کودکان را به طور کلامی ابراز کنند.",
    "والدین باید دلیل کارهای خود در خانه را توضیح دهند و ریشه مشکلات را شناسایی کنند.",
    "والدین باید روش صحیح آداب و احترام به بزرگتر  را به فرزندان یاد دهند.",
    "توقع والدین از کودکان باید در حد توان و درک آن\u200Cها باشد.",

    "بچه\u200Cها نباید هیچ مخالفتی نسبت خواسته پدر و مادر داشته باشند.",
    "والدین باید اجازه دهند کودکان کنجکاوی کنند و هر چه را که در جهت افزایش کارایی مثبت کودک مورد نیاز است فراهم نمایند.",
    "والدین باید با تقویت نیروی ایمان و الگو بودن، گودکان را آموزش و مشاوره دهند و هدایت نمایند.",
    "با کودکان باید با زبان خود آن\u200Cها سخن گفت و دلایل منطقی بعضی از مخالفت\u200Cها را بیان کرد.",
    "والدین باید در تصمیم\u200Cگیری\u200Cها آن\u200Cچه صلاح خانواده است انجام دهند.",

    "اگر والدین وقت و فرصت کافی برای گوش کردن به صحبت کودکان داشته باشند مشکلات کمتر می\u200Cشود.",
    "والدین باید به نظرات فرزندان گوش دهند و در صورت مفید بودن از آن هم استفاده کنند.",
    "والدین می\u200Cتوانند با نظرات غیر اصولی و غیر اخلاقی کودکان مخالفت کنند.",
    "والدین باید با بچه\u200Cها اجازه دهند تا در تصمیم\u200Cگیری\u200Cها نقش داشته باشند تا معنای مشورت را بدانند. 1",
    "شوخی و بازی غیر اخلاقی بچه\u200Cها در حضور والدین صحیح نیست.",

    "والدین در مواقعی باید کودکان را نوازش کرده و در آغوش بگیرند.",
    "بچه\u200Cها باید جرأت بیان عقاید و اظهار نظر در حضور والدین داشته باشند.",
    "کودکان اذیت کار باید به\u200Cطور غیر مستقیم بیاموزند و از بزرگ\u200Cترها حساب ببرند و دلایل منطقی را بدانند.",
    "کودکان باید اجازه داشته باشند مشکلات خود را با والدین مطرح کنند و والدین باید صبور باشند.",
    "اگر بچه\u200Cها را زیر نظر نداشته باشیم و تذکرات توأم با نصیحت به موقع ندهیم تلاش نمی\u200Cکنند و پیشرفت نخواهند کرد."
)

fun getQuiz1Result(answerList: ArrayList<Answer>): String {
    var sahlGirScore = 0f
    var estebdadScore = 0f
    var ghateScore = 0f
    answerList.forEachIndexed { index, answer ->
        val questionNum = index + 1
        when {
            sahlGir.contains(questionNum) -> {
                sahlGirScore += answer.answer
            }
            estebdad.contains(questionNum) -> {
                estebdadScore += answer.answer
            }
            else -> {
                ghateScore += answer.answer
            }
        }
    }
    sahlGirScore /= sahlGir.size
    estebdadScore /= estebdad.size
    ghateScore /= ghate.size
    var result = ""
    result += if (sahlGirScore >= 1.8){
        "شما سهل گیر هستید! \n"
    }else {
        "شما سهل گیر نیستید! \n"
    }
    result += if (estebdadScore >= 2.1){
        "شما مستبد هستید! \n"
    }else {
        "شما مستبد نیستید! \n"
    }
    result += if (ghateScore >= 2.1){
        "شما قاطع هستید! \n"
    }else {
        "شما قاطع نیستید! \n"
    }
    return result
}

private val sahlGir = arrayListOf(2, 7, 9, 12, 14, 16, 19)
private val estebdad = arrayListOf(1, 3, 5, 8, 11, 17)
private val ghate = arrayListOf(4, 6, 10, 13, 15, 18, 20)