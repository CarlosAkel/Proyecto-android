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
import android.util.Log
import android.widget.*


class gear : Fragment() {
    private val viewModel: GeneralViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_gear, container, false)

        val spinner = view.findViewById<Spinner>(R.id.spinner)





        //Log.d("pos",viewModel.spinPos.toString())


        //val languages = resources.getStringArray(R.array.decks)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val spinner = view.findViewById<Spinner>(R.id.spinner)



        //spinner.setSelection(viewModel.spinPos)
        //Log.d("pos",viewModel.spinPos.toString())


        spinner.adapter = context?.let {
            ArrayAdapter(
                it,
                R.layout.color_spiner,
                resources.getStringArray(R.array.decks)
            )
        } as SpinnerAdapter
        //Log.d("pos",viewModel.spinPos.toString())
        spinner.setSelection(viewModel.spinPos)



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



                //spinner.setSelection(viewModel.spinPos)
                //spinner.setSelection(2)

                //Log.d("pos",spinner.selectedItemId.toString())
                viewModel.spinPos = spinner.selectedItemId.toInt()

                }

            }

        }




    }
