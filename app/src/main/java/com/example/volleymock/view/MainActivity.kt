package com.example.volleymock.view

import android.content.ContentProvider
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.volleymock.model.Constant.url
import com.example.volleymock.databinding.ActivityMainBinding
import com.example.volleymock.model.MealAdapter
import com.example.volleymock.model.MealDetails
import com.example.volleymock.model.mealdata.VolleyHandler
import com.example.volleymock.model.mealdata.mealResponse
import com.example.volleymock.presenter.MVPmeal
import com.example.volleymock.presenter.MealPresenter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity(),MVPmeal.MealView {
    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: MVPmeal.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        initpresenter()
        initViews()
        setContentView(binding.root)

    }

    private fun initViews() {
        binding.fetch.setOnClickListener {
            val ext=binding.userin.getText().toString()
            presenter= MealPresenter(VolleyHandler(this,ext), this)
            presenter.fetchData()
        }
    }

    private fun initpresenter() {


    }

    /*private fun initViews() {
        binding.fetch.setOnClickListener{
            val input = binding.userin.getText().toString()
            var new = url+input
            new=new.toString()
        }
    }*/

    override fun setResult(meal: mealResponse) {

        val list=meal.meals
        val data= ArrayList<MealDetails>()
        for(i in list.indices){
            data.add(MealDetails(list[i].strMeal,list[i].strMealThumb,list[i].idMeal))
        }
        val recyclerView = binding.recycle
        val span = 1
        recyclerView.layoutManager = GridLayoutManager(this, 1,
            LinearLayoutManager.VERTICAL, false
        )
        val adapter=MealAdapter(this,data)
        binding.recycle.adapter=adapter


    }

    override fun setError(message: String) {

    }

}