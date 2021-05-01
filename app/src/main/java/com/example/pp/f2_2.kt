package com.example.pp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.findFragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment


class f2_2 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_f2_2, container, false)

        var clicked1 = false

        val but1 = view.findViewById<TextView>(R.id.textView16)
        val but2 = view.findViewById<TextView>(R.id.textView17)
        val but3 = view.findViewById<TextView>(R.id.textView18)

        val navHostFragment = childFragmentManager.findFragmentById(R.id.fragment3) as NavHostFragment
        Log.d("tag4",navHostFragment.navController.currentDestination?.id.toString())

        but1.setOnClickListener{
            //Deck
            Log.d("tag",navHostFragment.navController.currentDestination?.id.toString())
            if (clicked1 == false){
                navHostFragment.navController.navigate(R.id.action_f2_to_deck_cards)
                clicked1 = true
            }
            else {
                    try{

                        navHostFragment.navController.navigate(R.id.action_gear_to_deck_cards)

                    }
                    catch (e: Exception){
                        navHostFragment.navController.navigate(R.id.action_world_to_deck_cards)

                    }

            }
            but1.setBackgroundResource(R.drawable.ic_white_cards)
            but2.setBackgroundResource(R.drawable.ic_world)
            but3.setBackgroundResource(R.drawable.ic_gear)


        }

        but2.setOnClickListener {
            Log.d("tag2",navHostFragment.navController.currentDestination?.id.toString())
            if (clicked1 == false){
                navHostFragment.navController.navigate(R.id.action_f2_to_world)
                clicked1 = true
            }
            else{


                try{

                    navHostFragment.navController.navigate(R.id.action_gear_to_world)

                }
                catch (e: Exception){
                    navHostFragment.navController.navigate(R.id.action_deck_cards_to_world)

                }
            }

            but1.setBackgroundResource(R.drawable.ic_action_name)
            but2.setBackgroundResource(R.drawable.ic_white_world)
            but3.setBackgroundResource(R.drawable.ic_gear)




            //Navigation.findNavController(view).navigate(R.id.action_f2_to_world)

        }
        but3.setOnClickListener{
            Log.d("tag3",navHostFragment.navController.currentDestination?.id.toString())
            if(clicked1 == false){
                navHostFragment.navController.navigate(R.id.action_f2_to_gear)
                clicked1 = true

            }
            else{


                try{

                    navHostFragment.navController.navigate(R.id.action_deck_cards_to_gear)

                }
                catch (e: Exception){
                    navHostFragment.navController.navigate(R.id.action_world_to_gear)

                }
            }

            but1.setBackgroundResource(R.drawable.ic_action_name)
            but2.setBackgroundResource(R.drawable.ic_world)
            but3.setBackgroundResource(R.drawable.ic_white_gear)

        }
        return view
    }


}