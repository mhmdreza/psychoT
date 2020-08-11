package ir.nilva.azmoonyar.views


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import ir.nilva.azmoonyar.R
import ir.nilva.azmoonyar.data.DataProvider
import ir.nilva.azmoonyar.data.QuizResult
import ir.nilva.azmoonyar.data.SharedPref
import ir.nilva.azmoonyar.util.calculateQuizResult
import ir.nilva.azmoonyar.util.normalizeTime
import kotlinx.android.synthetic.main.fragment_result.descTextView
import kotlinx.android.synthetic.main.fragment_result.exitButton
import kotlinx.android.synthetic.main.fragment_result.quizDescriptionTextView
import kotlinx.android.synthetic.main.fragment_result.quizResultTextView
import kotlinx.android.synthetic.main.fragment_result.subtitle
import kotlinx.android.synthetic.main.fragment_result.title

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

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exitButton.setOnClickListener { navController.popBackStack(R.id.mainFragment, false) }

        arguments ?: return
        if (!arguments!!.containsKey(QUIZ_RESULT_KEY) || arguments!!.getSerializable(QUIZ_RESULT_KEY) !is QuizResult) return

        val quizResult = arguments!![QUIZ_RESULT_KEY] as QuizResult
        title.text = DataProvider.getInstance().quizList[quizResult.quizId].title
        subtitle.text = normalizeTime(quizResult.time)
        val result = calculateQuizResult(quizResult)
        quizDescriptionTextView.text = result.description
        if (result.isGood.not()) descTextView.visibility = View.VISIBLE
        quizResultTextView.text = SharedPref.getInstance().getUsername() + " عزیز! \n" + calculateQuizResult(quizResult).text
    }


}
