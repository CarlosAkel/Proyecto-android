package com.example.pp

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.pp.base.BaseViewModel
import com.example.pp.base.Sala

class Adapter_rooms(val viewMod: BaseViewModel): RecyclerView.Adapter<Adapter_rooms.ExampleViewHolder>() {

    private var myList = emptyList<Sala>()
    //var myList: MutableList<Roomitem>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.room_layout,parent,false)
        return ExampleViewHolder(itemView)
    }

    override fun getItemCount()=myList.size



    override fun onBindViewHolder(holder:ExampleViewHolder, position: Int) {
    val currentItem=myList[position]
        holder.TexTview1.text=currentItem.name
        holder.TexTview1.paintFlags=holder.TexTview1.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        //val item=object:SwipeToDelete(world(), 0, ItemTouchHelper.LEFT){
          //  override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            //    delete(currentItem)
            //}
        //}
        //val itemTouchHelper=ItemTouchHelper(item)
        //itemTouchHelper.attachToRecyclerView()

    }
    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val TexTview1: TextView=itemView.findViewById(R.id.textView_name)

    }

    fun setData(contact: List<Sala>){
        this.myList = contact
        notifyDataSetChanged()
    }
    fun delete(position: Int){
        val currentItem=myList[position]
        viewMod.delete(currentItem)
       // myList.removeAt(position)
        notifyDataSetChanged()
    }
}