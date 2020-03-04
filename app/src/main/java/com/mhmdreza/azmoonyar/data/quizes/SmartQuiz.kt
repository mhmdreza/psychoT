package com.mhmdreza.azmoonyar.data.quizes

import com.mhmdreza.azmoonyar.data.*

enum class AnswerType {
    AGREEMENT_LEVEL_4,
    AGREEMENT_LEVEL_5,
    TRADE_OFF,
    PARENT_CHOICE,
    FREQUENCY_LEVEL
}

data class FinalResult(val text: String, val targetQuestions: ArrayList<Int>)

enum class QuizType(
    val id: Int,
    val title: String,
    val answerType: AnswerType,
    val finalResults: List<FinalResult> = emptyList(),
    val price: Int = 0
) {
    QUIZ1(
        0,
        "مقیاس روشهای فرزند پروری",
        AnswerType.AGREEMENT_LEVEL_4,
        arrayListOf(
            FinalResult(
                "شما سهل گیر هستید!",
                arrayListOf(2, 7, 9, 12, 14, 16, 19)
            ),
            FinalResult(
                "شما مستبد هستید!",
                arrayListOf(1, 3, 5, 8, 11, 17)
            ),
            FinalResult(
                "شما قاطع هستید!",
                arrayListOf(4, 6, 10, 13, 15, 18, 20)
            )
        )
    ),
    QUIZ2(
        1,
        "مقیاس سبک تربیتی والدین",
        AnswerType.AGREEMENT_LEVEL_5,
        arrayListOf(
            FinalResult(
                "شما سهل گیر هستید!",
                arrayListOf(9, 17, 19, 20)
            ),
            FinalResult(
                "شما مستبد هستید!",
                arrayListOf(2, 3, 8, 11, 13, 16)
            ),
            FinalResult(
                "شما قاطع هستید!",
                arrayListOf(4, 6, 7, 10, 18, 21)
            ),
            FinalResult(
                "شما بی اعتنا هستید!",
                arrayListOf(1, 5, 12, 14, 15)
            )
        )
    ),
    QUIZ3(
        2,
        "پرسشنامه شیوه\u200Cهای فرزندپروری بامریند",
        AnswerType.AGREEMENT_LEVEL_5,
        arrayListOf(
            FinalResult(
                "شما سهل گیر هستید!",
                arrayListOf(1, 6, 10, 13, 14, 17, 19, 24, 28, 29)
            ),
            FinalResult(
                "شما مستبد هستید!",
                arrayListOf(2, 3, 7, 9, 12, 16, 18, 21, 25, 26)
            ),
            FinalResult(
                "شما قاطع هستید!",
                arrayListOf(4, 5, 8, 11, 15, 20, 22, 23, 27, 30)
            )
        )
    ),
    QUIZ4(
        3,
        "پرسشنامه فرزندپروری آلاباما (فرم والدین)",
        AnswerType.FREQUENCY_LEVEL,
        arrayListOf(
            FinalResult(
                "مشارکت مناسب والدین",
                arrayListOf(1, 4, 7, 9, 11, 14, 15, 20, 23, 26)
            ),
            FinalResult(
                "فرزندپروری مثبت",
                arrayListOf(2, 5, 13, 16, 18, 27)
            ),
            FinalResult(
                "عدم ثبات در نحوه برخورد با فرزند",
                arrayListOf(3, 8, 12, 22, 25, 31)
            ),
            FinalResult(
                "ضعف در نظارت و راهنمایی مناسب",
                arrayListOf(6, 10, 17, 19, 21, 24, 28, 29, 30, 32)
            ),
            FinalResult(
                "بکاربردن تنبیه بدنی",
                arrayListOf(33, 35, 39)
            )
        )
    ),
    QUIZ5(
        4,
        "پرسشنامه فرزندپروری آلاباما (فرم كودكان)",
        AnswerType.FREQUENCY_LEVEL,
        arrayListOf(
            FinalResult(
                "مشارکت مناسب مادر",
                arrayListOf(1, 5, 9, 12, 15, 19, 21, 27, 31, 35)
            ),
            FinalResult(
                "مشارکت مناسب پدر",
                arrayListOf(2, 6, 10, 13, 16, 20, 22, 28, 32, 36)
            ),
            FinalResult(
                "فرزندپروری مثبت",
                arrayListOf(3, 7, 18, 23, 25, 37)
            ),
            FinalResult(
                "عدم ثبات در نحوه برخورد با فرزند",
                arrayListOf(4, 11, 17, 30, 34, 41)
            ),
            FinalResult(
                "ضعف در نظارت و راهنمایی مناسب",
                arrayListOf(8, 14, 24, 26, 29, 33, 38, 39, 40, 42)
            ),
            FinalResult(
                "بکاربردن تنبیه بدنی",
                arrayListOf(43, 45, 49)
            )
        )
    ),
    QUIZ6(
        5,
        "پرسشنامه فرزندپروری یانگ",
        AnswerType.PARENT_CHOICE
    ),
    QUIZ7(
        6,
        "پرسشنامه والدگری آلاباما",
        AnswerType.FREQUENCY_LEVEL,
        arrayListOf(
            FinalResult(
                "والدگری مثبت",
                arrayListOf(1, 6, 7)
            ),
            FinalResult(
                "عدم ثبات در نحوه برخورد با فرزند",
                arrayListOf(2, 4, 9)
            ),
            FinalResult(
                "ضعف در هدایت و راهنمایی",
                arrayListOf(3, 5, 8)
            )
        ), 1000
    ),
}

fun getQuiz(quizType: QuizType): Quiz {
    val quiz = Quiz(
        quizType.id,
        quizType.title,
        descriptionList[quizType.id],
        quizType.answerType,
        price = quizType.price
    )
    questionsList[quizType.id].forEachIndexed { index, s ->
        quiz.questions.add(Question(index + 1, s))
    }
    return quiz
}


fun getQuizResult(quizType: QuizType, answerList: ArrayList<Answer>): String {
    val finalAnswers = quizType.finalResults
    val scores = Array(finalAnswers.size) { 0 }
    finalAnswers.forEachIndexed { index, finalAnswer ->
        answerList.forEachIndexed { answerIndex, answer ->
            if (finalAnswer.targetQuestions.contains(answerIndex + 1)) {
                scores[index] += answer.answer
            }
        }
        scores[index] /= finalAnswer.targetQuestions.size
    }
    return finalAnswers[scores.indices.maxBy { scores[it] } ?: 0].text
}
