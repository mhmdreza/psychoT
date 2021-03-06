package ir.nilva.azmoonyar.data

import android.text.Spannable
import ir.nilva.azmoonyar.data.quizes.AnswerType
import java.io.Serializable

class Quiz(
    val id: Int,
    val title: String,
    val description: Spannable,
    val type: AnswerType,
    val questions: ArrayList<Question> = ArrayList(),
    val price: Int = 0
) : Serializable