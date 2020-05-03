package ir.nilva.azmoonyar.views


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ir.nilva.azmoonyar.R
import ir.nilva.azmoonyar.data.QuizResult
import ir.nilva.azmoonyar.data.SharedPref
import ir.nilva.azmoonyar.util.calculateQuizResult
import ir.nilva.azmoonyar.util.calculateQuizResultText
import ir.nilva.azmoonyar.util.normalizeTime
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

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments ?: return

        if (!arguments!!.containsKey(QUIZ_RESULT) || arguments!!.getSerializable(QUIZ_RESULT) !is QuizResult) return
        val quizResult = arguments!!.getSerializable(QUIZ_RESULT) as QuizResult
        subtitle.text = normalizeTime(quizResult.time)
        quizResultTextView.text = SharedPref.getInstance(context!!).getUsername() + " عزیز! \n" +calculateQuizResultText(quizResult)
        val result = calculateQuizResult(quizResult)
        quizDescriptionTextView.text = result.description
        if (result.isGood.not()) descTextView.visibility = View.VISIBLE
        SharedPref.getInstance(view.context).addQuizResult(quizResult)
        exitButton.setOnClickListener {
            navController.popBackStack(R.id.mainFragment, false)
        }
    }


}
