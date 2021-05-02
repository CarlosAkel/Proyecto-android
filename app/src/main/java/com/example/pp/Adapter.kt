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
        //val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        holder.textView1.text = currentItem.num
        //holder.itemView.layout(1,1,1,1)
        contador +=1
        //Log.d("dadasdasasds",holder.itemView.measuredWidthAndState.toString())

        if(mylist.size == 13 && (contador == 13)){//Standard
            holder.itemView.translationX = (ancho/3).toFloat()

        }
        else if (mylist.size == 8 && (contador == 8 || contador == 7)){//T-shirt
            holder.itemView.translationX = (ancho/6).toFloat()

        }
        else if(mylist.size == 14 && (contador == 14 || contador == 13)){//hours
            holder.itemView.translationX = (ancho/6).toFloat()

        }



        //holder.itemView.

        //Log.d("das",holder.layoutPosition.toString())

        holder.itemView.setOnClickListener {
            //show.onClickItem(currentItem)
            val action = Deck_cardsDirections.actionDeckCardsToShowCard()
            action.number = currentItem.num
            Navigation.findNavController(show).navigate(action)
            //show.navigate(R.id.action_deck_cards_to_show_Card)
        }
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