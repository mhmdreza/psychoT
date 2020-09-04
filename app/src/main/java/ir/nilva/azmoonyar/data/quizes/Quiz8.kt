package ir.nilva.azmoonyar.data.quizes

import ir.nilva.azmoonyar.data.Answer
import ir.nilva.azmoonyar.data.Question
import ir.nilva.azmoonyar.data.Quiz
import ir.nilva.azmoonyar.data.descriptionList

const val FATHER = "father"
const val MOTHER = "mother"


fun getQuiz8(): Quiz {
    val quiz = Quiz(
        7,
        "مقیاس شیوه فرزندپروری پارکر",
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
    "از من حمایت مفرط می\u200Cكرد.",
    "به صورت لفظی دشنام می\u200Cداد.",
    "من را بسیار كنترل می\u200Cكرد.",
    "سعی می\u200Cكرد كه در من احساس گناه به وجود آورد.",
    "من را نادیده می\u200Cگرفت.",
    "از من انتقاد می\u200Cكرد.",
    "برای من غیرقابل پیش بینی بود (رفتارش).",
    "به من بی\u200Cتوجه بود.",
    " با من خشونت فیزیكی داشت یا از من سوء استفاده جسمانی می\u200Cكرد.",
    "من را نمی\u200Cپذیرفت.",
    "زیاد من را تنها می\u200Cگذاشت.",
    "من را فراموش می\u200Cكرد.",
    "به من بی\u200Cعلاقه بود.",
    "به من این احساس را می\u200Cداد كه در معرض خطر هستم.",
    "به من احساس ناامنی می\u200Cداد."
)

val fatherQuestions = motherQuestions



fun getQuiz8Result(answerList: ArrayList<Answer>): FinalResult {
    val sumOfAnswers = answerList.sumBy { it.answer }
    val allOfAnswersTheSame = answerList.map { it.answer }.distinct().size == 1

    if (sumOfAnswers == getBadResult(
            AnswerType.AGREEMENT_LEVEL_4,
            answerList.size
        ) || sumOfAnswers == answerList.size
        || allOfAnswersTheSame
    ) {
        return FinalResult(
            text = "نتیجه آزمون اعتباری ندارد",
            description = "لطفا دوباره و با دقت به سوالات آزمون پاسخ دهید",
            targetQuestions = emptyList()
        )
    }
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
    return FinalResult(result, emptyList())
}

private val first = arrayListOf(5,8,10,11,12,13) //1.	بی تفاوت
private val second = arrayListOf(2,7,9,14,15) //2.	سو استفاده
private val third = arrayListOf(1,3,4,6)// 3.	کنترل مفرط
private val first2 = first.map{ it + 15 }.toList() //1.	بی تفاوت
private val second2 = second.map{ it + 15 }.toList()  //2.	سو استفاده
private val third2 = third.map{ it + 15 }.toList() // 3.	کنترل مفرط