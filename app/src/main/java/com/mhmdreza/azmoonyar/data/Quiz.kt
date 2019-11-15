package com.mhmdreza.azmoonyar.data

import java.io.Serializable

class Quiz(
    val id: Int,
    val title: String,
    val description: String,
    val questions: ArrayList<Question>
) : Serializable