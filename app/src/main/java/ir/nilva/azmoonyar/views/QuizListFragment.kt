package ir.nilva.azmoonyar.views


import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import android.widget.LinearLayout
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.materialdialogs.MaterialDialog
import com.google.android.material.bottomsheet.BottomSheetDialog
import ir.nilva.azmoonyar.MainActivity
import ir.nilva.azmoonyar.R
import ir.nilva.azmoonyar.data.DataProvider
import ir.nilva.azmoonyar.data.Quiz
import ir.nilva.azmoonyar.data.SharedPref
import ir.nilva.azmoonyar.util.normalizeNumber
import kotlinx.android.synthetic.main.fragment_quiz_list.*
import kotlinx.android.synthetic.main.parent_choice_bottom_sheet.view.*
import kotlinx.android.synthetic.main.quiz_list_item.view.*

const val QUIZ_KEY = "QUIZ_KEY"
const val IS_MOTHER_SELECTED = "IS_MOTHER_SELECTED"
const val IS_FATHER_SELECTED = "IS_FATHER_SELECTED"
const val YOUNG_ID = 5
const val CHILD_ALABAMA_ID = 4


class QuizListFragment : Fragment() {

    private val navController by lazy { Navigation.findNavController(view!!) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz_list, container, false)
    }

    lateinit var quizListAdapter: QuizListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        quizListAdapter = QuizListAdapter()

        backIcon.setOnClickListener { navController.popBackStack(R.id.mainFragment, false) }
        recyclerView.adapter = quizListAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        quizListAdapter.replaceModelList(DataProvider.getInstance().quizList)

        ((((searchView.getChildAt(0) as LinearLayout).getChildAt(2) as LinearLayout).getChildAt(1) as LinearLayout).getChildAt(
            0
        ) as AutoCompleteTextView).textSize =
            14f


        searchView.findViewById<View>(androidx.appcompat.R.id.search_plate)
            .setBackgroundColor(Color.TRANSPARENT)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {
                val result = ArrayList<Quiz>()
                for (quiz: Quiz in DataProvider.getInstance().quizList) {
                    if (quiz.title.indexOf(query ?: "") >= 0) {
                        result.add(quiz)
                    }
                }
                quizListAdapter.replaceModelList(result)
                return true
            }
        })

    }

    inner class QuizListAdapter : RecyclerView.Adapter<QuizViewHolder>() {
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

    fun refresh() {
        quizListAdapter.notifyDataSetChanged()
    }

    inner class QuizViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var isMotherSelected = true
        private var isFatherSelected = true

        fun bind(quiz: Quiz) {
            itemView.quizTitle.text = quiz.title
            if (quiz.price > 0) {
                if (SharedPref.getInstance().hasPaid(quiz.id)) {
                    itemView.priceLayout.visibility = GONE
                    itemView.freePrice.visibility = VISIBLE
                    itemView.freePrice.text = ""
                } else {
                    itemView.priceLayout.visibility = VISIBLE
                    itemView.freePrice.visibility = GONE
                    itemView.price.text = "${quiz.price}".normalizeNumber()
                }
            } else {
                itemView.priceLayout.visibility = GONE
                itemView.freePrice.visibility = VISIBLE
            }
            itemView.setOnClickListener { it ->
//                if (quiz.price > 0 && SharedPref.getInstance().hasPaid(quiz.id).not()) {
//                    startPayment(quiz)
//                } else {
                    when (quiz.id) {
                        YOUNG_ID -> {
                            MaterialDialog(it.context).show {
                                cornerRadius(12f)
                                message(text = "این آزمون باید توسط فرزند پاسخ داده شود")
                                positiveButton(text = "متوجه شدم") {
                                    openBottomSheet(it.context, quiz)
                                }
                            }
                        }
                        CHILD_ALABAMA_ID -> {
                            MaterialDialog(it.context).show {
                                cornerRadius(12f)
                                message(text = "این آزمون باید توسط فرزند پاسخ داده شود")
                                positiveButton(text = "متوجه شدم") {
                                    startQuiz(quiz)
                                }
                            }
                        }
                        else -> {
                            startQuiz(quiz)
                        }
//                    }
                }
            }
        }


        private fun openBottomSheet(
            context: Context,
            quiz: Quiz
        ) {
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
                if (!isFatherSelected && !isMotherSelected) {
                    Toast.makeText(
                        it.context,
                        "باید حداقل یک گزینه را انتخاب کنید.",
                        Toast.LENGTH_LONG
                    ).show()
                    return@setOnClickListener
                }
                val bundle = Bundle().apply {
                    putBoolean(IS_MOTHER_SELECTED, isMotherSelected)
                    putBoolean(IS_FATHER_SELECTED, isFatherSelected)
                    putSerializable(QUIZ_KEY, quiz)
                }
                dialog.dismiss()
                startQuiz(bundle)

            }
            dialog.setContentView(dialogView)
            dialog.show()
        }

    }

    private fun startPayment(quiz: Quiz) {
        (activity as MainActivity).openPayment(quiz) {
            refresh()
        }
    }

    private fun startQuiz(quiz: Quiz) {
        val bundle = Bundle()
        bundle.putSerializable(QUIZ_KEY, quiz)
        navController.navigate(
            R.id.action_quizListFragment_to_startQuizFragment,
            bundle
        )
    }

    private fun startQuiz(bundle: Bundle) {
        navController.navigate(
            R.id.action_quizListFragment_to_startQuizFragment,
            bundle
        )
    }

}


