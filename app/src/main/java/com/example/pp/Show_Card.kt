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


        val mynumber = args.number



        val view = inflater.inflate(R.layout.fragment_show__card, container, false)

        val text = view.findViewById<TextView>(R.id.textView6)

        when (mynumber) {
            "Cafe" -> {
                text.setBackgroundResource(R.drawable.coffe)
                text.text = ""
            }
            "INF" -> {
                text.setBackgroundResource(R.drawable.inf3)
                text.text = ""
            }
            else -> {
                text.text = mynumber
            }
        }




        return view
    }


}