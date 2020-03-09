package com.mhmdreza.azmoonyar.views


import android.animation.ObjectAnimator
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.bold
import androidx.core.text.toSpannable
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.mhmdreza.azmoonyar.R
import com.mhmdreza.azmoonyar.data.Answer
import com.mhmdreza.azmoonyar.data.Quiz
import com.mhmdreza.azmoonyar.data.QuizResult
import com.mhmdreza.azmoonyar.data.quizes.AnswerType
import com.mhmdreza.azmoonyar.data.quizes.FATHER
import com.mhmdreza.azmoonyar.data.quizes.TRADEOFF
import com.mhmdreza.azmoonyar.util.normalizeNumber
import kotlinx.android.synthetic.main.agreement_level_4.*
import kotlinx.android.synthetic.main.agreement_level_5.*
import kotlinx.android.synthetic.main.fragment_quiz.*
import kotlinx.android.synthetic.main.frequency_level.*
import kotlinx.android.synthetic.main.parental_question.*
import kotlinx.android.synthetic.main.trade_off_level.*


const val QUIZ_RESULT = "QUIZ_RESULT"

class QuizFragment : Fragment() {

    private val fatherQuestion = SpannableStringBuilder()
        .append("عبارت زیر تا چه حد درباره رفتار ")
            .bold { append("پدرتان" )}
        .append(" با شما در خلال 16 سال اول زندگی\u200Cتان درست است؟")
        .toSpannable()

    private val motherQuestion = SpannableStringBuilder()
        .append("عبارت زیر تا چه حد درباره رفتار ")
            .bold { append("مادرتان" )}
        .append(" با شما در خلال 16 سال اول زندگی\u200Cتان درست است؟")
        .toSpannable()
    private val navController by lazy { Navigation.findNavController(view!!) }

    private lateinit var quiz: Quiz
    private lateinit var questionTitle: TextView
    private var questionNum = 0
    private lateinit var quizResult: QuizResult
    private var isFatherSelected = false
    private var isMotherSelected = false
    private var parentNum = 0
    private var parentAnswer = 0

    private val loadAnimation by lazy { AnimationUtils.loadAnimation(view!!.context, R.anim.text_anim) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exitButton.setOnClickListener {
            navController.popBackStack(
                R.id.quizListFragment,
                false
            )
        }
        previousQuestion.setOnClickListener {
            if (questionNum <= 0) {
                Toast.makeText(view.context, "شما به ابتدای لیست سوالات رسیدید.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            questionNum--
            parentAnswer = 0
            setParentalGuide(fatherQuestion)
            showQuestion()
        }
        if (arguments == null) return

        isFatherSelected = arguments!!.getBoolean(IS_FATHER_SELECTED)
        isMotherSelected = arguments!!.getBoolean(IS_MOTHER_SELECTED)
        parentNum = if (isFatherSelected != isMotherSelected) 1 else if (isMotherSelected) 2 else 0
        if (parentNum == 1) {
            val spannable = if (isFatherSelected) fatherQuestion else motherQuestion
            setParentalGuide(spannable)
        } else if (parentNum == 2){
            setParentalGuide(fatherQuestion)
        }
        quiz = arguments!!.getSerializable(QUIZ_KEY) as Quiz

        when (quiz.type) {
            AnswerType.TRADE_OFF -> {
                tradeOff.visibility = VISIBLE
            }
            AnswerType.AGREEMENT_LEVEL_4 -> {
                if (quiz.id == 7) {
                    agreement_level_4_for_parker.visibility = VISIBLE
                    if (quiz.questions[0].extra.isNotEmpty()) {
                        whichParent.visibility = VISIBLE
                    }
                } else {
                    agreementLevel4.visibility = VISIBLE
                    if (quiz.questions[0].extra.isNotEmpty()) {
                        whichParent.visibility = VISIBLE
                    }
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
        progressBar.max = (quiz.questions.size * 100).toFloat()
        setOnClickListeners()
        showQuestion()
    }

    private fun setParentalGuide(spannable: Spannable) {
        whichParentQuestion.text = spannable
        whichParentQuestion.startAnimation(loadAnimation)
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
        val isQuestionSolved = questionNum < quizResult.answerList.size
        when (quiz.type) {
            AnswerType.AGREEMENT_LEVEL_4 -> {
                if (extra.isNotEmpty())
                    addNewQuizResult(answer, isQuestionSolved, extra[0])
                else addNewQuizResult(answer, isQuestionSolved)
            }
            AnswerType.PARENT_CHOICE -> {
                when {
                    parentNum == 0 -> return
                    parentNum == 1 -> addNewQuizResult(
                        answer,
                        isQuestionSolved,
                        if (isFatherSelected) "f" else "m"
                    )
                    parentAnswer == 0 -> {
                        parentAnswer = answer * 10
                        setParentalGuide(motherQuestion)
                        return
                    }
                    else -> {
                        parentAnswer += answer
                        setParentalGuide(fatherQuestion)
                        addNewQuizResult(parentAnswer, isQuestionSolved, "fm")
                        parentAnswer = 0
                    }
                }
            }
            else -> {
                addNewQuizResult(answer, isQuestionSolved)
            }
        }
        questionNum++
        if (questionNum < quiz.questions.size)
            showQuestion()
        else goToResultFragment()
    }

    private fun addNewQuizResult(answer: Int, questionSolved: Boolean, extra: String = "") {
        if (questionSolved) {
            quizResult.answerList.add(questionNum, Answer(answer, extra))
            quizResult.answerList.removeAt(questionNum + 1)
        } else {
            quizResult.answerList.add(Answer(answer, extra))
        }
    }

    private fun goToResultFragment() {
        val bundle = Bundle()
        bundle.putSerializable(QUIZ_RESULT, quizResult)
        navController.navigate(R.id.action_quizFragment_to_loadingFragment, bundle)
    }

    private fun showQuestion() {
        if (questionNum >= quiz.questions.size) return
        val question = quiz.questions[questionNum]
        questionTitle.text = question.questionTitle
        questionTitle.startAnimation(loadAnimation)
        questionNumber.text = "${questionNum + 1}/${quiz.questions.size}".normalizeNumber()
        updateProgressBar()
        val extra = question.extra
        if (extra.isNotEmpty()) {
            if (extra[0] == TRADEOFF) {
                lowScoreText.text = extra[1]
                highScoreText.text = extra[2]
                lowScoreText.startAnimation(loadAnimation)
                highScoreText.startAnimation(loadAnimation)
            } else {
                whichParent.text =
                    resources.getText(if (extra[0] == FATHER) R.string.fatherQuestion else R.string.motherQuestion)
            }
        }
    }

    private fun updateProgressBar() {
        val animation = ObjectAnimator.ofFloat(progressBar, "progress", (questionNum * 100).toFloat(), ((questionNum + 1) * 100).toFloat())
        animation.duration = 1000
        animation.interpolator = DecelerateInterpolator()
        animation.start()
        progressBar.clearAnimation()
    }
}
