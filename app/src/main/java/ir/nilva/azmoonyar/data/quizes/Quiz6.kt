package ir.nilva.azmoonyar.data.quizes

import ir.nilva.azmoonyar.data.Answer

fun getQuiz6Result(answerList: ArrayList<Answer>): String {
    var result = ""
    var fatherSum = 0
    var motherSum = 0
    answerList.forEachIndexed { index, answer ->
        val parseAnswer = parseAnswer(answer)
        fatherSum += parseAnswer.fatherAnswer
        motherSum += parseAnswer.motherAnswer
        when (index) {
            4 -> {
                if (fatherSum != 0) {
                    result += "شما از لحاظ پدر مشکل محرومیت عاطفی " + (if (fatherSum > 20) "دارید" else "ندارید") + "\n"
                }
                if (motherSum != 0) {
                    result += "شما از لحاظ مادر مشکل محرومیت عاطفی " + (if (motherSum > 20) "دارید" else "ندارید") + "\n"
                }
                fatherSum = 0
                motherSum = 0
            }
            8 -> {
                if (fatherSum != 0) {
                    result += "شما از لحاظ پدر مشکل رها " + (if (fatherSum > 16) "شده اید" else "نشده اید") + "\n"
                }
                if (motherSum != 0) {
                    result += "شما از لحاظ مادر مشکل رها " + (if (motherSum > 16) "شده اید" else "نشده اید") + "\n"
                }
                fatherSum = 0
                motherSum = 0
            }
            12 -> {
                if (fatherSum != 0) {
                    result += "شما از لحاظ پدر مشکل بی اعتمادی " + (if (fatherSum > 16) "دارید" else "ندارید") + "\n"
                }
                if (motherSum != 0) {
                    result += "شما از لحاظ مادر مشکل بی اعتمادی " + (if (fatherSum > 16) "دارید" else "ندارید") + "\n"
                }
                fatherSum = 0
                motherSum = 0
            }
            23 -> {
                if (fatherSum != 0) {
                    result += "شما از لحاظ پدر مشکل نقص و شرم " + (if (fatherSum > 16) "دارید" else "ندارید") + "\n"
                }
                if (motherSum != 0) {
                    result += "شما از لحاظ مادر مشکل نقص و شرم " + (if (motherSum > 16) "دارید" else "ندارید") + "\n"
                }
                fatherSum = 0
                motherSum = 0
            }
            27 -> {
                if (fatherSum != 0) {
                    result += "شما از لحاظ پدر مشکل شکست " + (if (fatherSum > 16) "خورده اید" else "نخورده اید") + "\n"
                }
                if (motherSum != 0) {
                    result += "شما از لحاظ مادر مشکل شکست " + (if (motherSum > 16) "خورده اید" else "نخورده اید") + "\n"
                }
                fatherSum = 0
                motherSum = 0
            }
            19 -> {
                if (fatherSum != 0) {
                    result += "شما از لحاظ پدر مشکل وابستگی " + (if (fatherSum > 12) "دارید" else "ندارید") + "\n"
                }
                if (motherSum != 0) {
                    result += "شما از لحاظ مادر مشکل وابستگی " + (if (motherSum > 12) "دارید" else "ندارید") + "\n"
                }
                fatherSum = 0
                motherSum = 0
            }
            16 -> {
                if (fatherSum != 0) {
                    result += "شما از لحاظ پدر مشکل آسیب پذیری " + (if (fatherSum > 16) "دارید" else "ندارید") + "\n"
                }
                if (motherSum != 0) {
                    result += "شما از لحاظ مادر مشکل آسیب پذیری " + (if (motherSum > 16) "دارید" else "ندارید") + "\n"
                }
                fatherSum = 0
                motherSum = 0
            }
            54 -> {
                if (fatherSum != 0) {
                    result += "شما از لحاظ پدر مشکل خود تحول نایافته " + (if (fatherSum > 16) "دارید" else "ندارید") + "\n"
                }
                if (motherSum != 0) {
                    result += "شما از لحاظ مادر مشکل خود تحول نایافته " + (if (motherSum > 16) "دارید" else "ندارید") + "\n"
                }
                fatherSum = 0
                motherSum = 0
            }
            31 -> {
                if (fatherSum != 0) {
                    result += "شما از لحاظ پدر مشکل اطاعت " + (if (fatherSum > 16) "دارید" else "ندارید") + "\n"
                }
                if (motherSum != 0) {
                    result += "شما از لحاظ مادر مشکل اطاعت " + (if (motherSum > 16) "دارید" else "ندارید") + "\n"
                }
                fatherSum = 0
                motherSum = 0
            }
            35 -> {
                if (fatherSum != 0) {
                    result += "شما از لحاظ پدر مشکل ایثار " + (if (fatherSum > 16) "دارید" else "ندارید") + "\n"
                }
                if (motherSum != 0) {
                    result += "شما از لحاظ مادر مشکل ایثار " + (if (motherSum > 16) "دارید" else "ندارید") + "\n"
                }
                fatherSum = 0
                motherSum = 0
            }
            63 -> {
                if (fatherSum != 0) {
                    result += "شما از لحاظ پدر مشکل بازداری هیجانی " + (if (fatherSum > 20) "دارید" else "ندارید") + "\n"
                }
                if (motherSum != 0) {
                    result += "شما از لحاظ مادر مشکل بازداری هیجانی " + (if (motherSum > 20) "دارید" else "ندارید") + "\n"
                }
                fatherSum = 0
                motherSum = 0
            }
            42 -> {
                if (fatherSum != 0) {
                    result += "شما از لحاظ پدر مشکل معیارهای سرسختانه " + (if (fatherSum > 28) "دارید" else "ندارید") + "\n"
                }
                if (motherSum != 0) {
                    result += "شما از لحاظ مادر مشکل معیارهای سرسختانه " + (if (motherSum > 28) "دارید" else "ندارید") + "\n"
                }
                fatherSum = 0
                motherSum = 0
            }
            46 -> {
                if (fatherSum != 0) {
                    result += " شما از لحاظ پدر مشکل استحقاق/ بزرگ منشی " + (if (fatherSum > 16) "دارید" else "ندارید") + "\n"
                }
                if (motherSum != 0) {
                    result += " شما از لحاظ مادر مشکل استحقاق/ بزرگ منشی " + (if (motherSum > 16) "دارید" else "ندارید") + "\n"
                }
                fatherSum = 0
                motherSum = 0
            }
            50 -> {
                if (fatherSum != 0) {
                    result += " شما از لحاظ پدر مشکل خویشتنداری و خودانضباطی ناكافی " + (if (fatherSum > 16) "دارید" else "ندارید") + "\n"
                }
                if (motherSum != 0) {
                    result += " شما از لحاظ مادر مشکل خویشتنداری و خودانضباطی ناكافی " + (if (motherSum > 16) "دارید" else "ندارید") + "\n"
                }
                fatherSum = 0
                motherSum = 0
            }
            71 -> {
                if (fatherSum != 0) {
                    result += " شما از لحاظ پدر مشکل  پذیرش جویی/ جلب توجه " + (if (fatherSum > 16) "دارید" else "ندارید") + "\n"
                }
                if (motherSum != 0) {
                    result += " شما از لحاظ مادر مشکل  پذیرش جویی/ جلب توجه " + (if (motherSum > 16) "دارید" else "ندارید") + "\n"
                }
                fatherSum = 0
                motherSum = 0
            }
            58 -> {
                if (fatherSum != 0) {
                    result += " شما از لحاظ پدر مشکل منفی گرایی/ بدبینی " + (if (fatherSum > 16) "دارید" else "ندارید") + "\n"
                }
                if (motherSum != 0) {
                    result += " شما از لحاظ مادر مشکل منفی گرایی/ بدبینی " + (if (motherSum > 16) "دارید" else "ندارید") + "\n"
                }
                fatherSum = 0
                motherSum = 0
            }
            67 -> {
                if (fatherSum != 0) {
                    result += " شما از لحاظ پدر مشکل تنبیه" + (if (fatherSum > 16) "دارید" else "ندارید") + "\n"
                }
                if (motherSum != 0) {
                    result += " شما از لحاظ مادر مشکل تنبیه" + (if (motherSum > 16) "دارید" else "ندارید") + "\n"
                }
                fatherSum = 0
                motherSum = 0
            }
        }
    }
    return result
}

fun parseAnswer(it: Answer): ParentAnswer {
    return when (it.extra) {
        "f" -> ParentAnswer(it.answer, 0)
        "m" -> ParentAnswer(0, it.answer)
        "fm" -> ParentAnswer(it.answer / 10, it.answer % 10)
        else -> ParentAnswer(0, 0)
    }
}

class ParentAnswer(val fatherAnswer: Int, val motherAnswer: Int)
