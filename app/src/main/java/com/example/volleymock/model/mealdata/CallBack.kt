package com.example.volleymock.model.mealdata

interface CallBack {
    fun onSuccess(meal:mealResponse)
    fun onFailure(message:String)
}