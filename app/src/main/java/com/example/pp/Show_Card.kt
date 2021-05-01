package com.example.pp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs

class Show_Card : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val args: Show_CardArgs by navArgs()
        // Inflate the layout for this fragment


        val mynumber = args.number



        val view = inflater.inflate(R.layout.fragment_show__card, container, false)

        val text = view.findViewById<TextView>(R.id.textView6)

        text.text = mynumber

        return view
    }


}