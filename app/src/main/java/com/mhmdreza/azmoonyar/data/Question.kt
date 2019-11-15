package com.mhmdreza.azmoonyar.data

class Question(
    val id : Int,
    val questionTitle: String,
    val type: AnswerType,
    val extra : ArrayList<String> = arrayListOf()
)

enum class AnswerType {
    AGREEMENT_LEVEL_4,
    AGREEMENT_LEVEL_5,
    TRADE_OFF,
    PARENT_CHOICE,
    FREQUENCY_LEVEL
}
