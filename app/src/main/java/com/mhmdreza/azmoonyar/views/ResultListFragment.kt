package com.mhmdreza.azmoonyar.views


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mhmdreza.azmoonyar.R
import com.mhmdreza.azmoonyar.data.DataProvider
import com.mhmdreza.azmoonyar.data.QuizResult
import com.mhmdreza.azmoonyar.data.SharedPref
import com.mhmdreza.azmoonyar.util.normalizeTime
import kotlinx.android.synthetic.main.fragment_result_list.*
import kotlinx.android.synthetic.main.quiz_history_item.view.*

const val QUIZ_RESULT_KEY = "QUIZ_RESULT_KEY"

class ResultListFragment : Fragment() {

    private val navController by lazy { Navigation.findNavController(view!!) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(
            R.layout.fragment_result_list,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showPrefData(view)

        backIcon.setOnClickListener {
            navController.popBackStack(R.id.mainFragment, false)
        }
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = QuizResultAdapter(view.context)
    }

    private fun showPrefData(view: View) {
        val quizResults = SharedPref.getInstance(view.context).getQuizResults()
        if (quizResults.isEmpty()) return
    }

    inner class QuizResultAdapter(private val context: Context) :
        RecyclerView.Adapter<QuizResultViewHolder>() {
        private val quizResults = SharedPref.getInstance(context).getQuizResults()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizResultViewHolder {
            return QuizResultViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.quiz_history_item,
                    parent, false
                )
            )
        }

        override fun getItemCount() = quizResults.size

        override fun onBindViewHolder(holder: QuizResultViewHolder, position: Int) {
            holder.bindViewModel(quizResults[position])
        }

    }

    inner class QuizResultViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bindViewModel(quizResult: QuizResult) {
            view.date.text = normalizeTime(quizResult.time)
            view.title.text = DataProvider.getInstance().quizList[quizResult.quizId].title
            view.setOnClickListener {
                val bundle = Bundle()
                bundle.putSerializable(QUIZ_RESULT_KEY, quizResult)
                navController.navigate(R.id.action_resultListFragment_to_resultFragment, bundle)
            }
        }



    }
}
