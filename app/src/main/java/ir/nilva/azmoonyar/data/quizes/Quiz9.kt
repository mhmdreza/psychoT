package ir.nilva.azmoonyar.data.quizes

import ir.nilva.azmoonyar.data.Answer
import ir.nilva.azmoonyar.data.Question
import ir.nilva.azmoonyar.data.Quiz
import ir.nilva.azmoonyar.data.descriptionList

const val TRADEOFF = "tradeoff"


fun getQuiz9(): Quiz {
    val quiz = Quiz(
        8,
        "راهنمای مقیاس فرزندپروری آرنولد",
        descriptionList[8],
        AnswerType.TRADE_OFF,
        price = 3000
    )
    questions9.forEachIndexed { index, arnoldModel ->
        quiz.questions.add(
            Question(
                index + 1,
                arnoldModel.title,
                arrayListOf(TRADEOFF, arnoldModel.startRange, arnoldModel.endRange)
            )
        )
    }
    return quiz
}

val questions9 = arrayListOf(
    ArnoldModel(
        "وقتی كودكم بد رفتاری می\u200Cكند.",
        "بلافاصله واكنش نشان می\u200Cدهم.",
        "صبر می\u200Cكنم و بعداً واكنش نشان می\u200Cدهم."
    ),
    ArnoldModel(
        "قبل از آن كه با مشكلی برخورد كنم.",
        "چند بار به كودكم تذكر یا هشدار می\u200Cدهم.   ",
        "تنها از یك بار تذكر یا هشدار استفاده می\u200Cكنم."
    ),
    ArnoldModel(
        "وقتی عصبی یا تحت فشار هستم.",
        "ایرادگیر می\u200Cشوم و به كودكم گیر می\u200Cدهم.",
        "بیشتر از حد معمول ایراد نمی\u200Cگیرم."
    ),
    ArnoldModel(
        "وقتی به كودكم می\u200Cگویم كاری را انجام ندهد.",
        "یك یا دو بار می\u200Cگویم",
        "چند بار می\u200Cگویم."
    ),
    ArnoldModel(
        "وقتی كودكم مرا ذله می\u200Cكند.",
        "می\u200Cتوانم این رفتار را نادیده بگیرم.",
        "نمی\u200Cتوانم این رفتار را نادیده بگیرم."
    ),

    ArnoldModel(
        "وقتی كودكم بدرفتاری می\u200Cكند. ",
        "معمولاً وارد یك مشاجره طولانی با او می\u200Cشوم.",
        "با او مشاجره نمی\u200Cكنم."
    ),
    ArnoldModel(
        "به انجام كاری تهدید می\u200Cكنم كه.",
        "مطمئنم می\u200Cتوانم انجام دهم.",
        "می\u200Cدانم عملاً انجام نخواهم داد."
    ),
    ArnoldModel(
        "من از آن دسته والدینی هستم كه در مورد آن چه كودكم اجازه دارد انجام دهد،",
        "می\u200Cگذارم كودكم هر كاری كه می\u200Cخواهد، انجام دهد.",
        "محدودیت می\u200Cگذارم."
    ),
    ArnoldModel(
        "وقتی كودكم بدرفتاری می\u200Cكند.",
        "با او مفصلاً در مورد رفتارش صحبت می\u200Cكنم.",
        " صحبتم را كوتاه می\u200Cكنم و به مسأله اصلی اشاره می\u200Cكنم."
    ),
    ArnoldModel(
        "وقتی كودكم بد رفتاری می\u200Cكند.",
        "صدایم را بلند می\u200Cكنم یا فریاد می\u200Cزنم.",
        "به آرامی با كودكم صحبت می\u200Cكنم."
    ),

    ArnoldModel(
        "اگر گفتن نه همان موقع مؤثر نباشد.",
        "كار دیگری را پیش می\u200Cگیرم.",
        "صحبتم را ادامه می\u200Cدهم تا وقتی كه حرفم را در كله\u200Cاش فرو كنم."
    ),
    ArnoldModel(
        "وقتی بخواهم كودكم انجام كاری را متوقف نماید.",
        " با لحن محكم به كودكم می\u200Cگویم دیگر كافی است.",
        "با چرب\u200Cزبانی سعی می\u200Cكنم دل او را به دست آورم یا خواهش و تمنا می\u200C\u200Cكنم كه بس كند."
    ),
    ArnoldModel(
        "وقتی كودكم خارج از دید من است.",
        " اغلب نمی\u200Cدانم كودكم در حال انجام چه كاری است.",
        "همیشه به خوبی حدس می\u200Cزنم كه چه كاری می\u200Cكند."
    ),
    ArnoldModel(
        "بعد از این كه با كودكم مشكل داشته\u200Cام.",
        "غالباً كینه را نگه می\u200Cدارم.",
        "همه چیز سریع به حال عادی بر می\u200Cگردد."
    ),
    ArnoldModel(
        "وقتی در خانه نیستیم.",
        "با كودكم مثل وقتی كه در خانه هستیم رفتار می\u200Cكنم.",
        "  خیلی بیشتر به او اجازه می\u200Cدهم تا كارهایی را كه  "
    ),

    ArnoldModel(
        "وقتی كودكم كاری را انجام می\u200Cدهد كه دوست ندارم.",
        "هر بار كه اتفاق می\u200Cافتد واكنش نشان می\u200Cدهم.",
        "غالباً به روی خودم نمی\u200Cآورم."
    ),
    ArnoldModel(
        "وقتی با كودكم مشكل دارم.",
        "شرایط از كنترلم خارج شده و من كارهایی می\u200Cكنم  كه واقعاً دلم نمی\u200Cخواهد انجام دهم.",
        "چیزی از كنترلم خارج نمی\u200Cشود."
    ),
    ArnoldModel(
        "وقتی كودكم بدرفتاری می\u200Cكند به پشت باسنش می\u200Cزنم، به پشت دستش می\u200Cزنم، هلش می\u200Cدهم یا كتكش می\u200Cزنم.",
        "هرگز به ندرت", "اكثر اوقات"
    ),
    ArnoldModel(
        "وقتی كودكم كاری را كه خواسته\u200Cام انجام نمی\u200Cدهد. ",
        "اغلب به روی خودم نمی\u200Cآورم یا بالاخره خودم آن كار را انجام می\u200Cدهم.",
        " كار دیگری انجام می\u200Cدهم."
    ),
    ArnoldModel(
        "وقتی تهدید یا هشدار مناسب و بجایی می\u200Cدهم.",
        "غالباً به آن عمل نمی\u200Cكنم.",
        "همیشه آن چه را گفته\u200Cام انجام می\u200Cدهم."
    ),

    ArnoldModel(
        "اگر گفتن \"نه\"  میسر نباشد.",
        "كار دیگری انجام می\u200Cدهم. ",
        "جایزه جالبی را به كودكم پیشنهاد می\u200Cكنم تا آن كار را انجام دهد."
    ),
    ArnoldModel(
        "وقتی كودكم بدرفتاری می\u200Cكند. ",
        "بدون این\u200Cكه عصبی شوم با او برخورد می\u200Cكنم.",
        "آن قدر آزرده و عصبی می\u200Cشوم كه كودكم متوجه می\u200Cشود كه عصبی هستم."
    ),
    ArnoldModel(
        "وقتی كودكم بدرفتاری می\u200Cكند.",
        "كودكم را وادار می\u200Cكنم بگوید كه چرا این كار را انجام داده است.",
        "می\u200Cگویم \"نه\" یا كار دیگری می\u200Cكنم."
    ),
    ArnoldModel(
        "اگر كودكم بدرفتاری كند و سپس معذرت\u200Cخواهی كند.",
        "مثل همیشه با مشكل برخورد می\u200Cكنم.", "این بار برخوردی نمی\u200Cكنم. "
    ),
    ArnoldModel(
        "وقتی كودكم بدرفتاری می\u200Cكند.",
        "به ندرت از بدزبانی یا نفرین استفاده می\u200Cكنم.",
        "تقریباً همیشه بدزبانی می\u200Cكنم."
    ),

    ArnoldModel(
        "وقتی به كودكم می\u200Cگویم اجازه ندارد كاری را انجام دهد.",
        "به هر حال می\u200Cگذارم آن كار را انجام دهد.", "سرحرفم می\u200Cایستم."
    ),
    ArnoldModel(
        "وقتی باید با مشكلی برخورد كنم.",
        "به كودكم می\u200Cگویم از این بابت متأسفم.", "می\u200Cگویم متأسفم."
    ),
    ArnoldModel(
        "وقتی كودكم كاری را انجام می\u200Cدهد كه دوست ندارم، به كودكم توهین می\u200Cكنم، حرف\u200Cهایی می\u200Cزنم كه او را برنجاند یا به او فحش\u200C می\u200Cدهم.",
        "هرگز یا به ندرت", "اكثر اوقات"
    ),
    ArnoldModel(
        "اگر وقتی با مشكلی برخورد می\u200Cكنم كودكم حاضر جوابی یا شكایت كند.",
        "شكایتش را نادیده گرفته و سرحرفم می\u200Cایستم.",
        "با كودكم صحبت می\u200Cكنم كه نباید شكایت كند."
    ),
    ArnoldModel(
        "اگر كودكم وقتی كه می\u200Cگویم \"نه\" عصبی شود.",
        "حرفم را پس می\u200Cگیرم و تسلیم كودكم می\u200Cشوم.", "سر حرفم می\u200Cایستم."
    )
)

class ArnoldModel(val title: String, val startRange: String, val endRange: String)


fun getQuiz9Result(answerList: ArrayList<Answer>): FinalResult {
    val sumOfAnswers = answerList.sumBy { it.answer }
    if (sumOfAnswers == getBadResult(
            AnswerType.TRADE_OFF,
            answerList.size
        ) || sumOfAnswers == answerList.size
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
    firstScore /= first.size
    secondScore /= second.size
    thirdScore /= third.size
    var result = ""
    val max = maxOf(firstScore, secondScore, thirdScore)
    if (firstScore == max) {
        result += "رفتار افراطی در اهمال کاری\n"
    }
    if (secondScore == max){
        result +=  "رفتار افراطی در واکنش بیش از حد\n"
    }
    if (thirdScore == max) {
        result += "رفتار افراطی در پرگویی در کلام\n"
    }
    return FinalResult(result, emptyList())
}

private val first = arrayListOf(7, 8, 12, 15, 16, 19, 20, 21, 24, 26, 30) //1.	اهمال کاری
private val second = arrayListOf(3, 6, 9, 10, 14, 17, 18, 22, 25, 28) //2.	واکنش بیش از حد
private val third = arrayListOf(2, 4, 7, 9, 11, 23, 29)// 3.	پرگویی در کلام