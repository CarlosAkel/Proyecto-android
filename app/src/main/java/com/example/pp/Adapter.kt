package com.example.pp

import android.content.res.Resources
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

class Adapter(var mylist: MutableList<GeneralItem>,var show :View) : RecyclerView.Adapter<Adapter.ExampleViewHolder>() {

    //lateinit var show: Show
    var ancho = Resources.getSystem().displayMetrics.widthPixels
    var contador = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.cards,parent,false)
        return ExampleViewHolder(itemView)
    }

    override fun getItemCount() =mylist.size

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {

        val currentItem= mylist[position]
        holder.textView1.text = currentItem.num
        contador +=1


        if(mylist.size == 13 && (contador == 13)){//Standard
            holder.itemView.translationX = (ancho/3).toFloat()

        }
        else if (mylist.size == 8 && (contador == 8 || contador == 7)){//T-shirt
            holder.itemView.translationX = (ancho/6).toFloat()

        }
        else if(mylist.size == 14 && (contador == 14 || contador == 13)){//hours
            holder.itemView.translationX = (ancho/6).toFloat()

        }
        if (currentItem.num == "Cafe"){
            holder.textView1.text = ""
            holder.textView2.setBackgroundResource(R.drawable.coffe)
        }
        if  (currentItem.num == "INF"){
            holder.textView1.text = ""
            holder.textView2.setBackgroundResource(R.drawable.inf3)
        }





        holder.itemView.setOnClickListener {
            val action = Deck_cardsDirections.actionDeckCardsToShowCard()
            action.number = currentItem.num
            Navigation.findNavController(show).navigate(action)
        }
    }

    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView1: TextView = itemView.findViewById(R.id.textView3)
        val textView2: TextView = itemView.findViewById(R.id.textView8)
    }





}