package com.example.volleymock.presenter

import com.example.volleymock.model.mealdata.mealResponse

interface MVPmeal {
    interface Presenter{
        fun fetchData()
    }
    interface MealView{
        fun setResult(meal: mealResponse)
        fun setError(message: String)
    }
}