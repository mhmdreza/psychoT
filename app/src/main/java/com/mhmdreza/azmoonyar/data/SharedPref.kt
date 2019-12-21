package com.mhmdreza.azmoonyar.data

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.google.gson.Gson

const val AZMOON_YAR_KEY = "AZMOON_YAR"
const val QUIZ_RESULTS_KEY = "QUIZ_RESULTS_KEY"
const val USERNAME_KEY = "USERNAME_KEY"


class SharedPref private constructor(private val x: Context) {


    private val pref: SharedPreferences by lazy {
        x.getSharedPreferences(
            AZMOON_YAR_KEY, MODE_PRIVATE
        )
    }

    fun getUsername() = pref.getString(USERNAME_KEY, "") ?: ""

    fun setUsername(username: String) {
        pref.edit().putString(USERNAME_KEY, username).apply()
    }

    fun addQuizResult(quizResult: QuizResult) {
        val set = pref.getStringSet(QUIZ_RESULTS_KEY, setOf())
        val list = arrayListOf<String>(Gson().toJson(quizResult))
        if (set.isNullOrEmpty().not()) {
            list.addAll(0, set!!)
        }
        pref.edit().putStringSet(QUIZ_RESULTS_KEY, list.toSet()).apply()
    }

    fun getQuizResults(): ArrayList<QuizResult> {
        val result = arrayListOf<QuizResult>()
        val set = pref.getStringSet(QUIZ_RESULTS_KEY, setOf())
        if (set.isNullOrEmpty().not()) {
            set!!.forEach {
                result.add(Gson().fromJson(it, QuizResult::class.java))
            }
        }
        return result
    }
    companion object {
        private lateinit var singleton: SharedPref

        @Synchronized
        fun getInstance(context: Context): SharedPref {
            if (::singleton.isInitialized.not()) singleton = SharedPref(context)
            return singleton
        }
    }
}