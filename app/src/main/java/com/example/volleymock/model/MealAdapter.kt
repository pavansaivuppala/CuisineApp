package com.example.volleymock.model

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.volleymock.databinding.ActivityMainBinding
import com.example.volleymock.databinding.CustomMealBinding
import com.example.volleymock.view.MainActivity
import com.squareup.picasso.Picasso

class MealAdapter(context: Context,private val list:ArrayList<MealDetails>): RecyclerView.Adapter<MealAdapter.MealViewHolder>(){
    inner class MealViewHolder(private val binding: CustomMealBinding):RecyclerView.ViewHolder(binding.root)
    {
        fun bind(list: MealDetails){
            binding.name.text=list.name
            Picasso.get().load(list.url).into(binding.url)
            binding.id.text=list.id
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val binding=CustomMealBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MealViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val current=list[position]
        holder.bind(current)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}