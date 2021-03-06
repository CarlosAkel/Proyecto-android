package com.example.pp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.findFragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment


class f2_2 : Fragment() {
    private val viewModel: GeneralViewModel by activityViewModels()
    lateinit var preferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_f2_2, container, false)

        var clicked1 = false

        val but1 = view.findViewById<TextView>(R.id.textView16)//Cards
        val but2 = view.findViewById<TextView>(R.id.textView17)//World
        val but3 = view.findViewById<TextView>(R.id.textView18)//Gear
        val but4 = view.findViewById<TextView>(R.id.logout)//logout
        preferences=context?.getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)!!


        val navHostFragment = childFragmentManager.findFragmentById(R.id.fragment3) as NavHostFragment

        but1.setOnClickListener{
            //Deck
            var dest = navHostFragment.navController.currentDestination?.label.toString()
            when {
                !clicked1 -> {
                    navHostFragment.navController.navigate(R.id.action_f2_to_deck_cards)
                    clicked1 = true
                }
                dest == "fragment_world" -> {
                    navHostFragment.navController.navigate(R.id.action_world_to_deck_cards)
                }
                dest == "fragment_gear" -> {
                    navHostFragment.navController.navigate(R.id.action_gear_to_deck_cards)
                }
                dest == "fragment_show__card"->{
                    navHostFragment.navController.navigate(R.id.action_show_Card_to_deck_cards)
                }
                dest == "fragment_create_rooms"->{
                    navHostFragment.navController.navigate(R.id.action_fragment_create_rooms_to_deck_cards)
                }
            }
            but1.setBackgroundResource(R.drawable.ic_white_cards)
            but2.setBackgroundResource(R.drawable.ic_world)
            but3.setBackgroundResource(R.drawable.ic_gear)


        }

        but2.setOnClickListener {
            var dest = navHostFragment.navController.currentDestination?.label.toString()
            when {
                !clicked1 -> {
                    navHostFragment.navController.navigate(R.id.action_f2_to_world)
                    clicked1 = true
                }
                dest == "fragment_gear" -> {
                    navHostFragment.navController.navigate(R.id.action_gear_to_world)
                }
                dest == "fragment_deck_cards" -> {
                    navHostFragment.navController.navigate(R.id.action_deck_cards_to_world)
                }
                dest == "fragment_show__card"->{
                    navHostFragment.navController.navigate(R.id.action_show_Card_to_world)
                }
                dest == "fragment_create_rooms"->{
                    navHostFragment.navController.navigate(R.id.action_fragment_create_rooms_to_world)
                }


            }

            but1.setBackgroundResource(R.drawable.ic_action_name)
            but2.setBackgroundResource(R.drawable.ic_white_world)
            but3.setBackgroundResource(R.drawable.ic_gear)




        }
        but3.setOnClickListener{
            var dest = navHostFragment.navController.currentDestination?.label.toString()


            when {
                !clicked1 -> {
                    navHostFragment.navController.navigate(R.id.action_f2_to_gear)
                    clicked1 = true

                }
                dest == "fragment_deck_cards" -> {
                    navHostFragment.navController.navigate(R.id.action_deck_cards_to_gear)
                }
                dest == "fragment_world" -> {
                    navHostFragment.navController.navigate(R.id.action_world_to_gear)
                }
                dest == "fragment_show__card"->{
                    navHostFragment.navController.navigate(R.id.action_show_Card_to_gear)
                }
                dest == "fragment_create_rooms"->{
                    navHostFragment.navController.navigate(R.id.action_fragment_create_rooms_to_gear)
                }
            }

            but1.setBackgroundResource(R.drawable.ic_action_name)
            but2.setBackgroundResource(R.drawable.ic_world)
            but3.setBackgroundResource(R.drawable.ic_white_gear)

        }

        but4.setOnClickListener{
            val editor: SharedPreferences.Editor=preferences.edit()
            editor.clear()
            editor.apply()
            Navigation.findNavController(view).navigate(R.id.action_f2_23_to_f1)
        }





        return view
    }


}