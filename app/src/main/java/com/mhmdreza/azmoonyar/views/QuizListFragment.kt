package com.mhmdreza.azmoonyar.views


import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.mhmdreza.azmoonyar.R
import com.mhmdreza.azmoonyar.data.DataProvider
import com.mhmdreza.azmoonyar.data.Quiz
import kotlinx.android.synthetic.main.fragment_quiz_list.*
import kotlinx.android.synthetic.main.parent_choice_bottom_sheet.view.*
import kotlinx.android.synthetic.main.quiz_list_item.view.*


const val QUIZ_KEY = "QUIZ_KEY"
const val IS_MOTHER_SELECTED = "IS_MOTHER_SELECTED"
const val IS_FATHER_SELECTED = "IS_FATHER_SELECTED"
const val YOUNG_ID = 5

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

        private var isMotherSelected = true
        private var isFatherSelected = true

        fun bind(quiz: Quiz) {
            itemView.quizTitle.text = quiz.title
            itemView.setOnClickListener {
                val bundle = Bundle()
                bundle.putSerializable(QUIZ_KEY, quiz)
                if (quiz.id == YOUNG_ID) {
                    openBottomSheet(it.context, quiz)
                } else {
                    navController.navigate(R.id.action_quizListFragment_to_startQuizFragment, bundle)
                }
            }
        }

        private fun openBottomSheet(context: Context, quiz: Quiz) {
            val dialogView: View = LayoutInflater.from(context)
                .inflate(R.layout.parent_choice_bottom_sheet, null)
            val mother = dialogView.mother
            val motherImage = dialogView.motherImage
            val father = dialogView.father
            val fatherImage = dialogView.fatherImage
            mother.setOnClickListener {
                mother.setBackgroundResource(
                    if (isMotherSelected) {
                        R.drawable.parent_choice_bg_unselected
                    } else {
                        R.drawable.parent_choice_bg
                    }
                )
                motherImage.setImageResource(
                    if (isMotherSelected) {
                        R.drawable.ic_mother_grey_64
                    } else {
                        R.drawable.ic_mother_purple_64
                    }
                )
                isMotherSelected = isMotherSelected.not()
            }
            father.setOnClickListener {
                father.setBackgroundResource(
                    if (isFatherSelected) {
                        R.drawable.parent_choice_bg_unselected
                    } else {
                        R.drawable.parent_choice_bg
                    }
                )
                fatherImage.setImageResource(
                    if (isFatherSelected) {
                        R.drawable.ic_father_grey_64
                    } else {
                        R.drawable.ic_father_purple_64
                    }
                )
                isFatherSelected = isFatherSelected.not()
            }
            val dialog = BottomSheetDialog(context)
            dialogView.parentSubmit.setOnClickListener {
                val bundle = Bundle().apply {
                    putBoolean(IS_MOTHER_SELECTED, isMotherSelected)
                    putBoolean(IS_FATHER_SELECTED, isFatherSelected)
                    putSerializable(QUIZ_KEY, quiz)
                }
                dialog.dismiss()
                navController.navigate(R.id.action_quizListFragment_to_startQuizFragment, bundle)
            }
            dialog.setContentView(dialogView)
            dialog.show()
        }

    }

}
