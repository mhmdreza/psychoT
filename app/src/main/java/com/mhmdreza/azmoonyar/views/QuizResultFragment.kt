package com.mhmdreza.azmoonyar.views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.mhmdreza.azmoonyar.R
import com.mhmdreza.azmoonyar.data.QuizResult
import com.mhmdreza.azmoonyar.data.SharedPref
import com.mhmdreza.azmoonyar.util.calculateQuizResultText
import com.mhmdreza.azmoonyar.util.normalizeTime
import kotlinx.android.synthetic.main.fragment_quiz_result.*


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
        subtitle.text = normalizeTime(quizResult.time)
        quizResultTextView.text = calculateQuizResultText(quizResult)
        SharedPref.getInstance(view.context).addQuizResult(quizResult)
        exitButton.setOnClickListener {
            navController.popBackStack(R.id.mainFragment, false)
        }
    }


}
