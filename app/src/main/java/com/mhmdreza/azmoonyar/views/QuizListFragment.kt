package com.mhmdreza.azmoonyar.views


import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.mhmdreza.azmoonyar.R
import com.mhmdreza.azmoonyar.data.DataProvider
import com.mhmdreza.azmoonyar.data.Quiz
import kotlinx.android.synthetic.main.fragment_quiz_list.*
import kotlinx.android.synthetic.main.quiz_list_item.view.*

const val QUIZ_KEY = "QUIZ_KEY"

class QuizListFragment : Fragment() {

    private val navController by lazy { Navigation.findNavController(view!!) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val quizListAdapter = QuizListAdapter()

        backIcon.setOnClickListener { navController.popBackStack(R.id.mainFragment, false) }
        recyclerView.adapter = quizListAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        quizListAdapter.replaceModelList(DataProvider.getInstance().quizList)

        searchView.findViewById<View>(androidx.appcompat.R.id.search_plate).setBackgroundColor(Color.TRANSPARENT)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {
                val result = ArrayList<Quiz>()
                for (quiz: Quiz in DataProvider.getInstance().quizList) {
                    if (quiz.title.indexOf(query ?: "") >= 0){
                        result.add(quiz)
                    }
                }
                quizListAdapter.replaceModelList(result)
                return true
            }
        })
    }

    class QuizListAdapter : RecyclerView.Adapter<QuizViewHolder>() {
        var data: List<Quiz> = ArrayList()
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
            return QuizViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.quiz_list_item,
                    parent,
                    false
                )
            )
        }

        override fun getItemCount(): Int {
            return data.size
        }

        override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
            holder.bind(data[position])
        }

        fun replaceModelList(newData: ArrayList<Quiz>) {
            data = newData
            notifyDataSetChanged()
        }

    }

    class QuizViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val navController by lazy { Navigation.findNavController(itemView) }

        fun bind(quiz: Quiz) {
            itemView.quizTitle.text = quiz.title
            itemView.setOnClickListener {
                val bundle = Bundle()
                bundle.putSerializable(QUIZ_KEY, quiz)
                navController.navigate(R.id.action_quizListFragment_to_startQuizFragment, bundle)
            }
        }

    }

}
