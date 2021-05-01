package com.example.pp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText

class fragment_create_rooms : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_create_rooms, container, false)
        val navCo= this.findNavController()
        val btn = view.findViewById<Button>(R.id.button2)

        btn.setOnClickListener {
            val nombre=view.findViewById<TextInputEditText>(R.id.textinputnombre).text.toString()
            val password=view.findViewById<TextInputEditText>(R.id.textinputpassword).text.toString()
            val bu= Bundle()
            bu.putString("nombre",nombre)
            bu.putString("password",password)
            setFragmentResult("key", bu)
            navCo.navigate(R.id.action_fragment_create_rooms_to_world)
        }
        return view
    }



}