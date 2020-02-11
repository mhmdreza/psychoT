package com.mhmdreza.azmoonyar.data.quizes

import android.text.Spannable
import android.text.SpannableStringBuilder
import androidx.core.text.bold
import androidx.core.text.toSpannable
import com.mhmdreza.azmoonyar.data.AnswerType
import com.mhmdreza.azmoonyar.data.Question
import com.mhmdreza.azmoonyar.data.Quiz

fun getQuiz6(): Quiz {
    val quiz = Quiz(
        5,
        "پرسشنامه فرزندپروری یانگ",
        getDescription(),
        AnswerType.PARENT_CHOICE
    )
    questions6.forEachIndexed { index, s ->
        quiz.questions.add(Question(index + 1, s))
    }
    return quiz
}

private fun getDescription(): Spannable {
    return SpannableStringBuilder()
        .bold { append( "\n\nمعرفی\n") }
        .append(
            "اين ابزار اقتباسي است از نظريه اقتدار والدين كه بر اساس نظريه بامريند از آزادگذاري، استبدادي و اقتدار منطقي والدين، براي بررسي الگوهاي نفوذ و شيوه\u200Cهاي فرزندپروري ساخته شده است. اين پرسشنامه شامل 30 ماده است كه 10 ماده آن به شيوه آزادگذاري مطلق، 10 ماده به شيوه استبدادي و 10 ماده ديگر به شيوه اقتدار منطقي والدين در امر پرورش فرزند مربوط مي\u200Cشود. " + "\n"
        )
        .bold { append("والدين گرامي: با سلام\n") }
        .append("\n" +
                "معمولاً والدين روش\u200Cهاي متفاوتي براي تربيت فرزندان به\u200Cكار مي\u200Cگيرند. در ادامه عباراتي می\u200Cآید كه برخي از روش\u200Cهاي فرزندپروري را توصيف مي\u200Cكند. پاسخ هر عبارت در يك پيوستار 5 درجه\u200Cاي از كاملاً موافقم تا كاملاً مخالفم قرار گرفته است. لطفاً هر يك از عبارات را به\u200Cدقت مطالعه كرده و مناسب\u200Cترين پاسخ كه با نگرش تربيتي شما هماهنگ است را انتخاب كنيد.")
        .append("\n\n")
        .toSpannable()
}


val questions6 = arrayListOf(
    "عاشقانه مرا دوست داشت و با من مانند يك فرد خاص رفتار مي\u200Cكرد.",
    "زمان هايي را به من اختصاص مي\u200Cداد و به من توجه مي\u200Cكرد.",
    "راهنمايي مفيد و مشورت كمك كننده به من مي\u200Cداد.",
    "حرف\u200Cهاي مرا گوش مي\u200Cكرد، مرا مي\u200Cفهميد، مرا در احساسات خود سهيم مي\u200Cكرد.",
    "گرم بود و محبت خود را به صورت نوازش و در آغوش گرفتن من نشان مي\u200Cداد.",
    "وقتي من بچه بودم فوت كرد يا منزل را براي هميشه ترك كرد.",
    "فردي غير قابل پيش بيني، داراي خلق ناپايدار بود.",
    "برادران يا خواهرانم را به من ترجيح مي\u200Cداد.",
    "براي مدت زمان هاي طولاني مرا تنها مي\u200Cگذاشت.",
    "به من دروغ مي\u200Cگفت، مرا فريب مي داد، با من دشمني مي\u200Cكرد.",
    "مرا مورد آزار جسمي، جنسي يا هيجاني قرار مي\u200Cداد.",
    "از من براي ارضاي نيازهايش استفاده مي\u200C\u200Cكرد.",
    "بنظر مي\u200Cرسيد كه از آزار دادن ديگران لذت مي\u200Cبرد.",
    "شديداً نگران بود كه مبادا به من آسيبي برسد. ",
    "شديداً نگران بود از اين كه من بيمار شوم.",
    "يك فرد ترسو بود. ",
    "بسيار از من حمايت مي\u200Cكرد.",
    "طوري با من رفتار كرده بود كه من احساس كنم نمي\u200Cتوانم به تصميمات يا قضاوت\u200Cهاي خودم اعتماد داشته باشم.",
    "به جاي اين كه اجازه بدهد من خودم به سبكي كه مي خواهم كارهايي را انجام دهم، براي من كارهاي زيادي مي\u200Cكرد.",
    "طوري با من رفتار مي\u200Cكرد كه انگار من خيلي جوانتر (كم سنتر) از سن واقعيم بودم.",
    "خيلي مرا سرزنش مي\u200Cكرد.",
    "طوري با من رفتار كرده بود كه من احساس مي\u200Cكردم دوست نداشتني يا طرد شده هستم.",
    "طوري با من رفتار مي\u200Cكرد كه انگار من ايرادي داشتم.",
    "طوري با من رفتار كرده بود كه من از اين كه مورد احترام قرار بگيرم خجالت مي\u200Cكشيدم.",
    "هرگز آموزش هاي لازم براي موفقيت در مدرسه را به من نياموخت.",
    "طوري با من رفتار مي\u200Cكرد كه انگار من احمق يا دست و پا چلفتي هستم.",
    "واقعاً نمي\u200Cخواست كه من موفق شوم.",
    "انتظار داشت كه من در زندگي يك شكست خورده باشم.",
    "طوري با من رفتار مي \u200Cرد كه انگار نقطه نظرات يا خواسته هاي من اهميتي ندارد.",
    "بدون در نظر گرفتن خواسته هاي من، هر كاري كه مي\u200Cخواست انجام مي\u200Cداد.",
    "طوري زندگي من را كنترل می\u200Cكرد كه من حداقل آزادي را براي انتخاب داشتم.",
    "هر چيزي مطابق نظرات و خواسته هاي والدينم بود.",
    "نيازهاي خودش را قرباني منافع خانواده مي\u200Cكرد.",
    "قادر نبود مسئوليت هاي روزانه خودش را انجام دهد در نتيجه من مجبور بودم بيش از مسئوليت خودم كار كنم.",
    "ناخرسند بود و براي حمايت و درك شدن به من متكي بود.",
    "احساس قوي بودن را در من ايجاد كرده بود به طوري كه من تصور می\u200Cکردم بايد از ديگران مراقبت كنم.",
    "انتظارات بسيار زيادي از خودش داشت. ",
    "از من انتظار داشت كه در همه حال و شرايط بهترين باشم و به بهترين نحو عمل كنم.",
    "در مورد من بسيار كمال گرا بود به طوري كه هر چيزي بايد به بهترين و كامل ترين نحو صورت مي\u200Cگرفت.",
    "اين احساس را در من ايجاد كرده بود كه انگار هر كاري را كه من انجام می\u200Cدهم ناقص يا اشتباه است.",
    "قوانين سفت و سخت و غير قابل انعطافي براي درست و نادرست قايل بود.",
    "در مقابل انجام نادرست يا كند كارها بسيار ناشكيبا )كم صبر و تحمل (بود",
    "اهميت بسيار زيادي بر درست انجام دادن كارها در مقابل لذت بردن از كار يا آرامش داشتن در كار قايل بود.",
    "در كارهاي من بسيار دخالت مي\u200Cكرد يا در بسيار موارد براي نظرات و كارهاي من ارزشي قايل نبود.",
    "اين احساس را در من ايجاد كرده بود كه من فرد خاصي هستم و از ديگران برتر هستم.",
    "تقاضاهاي زيادي از من داشت و انتظار داشت كه همه چيزها و كارها به روش و سبك او پيش برود.",
    "احساس مسئوليت در قبال ديگران را به من ياد نداده بود.",
    "قوانين و مقررات يا ساختارهاي محدودي را براي من ايجاد كرده بود.",
    "مقررات و مسئوليت هاي كمي براي من ايجاد كرده بود.",
    "به من اجازه داده بود تا بيش از حد عصباني شوم يا كنترل خودم را از دست بدهم.",
    "يك فرد بدون نظم و مقررات بود.",
    "ما بسيار به هم نزديك بوديم به طوري كه كاملاً همديگر را درك مي\u200Cكرديم.",
    "من احساس مي\u200Cكردم كه به حد کافی استقلال و فرديت خودم را نداشته و يك هویت مجزاي از او ندارم.",
    "من احساس مي\u200Cكردم كه انگار در طول رشد نمي\u200Cتوانم خودم را هدايت كنم و جهت خودم را تعيين كنم چون او يك فرد بسيار قدرتمند بود.",
    "من احساس مي\u200Cكردم كه اگر از همديگر جدا شويم آسيب خواهيم ديد.",
    "در مورد مشكلات مالي خانواده بسيار نگران بود.",
    "اين احساس را در من ايجاد كرده بود كه اگر كوچكترين خطايي از من سربزند، اتفاق بدي روي مي\u200Cدهد.",
    "يك ديدگاه منفي گرايانه داشت و اغلب منتظر بدترين نتيجه بود.",
    "بر جنبه\u200Cهاي منفي زندگي يا رويدادها تمركز مي\u200Cكرد.",
    "هر چيزي را تحت كنترل داشت.",
    "براي بيان عواطف و يا حساسيت هاي خود احساس راحتي نمي\u200Cکرد.",
    "سازمان يافته و با ساختار بود، ثبات را به تغيير ترجيح مي\u200Cداد.",
    "به ندرت خشم خود را بيان مي\u200Cكرد.",
    "بسيار تودار بود و به ندرت در مورد احساساتش صحبت مي\u200Cكرد.",
    "وقتي من كار اشتباهي انجام مي\u200Cدادم بسيار خشمگين مي\u200Cشد يا شديداً مرا سرزنش مي\u200Cكرد.",
    "اگر كار خطايي انجام مي دادم مرا تنبيه مي\u200Cكرد.",
    "اگر اشتباهي از من سر مي\u200Cزد مرا با برچسب هايي مثل احمق يا كودن صدا مي\u200Cكرد.",
    "وقتي كارها نادرست پيش مي\u200Cرفت ديگران را مورد سرزنش قرار مي\u200Cداد.",
    "خيلي به موقعيت اجتماعي و ظاهر اهميت مي\u200Cداد.",
    "تأكيد بسيار زيادي بر موفقيت و رقابت داشت.",
    "خيلي نگران اين مسأله بود كه رفتار من چطور در نظر ديگران جلوه مي\u200Cكند.",
    "به نظر مي\u200Cرسيد وقتي كه من كار درست انجام مي\u200Cدادم مرا بيشتر دوست می\u200Cدارد يا توجه بيشتري به من مي\u200Cكند."
    )