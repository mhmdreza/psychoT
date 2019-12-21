package com.mhmdreza.azmoonyar.data.quizes

import android.text.Spannable
import android.text.SpannableStringBuilder
import androidx.core.text.bold
import androidx.core.text.toSpannable
import com.mhmdreza.azmoonyar.data.Answer
import com.mhmdreza.azmoonyar.data.AnswerType
import com.mhmdreza.azmoonyar.data.Question
import com.mhmdreza.azmoonyar.data.Quiz

fun getQuiz2(): Quiz {
    val quiz = Quiz(
        1,
        "مقیاس سبک تربیتی والدین",
        getDescription()
        , AnswerType.AGREEMENT_LEVEL_5
    )
    questions2.forEachIndexed { index, s ->
        quiz.questions.add(Question(index + 1, s))
    }
    return quiz
}

private fun getDescription(): Spannable {
    return SpannableStringBuilder()
        .bold {
            append(
                "معرفی\n"
            )
        }
        .append("این مقیاس دارای 21 عبارت است که برای ارزیابی 4 سبک فرزندپروری مستبدانه، بی\u200Cاعتنا، سهل\u200Cگیرانه و قاطعانه والدین طراحی و تهیه شده است.")
        .bold {
            append(
                "لطفا جملاتی که در ادامه می\u200Cآید را به دقت مطالعه کرده و مناسب\u200Cترین گزینه را انخاب نمایید.\n"
            )
        }.toSpannable()
}

val questions2 = arrayListOf(
    "والدین باید به بچه\u200Cهای خود اجازه دهند تا هر موقع مایلند به تکالیف درسی خود بپردازند",
    "بچه\u200Cها باید همیشه در هرکاری مخصوصاً تحصیلات رضایت والدین را جلب کنند در غیر این \u200Cصورت باید تنبیه شوند.",
    "در تعیین رشته\u200C تحصیلی باید والدین تصمیم\u200Cگیرنده باشند زیرا فرزندان صلاح خود را نمی\u200Cدانند.",
    "در صورتی\u200Cکه فرزندان به کاری غیر از آن\u200Cچه والدین صحیح می\u200Cدانند بپردازند، باید با دلیل آن\u200Cها را راهنمایی کرد.",
    "5بچه\u200Cها خود به خود به سمت آن\u200Cچه که برای آن\u200Cها مناسب است هدایت می\u200Cشوند و باید از امر و نهی زیاد آن\u200Cها پرهیز کرد.",
    "در انتخاب رشته تحصیلی و انتخاب حرفه برای آینده فرزندان، والدین باید هدایت\u200Cکننده باشند و نظر خود را تحمیل نکنند.",
    "فرزندان در عقاید مذهبی باید پیرو والدین\u200Cشان باشند، اما اگر خلاف میل آن\u200Cها بود باید بتوانند آزادانه آن را با والدین مطرح کنند.",
    "مذهب و اعتقادات چیزی نیست که بچه\u200Cها بتوانند در مورد آن با والدین مخالفت کنند.",
    "عقاید و مذهب چیزی نیست که به فرزندان دیکته شود، باید آن\u200Cها را در انتخاب آزاد گذاشت.",
    "اگر فرزندان در برخی موارد برخلاف والدین عمل کردند، والدین به\u200Cجای تنبیه باید آن\u200Cها را راهنمایی کنند.",
    "از همان دوره کودکی فرزندان باید متوجه شوند که حاکم خانواده کیست.",
    "تمام مشکلات بچه\u200Cها این است که پدر و مادرها بیش از اندازه آن\u200Cها را محدود می\u200Cکنند.",
    "در صورت مخالفت فرزندان با نظرات والدین باید به\u200Cشدت با آن\u200Cها برخورد کرد.",
    "باید به فرزندان در هر سنی اجازه داد برای خود تصمیم بگیرند.",
    "فرزندان برای بازی و تفریح باید بتوانند در هر موقعیتی از خانه خارج شوند.",
    "تفریح و بازی در حضور پدر و مادر یک بی\u200Cاحترامی به حساب می\u200Cآید.",
    "اگر در مواردی فرزندان کار اشتباهی انجام دهند هرگز نباید آن\u200Cها را سرزنش کرد.",
    "اگر والدین برای فرزندان تصمیمی بگیرند که بر خلاف میل آن\u200Cها باشد باید با آن\u200Cها گفتگو کنند یا حتی اگر در تصمیم خود اشتباه کرده بودند، آن را بپذیرند.",
    "فرزندان باید آزاد گذاشته شوند تا با تجربه کردن خودشان آینده\u200Cی خود را رقم بزنند.",
    "هر چند فرزندان گاهی اشتباه می\u200Cکنند، ولی در بعضی اوقات نظرات آن\u200Cها قابل قبول است.",
    "اگر فرزندان به محدویت\u200Cهایی که والدین برای آن\u200Cها قائلند اعتراض داشتند والدین باید با صحبت کردن آن\u200Cها را قانع کنند."
)


fun getQuiz2Result(answerList: ArrayList<Answer>): String {
    var sahlGirScore = 0f
    var estebdadScore = 0f
    var ghateScore = 0f
    var biEtenaScore = 0f
    answerList.forEachIndexed { index, answer ->
        val questionNum = index + 1
        when {
            sahlGir.contains(questionNum) -> {
                sahlGirScore += answer.answer
            }
            estebdad.contains(questionNum) -> {
                estebdadScore += answer.answer
            }
            ghate.contains(questionNum) -> {
                ghateScore += answer.answer
            }
            else -> {
                biEtenaScore += answer.answer
            }
        }
    }
    sahlGirScore /= sahlGir.size
    estebdadScore /= estebdad.size
    ghateScore /= ghate.size
    biEtenaScore /= biEtena.size
    var result = ""
    result += if (sahlGirScore >= 1.6) {
        "شما سهل گیر هستید! \n"
    } else {
        "شما سهل گیر نیستید! \n"
    }
    result += if (estebdadScore >= 2.4) {
        "شما مستبد هستید! \n"
    } else {
        "شما مستبد نیستید! \n"
    }
    result += if (ghateScore >= 2.4) {
        "شما قاطع هستید! \n"
    } else {
        "شما قاطع نیستید! \n"
    }
    result += if (biEtenaScore >= 2) {
        "شما بی اعتنا هستید! \n"
    } else {
        "شما بی اعتنا نیستید! \n"
    }
    return result
}

private val sahlGir = arrayListOf(9, 17, 19, 20)
private val estebdad = arrayListOf(2, 3, 8, 11, 13, 16)
private val ghate = arrayListOf(4, 6, 7, 10, 18, 21)
private val biEtena = arrayListOf(1, 5, 12, 14, 15)