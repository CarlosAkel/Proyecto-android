package com.example.pp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pp.base.BaseViewModel


class world : Fragment() {

    private val viewModel: GeneralViewModel by activityViewModels()


    private lateinit var salaview: BaseViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_world, container, false)


        salaview = ViewModelProvider(this).get(BaseViewModel::class.java)

        val recycler_view_rooms=view.findViewById<RecyclerView>(R.id.rec_rooms)


        val adapter=Adapter_rooms(salaview)


        val linearLayoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL, true)
        linearLayoutManager.stackFromEnd=true
        recycler_view_rooms.adapter=adapter
        recycler_view_rooms.layoutManager=linearLayoutManager


        salaview.readAllData.observe(viewLifecycleOwner, Observer { contact->
            adapter.setData(contact)
        })

       val btn_create= view.findViewById<Button>(R.id.button8)

        val navCo=this.findNavController()

        btn_create.setOnClickListener {
            navCo.navigate(R.id.action_world_to_fragment_create_rooms)

        }
    //val item=object:SwipeToDelete(this, 0, ItemTouchHelper.LEFT){
        //override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        //    adapter.delete(viewHolder.adapterPosition)
      //  }
    //}
        //val itemTouchHelper=ItemTouchHelper(item)
        //itemTouchHelper.attachToRecyclerView(recycler_view_rooms)


        return view
    }


}