package com.mhmdreza.azmoonyar.data

import com.mhmdreza.azmoonyar.data.quizes.*


class DataProvider {
     val quizList = arrayListOf(
         getQuiz1(),
         getQuiz2(),
         getQuiz3(),
         getQuiz4(),
         getQuiz5(),
         getQuiz6(),
         getQuiz7(),
         getQuiz8(),
         getQuiz9()
    )

    companion object{
        private var instance: DataProvider? = null

        @Synchronized
        fun getInstance(): DataProvider {
            if (instance == null){
                instance = DataProvider()
            }
            return instance!!
        }
    }
}