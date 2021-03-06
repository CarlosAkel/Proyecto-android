package com.example.pp

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.fragment.app.activityViewModels
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.widget.*


class gear : Fragment() {
    private val viewModel: GeneralViewModel by activityViewModels()
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_gear, container, false)

        sharedPreferences=context?.getSharedPreferences("SHARED_PREF2", Context.MODE_PRIVATE)!!//new

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val spinner = view.findViewById<Spinner>(R.id.spinner)



        spinner.adapter = context?.let {
            ArrayAdapter(
                it,
                R.layout.color_spiner,
                resources.getStringArray(R.array.decks)
            )
        } as SpinnerAdapter



        val email =viewModel.email
        if (email == "") {
            spinner.setSelection(0)
        }
        else if (email != null){
            spinner.setSelection(viewModel.spinPos)
        }








        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                viewModel.changeSpin(spinner.selectedItem.toString())
                viewModel.spinPos = spinner.selectedItemId.toInt()
                val editor: SharedPreferences.Editor=sharedPreferences.edit()//new
                editor.putInt(viewModel.email,viewModel.spinPos)//new
                editor.apply()

                }

            }

        }




    }
