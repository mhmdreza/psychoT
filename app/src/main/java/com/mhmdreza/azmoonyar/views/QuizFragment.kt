package com.mhmdreza.azmoonyar.views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.mhmdreza.azmoonyar.data.Answer
import com.mhmdreza.azmoonyar.data.AnswerType
import com.mhmdreza.azmoonyar.data.Quiz
import com.mhmdreza.azmoonyar.data.QuizResult
import com.mhmdreza.azmoonyar.data.quizes.FATHER
import com.mhmdreza.azmoonyar.data.quizes.TRADEOFF
import kotlinx.android.synthetic.main.agreement_level_4.*
import kotlinx.android.synthetic.main.agreement_level_5.*
import kotlinx.android.synthetic.main.fragment_quiz.*
import kotlinx.android.synthetic.main.frequency_level.*
import kotlinx.android.synthetic.main.parental_question.*
import kotlinx.android.synthetic.main.trade_off_level.*


const val QUIZ_RESULT = "QUIZ_RESULT"

class QuizFragment : Fragment() {

    private val navController by lazy { Navigation.findNavController(view!!) }

    private lateinit var quiz: Quiz
    private lateinit var questionTitle: TextView
    private var questionNum = 0
    private lateinit var quizResult: QuizResult

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.mhmdreza.azmoonyar.R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exitButton.setOnClickListener {
            navController.popBackStack(
                com.mhmdreza.azmoonyar.R.id.quizListFragment,
                false
            )
        }
        if (arguments == null) return
        quiz = arguments!!.getSerializable(QUIZ_KEY) as Quiz
        when (quiz.type) {
            AnswerType.TRADE_OFF -> {
                tradeOff.visibility = VISIBLE
            }
            AnswerType.AGREEMENT_LEVEL_4 -> {
                agreementLevel4.visibility = VISIBLE
                if (quiz.questions[0].extra.isNotEmpty()) {
                    whichParent.visibility = VISIBLE
                }
            }
            AnswerType.AGREEMENT_LEVEL_5 -> {
                agreementLevel5.visibility = VISIBLE
            }
            AnswerType.PARENT_CHOICE -> {
                parentalQuestion.visibility = VISIBLE
            }
            AnswerType.FREQUENCY_LEVEL -> {
                frequencyLevel.visibility = VISIBLE
            }
        }
        quizResult = QuizResult(System.currentTimeMillis(), quiz.id)
        progressBar.max = quiz.questions.size.toFloat()
        setOnClickListeners()
        showQuestion()
    }

    private fun setOnClickListeners() {
        when (quiz.type) {
            AnswerType.TRADE_OFF -> {
                oneTradeOff.setOnClickListener { onAnswerClicked(1) }
                twoTradeOff.setOnClickListener { onAnswerClicked(2) }
                threeTradeOff.setOnClickListener { onAnswerClicked(3) }
                fourTradeOff.setOnClickListener { onAnswerClicked(4) }
                fiveTradeOff.setOnClickListener { onAnswerClicked(5) }
                sixTradeOff.setOnClickListener { onAnswerClicked(6) }
                sevenTradeOff.setOnClickListener { onAnswerClicked(7) }
                questionTitle = tradeOffQuestionTitle
            }
            AnswerType.PARENT_CHOICE -> {
                one.setOnClickListener { onAnswerClicked(1) }
                two.setOnClickListener { onAnswerClicked(2) }
                three.setOnClickListener { onAnswerClicked(3) }
                four.setOnClickListener { onAnswerClicked(4) }
                five.setOnClickListener { onAnswerClicked(5) }
                six.setOnClickListener { onAnswerClicked(6) }
                questionTitle = parentalQuestionTitle
            }
            AnswerType.FREQUENCY_LEVEL -> {
                oneFreq.setOnClickListener { onAnswerClicked(1) }
                twoFreq.setOnClickListener { onAnswerClicked(2) }
                threeFreq.setOnClickListener { onAnswerClicked(3) }
                fourFreq.setOnClickListener { onAnswerClicked(4) }
                fiveFreq.setOnClickListener { onAnswerClicked(5) }
                questionTitle = freqQuestionTitle
            }
            AnswerType.AGREEMENT_LEVEL_5 -> {
                AL5one.setOnClickListener { onAnswerClicked(1) }
                AL5two.setOnClickListener { onAnswerClicked(2) }
                AL5three.setOnClickListener { onAnswerClicked(3) }
                AL5four.setOnClickListener { onAnswerClicked(4) }
                AL5five.setOnClickListener { onAnswerClicked(5) }
                questionTitle = al5QuestionTitle
            }
            AnswerType.AGREEMENT_LEVEL_4 -> {
                AL4one.setOnClickListener { onAnswerClicked(1) }
                AL4two.setOnClickListener { onAnswerClicked(2) }
                AL4three.setOnClickListener { onAnswerClicked(3) }
                AL4four.setOnClickListener { onAnswerClicked(4) }
                questionTitle = al4QuestionTitle
            }
        }
    }

    private fun onAnswerClicked(answer: Int) {
        val extra = quiz.questions[questionNum].extra
        when (quiz.type) {
            AnswerType.AGREEMENT_LEVEL_4 -> {
                if (extra.isNotEmpty())
                    quizResult.answerList.add(Answer(answer, extra = extra[0]))
                else quizResult.answerList.add(Answer(answer))
            }
            else -> {
                quizResult.answerList.add(Answer(answer))
            }
        }
        questionNum++
        if (questionNum < quiz.questions.size)
            showQuestion()
        else goToResultFragment()
    }

    private fun goToResultFragment() {
        val bundle = Bundle()
        bundle.putSerializable(QUIZ_RESULT, quizResult)
        navController.navigate(com.mhmdreza.azmoonyar.R.id.action_quizFragment_to_quizResultFragment, bundle)
    }

    private fun showQuestion() {
        if (questionNum >= quiz.questions.size) return
        val question = quiz.questions[questionNum]
        questionTitle.text = question.questionTitle
        questionNumber.text = "${questionNum + 1}/${quiz.questions.size}"
        progressBar.progress = (questionNum + 1).toFloat()
        val extra = question.extra
        if (extra.isNotEmpty()) {
            if (extra[0] == TRADEOFF) {
                lowScoreText.text = extra[1]
                highScoreText.text = extra[2]
            } else {
                whichParent.text =
                    resources.getText(if (extra[0] == FATHER) com.mhmdreza.azmoonyar.R.string.fatherQuestion else com.mhmdreza.azmoonyar.R.string.motherQuestion)
            }
        }
    }
}
