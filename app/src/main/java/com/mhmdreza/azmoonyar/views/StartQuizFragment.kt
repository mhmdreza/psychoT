package com.mhmdreza.azmoonyar.views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.mhmdreza.azmoonyar.R
import com.mhmdreza.azmoonyar.data.Quiz
import kotlinx.android.synthetic.main.fragment_start_quiz.*

class StartQuizFragment : Fragment() {

    private val navController by lazy { Navigation.findNavController(view!!) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backButton.setOnClickListener { navController.popBackStack(R.id.quizListFragment, false) }
        if (arguments == null) return
        val quiz = arguments!!.getSerializable(QUIZ_KEY) as Quiz
        toolbarTitle.text = quiz.title
        quizDescription.text = quiz.description
        startQuiz.setOnClickListener {
            navController.navigate(R.id.action_startQuizFragment_to_quizFragment, arguments)
        }
    }


}
