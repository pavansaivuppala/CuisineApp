package com.example.volleymock.model.mealdata

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.volleymock.model.Constant.url
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class VolleyHandler(private val context: Context?, private val ext:String) {
    private var requestQueue: RequestQueue = Volley.newRequestQueue(context)
    val uri = url+ext

    fun apicall(callback:CallBack){

        val request=StringRequest(
            Request.Method.GET,
            uri,{
                val typeToken=object : TypeToken<mealResponse>(){}
                val response= Gson().fromJson(it,typeToken)
                callback.onSuccess(response)
            },{
                callback.onFailure(it.toString())

            }
        )
   requestQueue.add(request)
    }
}