package com.mhmdreza.azmoonyar.views


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.mhmdreza.azmoonyar.data.QuizResult
import kotlinx.android.synthetic.main.fragment_result_list.*


/**
 * A simple [Fragment] subclass.
 */
class ResultListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(
            com.mhmdreza.azmoonyar.R.layout.fragment_result_list,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showPrefData(view)
    }

    private fun showPrefData(view: View) {
        val sharedPreferences = view.context.getSharedPreferences("APP_NAME", Context.MODE_PRIVATE)
        val set = sharedPreferences.getStringSet(QUIZ_RESULTS_KEY, setOf())
        results.text = "empty"
        set ?: return
        if (set.isEmpty()) return
        val fromJson: QuizResult = Gson().fromJson(set.elementAt(0), QuizResult::class.java)
        set.elementAt(0)
        results.text = fromJson.answerList.size.toString()
    }
}
