package com.mhmdreza.azmoonyar.views


import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.gson.Gson
import com.mhmdreza.azmoonyar.R
import com.mhmdreza.azmoonyar.data.QuizResult
import kotlinx.android.synthetic.main.fragment_quiz_result.*

const val QUIZ_RESULTS_KEY = "QUIZ_RESULTS_KEY"

class QuizResultFragment : Fragment() {

    private val navController by lazy { Navigation.findNavController(view!!) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments ?: return
        if (!arguments!!.containsKey(QUIZ_RESULT) || arguments!!.getSerializable(QUIZ_RESULT) !is QuizResult) return
        val quizResult = arguments!!.getSerializable(QUIZ_RESULT) as QuizResult
        saveToPref(view, quizResult)
        backQQQ.setOnClickListener {
            navController.popBackStack(R.id.mainFragment, false)
        }
    }

    private fun saveToPref(view: View, quizResult: QuizResult) {
        val sharedPreferences = view.context.getSharedPreferences("APP_NAME", MODE_PRIVATE)
        val set = sharedPreferences.getStringSet(QUIZ_RESULTS_KEY, setOf())
        val list = arrayListOf<String>(Gson().toJson(quizResult))
        if (set.isNullOrEmpty().not()) {
            list.addAll(0, set!!)
        }
        sharedPreferences.edit().putStringSet(QUIZ_RESULTS_KEY, list.toSet()).apply()
    }


}
