package com.example.pp

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter_rooms(var myList: MutableList<Roomitem>): RecyclerView.Adapter<Adapter_rooms.ExampleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.room_layout,parent,false)
        return ExampleViewHolder(itemView)
    }

    override fun getItemCount()=myList.size

    override fun onBindViewHolder(holder:ExampleViewHolder, position: Int) {
    val currentItem=myList[position]
        holder.TexTview1.text=currentItem.name
        holder.TexTview1.paintFlags=holder.TexTview1.paintFlags or Paint.UNDERLINE_TEXT_FLAG

    }
    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val TexTview1: TextView=itemView.findViewById(R.id.textView_name)

    }
    fun delete(position:Int){
        myList.removeAt(position)
        notifyDataSetChanged()
    }
}