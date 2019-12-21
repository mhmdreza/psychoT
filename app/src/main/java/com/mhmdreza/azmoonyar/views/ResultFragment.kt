package com.mhmdreza.azmoonyar.views


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.mhmdreza.azmoonyar.R
import com.mhmdreza.azmoonyar.data.DataProvider
import com.mhmdreza.azmoonyar.data.QuizResult
import com.mhmdreza.azmoonyar.util.calculateQuizResultText
import com.mhmdreza.azmoonyar.util.normalizeTime
import kotlinx.android.synthetic.main.fragment_quiz_list.*
import kotlinx.android.synthetic.main.fragment_result.*

/**
 * A simple [Fragment] subclass.
 */
class ResultFragment : Fragment() {

    private val navController by lazy { Navigation.findNavController(view!!) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exitButton.setOnClickListener { navController.popBackStack(R.id.mainFragment, false) }

        arguments ?: return
        if (!arguments!!.containsKey(QUIZ_RESULT_KEY) || arguments!!.getSerializable(QUIZ_RESULT_KEY) !is QuizResult) return

        val quizResult = arguments!![QUIZ_RESULT_KEY] as QuizResult
        title.text = DataProvider.getInstance().quizList[quizResult.quizId].title
        subtitle.text = normalizeTime(quizResult.time)
        quizResultTextView.text = calculateQuizResultText(quizResult)
    }


}
