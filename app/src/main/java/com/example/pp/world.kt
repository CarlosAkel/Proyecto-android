package com.example.pp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class world : Fragment() {

    private val viewModel: GeneralViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_world, container, false)


        val recycler_view_rooms=view.findViewById<RecyclerView>(R.id.rec_rooms)
        val adapter=Adapter_rooms(viewModel.lista)
        val linearLayoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL, true)
        linearLayoutManager.stackFromEnd=true
        recycler_view_rooms.adapter=adapter
        recycler_view_rooms.layoutManager=linearLayoutManager

       val btn_create= view.findViewById<Button>(R.id.button8)

        val navCo=this.findNavController()

        btn_create.setOnClickListener {
            navCo.navigate(R.id.action_world_to_fragment_create_rooms)

        }



        return view
    }


}