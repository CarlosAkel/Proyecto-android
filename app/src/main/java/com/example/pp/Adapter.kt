package com.example.pp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(var mylist: MutableList<GeneralItem>) : RecyclerView.Adapter<Adapter.ExampleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.cards,parent,false)
        return ExampleViewHolder(itemView)
    }

    override fun getItemCount() =mylist.size

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {

        val currentItem= mylist[position]
        holder.textView1.text = currentItem.num
        //holder.textView2.text = currentItem.number
    }

    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView1: TextView = itemView.findViewById(R.id.textView3)
        //val textView2: TextView = itemView.findViewById(R.id.textView2)
    }

    fun p(lista: MutableList<GeneralItem>){
        this.mylist = lista
        this.notifyDataSetChanged()
    }

}