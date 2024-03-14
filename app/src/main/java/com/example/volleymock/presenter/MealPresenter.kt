package com.example.volleymock.presenter

import com.android.volley.toolbox.Volley
import com.example.volleymock.model.mealdata.CallBack
import com.example.volleymock.model.mealdata.VolleyHandler
import com.example.volleymock.model.mealdata.mealResponse
import java.util.PrimitiveIterator

class MealPresenter(
    private val volleyHandler: VolleyHandler,
    private val mealView: MVPmeal.MealView
): MVPmeal.Presenter  {
    override fun fetchData() {
        volleyHandler.apicall(object : CallBack{
            override fun onSuccess(meal: mealResponse) {
                mealView.setResult(meal)
            }

            override fun onFailure(message: String) {
                mealView.setError(message)
            }
        })
    }

}