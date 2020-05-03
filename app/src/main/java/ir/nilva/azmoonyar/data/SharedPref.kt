package ir.nilva.azmoonyar.data

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.caverock.androidsvg.IntegerParser
import com.google.gson.Gson
import java.util.*
import kotlin.collections.ArrayList


const val AZMOON_YAR_KEY = "AZMOON_YAR"
const val QUIZ_RESULTS_KEY = "QUIZ_RESULTS_KEY"
const val PAID_QUIZ_KEY = "PAID_QUIZ_KEY"
const val USERNAME_KEY = "USERNAME_KEY"
const val QUIZ_ID_KEY = "QUIZ_ID_KEY"


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

    fun getPayQuizId() = pref.getInt(QUIZ_ID_KEY, -1)

    fun setPayQuizId(quizId: Int) {
        pref.edit().putInt(QUIZ_ID_KEY, quizId).apply()
    }

    fun removePayQuizId() {
        pref.edit().remove(QUIZ_ID_KEY).apply()
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

    fun setSuccessfulPayment() {
        val list = getSuccessfulPayments().apply { add(getPayQuizId()) }
        val str = StringBuilder()
        for (i in list.indices) {
            str.append(list[i]).append(",")
        }
        pref.edit().putString("string", str.toString()).apply()

    }

    private fun getSuccessfulPayments(): ArrayList<Int> {
        val savedString: String = pref.getString(PAID_QUIZ_KEY, "") ?: ""
        val st = StringTokenizer(savedString, ",")
        val savedList = arrayListOf<Int>()
        if (st.hasMoreTokens().not()) return arrayListOf()
        var a = st.nextToken()
        while (a.isNotEmpty()) {
            savedList.add(Integer.parseInt(a))
            if (st.hasMoreTokens())
                a = st.nextToken()
            else return savedList
        }
        return savedList
    }

    fun hasPaid(id: Int) = getSuccessfulPayments().contains(id)

    companion object {
        private lateinit var singleton: SharedPref

        @Synchronized
        fun getInstance(context: Context): SharedPref {
            if (::singleton.isInitialized.not()) singleton = SharedPref(context)
            return singleton
        }
    }
}