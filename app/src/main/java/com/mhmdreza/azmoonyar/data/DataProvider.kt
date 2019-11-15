package com.mhmdreza.azmoonyar.data




class DataProvider {
     val quizList = arrayListOf(
        Quiz(0, "title 0", "descrip 0", ArrayList()),
        Quiz(1, "title 1", "descrip 1", ArrayList()),
        Quiz(2, "title 2", "descrip 2", ArrayList()),
        Quiz(3, "title 3", "descrip 3", ArrayList()),
        Quiz(4, "title 4", "descrip 4", ArrayList()),
        Quiz(5, "title 5", "descrip 5", ArrayList()),
        Quiz(6, "title 6", "descrip 6", ArrayList()),
        Quiz(7, "title 7", "descrip 7", ArrayList()),
        Quiz(8, "title 8", "descrip 8", ArrayList()),
        Quiz(9, "title 9", "descrip 9", ArrayList())
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