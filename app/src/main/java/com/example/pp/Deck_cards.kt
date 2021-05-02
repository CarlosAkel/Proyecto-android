package com.example.pp

import android.content.res.Resources
import android.os.Bundle
import android.text.Layout
import android.util.DisplayMetrics
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Deck_cards : Fragment(),Show {

    private val viewModel: GeneralViewModel by activityViewModels()

    private val standard = mutableListOf<GeneralItem>(GeneralItem("0"),GeneralItem("1/2"),GeneralItem("2"),
        GeneralItem("3"),GeneralItem("5"),GeneralItem("8"),GeneralItem("13"),GeneralItem("20"),GeneralItem("40"),
        GeneralItem("100"),
        GeneralItem("INF"),GeneralItem("?"),GeneralItem("Cafe")
    )
    private val T_shirt = mutableListOf<GeneralItem>(GeneralItem("XS"),GeneralItem("S"),GeneralItem("M"),GeneralItem("L"),GeneralItem("XL"),
        GeneralItem("XXL"),GeneralItem("?"),GeneralItem("Cafe"))
    private val Fibonacci =  mutableListOf<GeneralItem>(GeneralItem("0"),GeneralItem("1"),GeneralItem("2"),GeneralItem("3"),GeneralItem("5"),
        GeneralItem("8"),GeneralItem("13"),GeneralItem("21"),GeneralItem("34"),GeneralItem("55"),GeneralItem("89"),GeneralItem("144"),
        GeneralItem("INF"),GeneralItem("?"),GeneralItem("Cafe"))
    private val Hours =  mutableListOf<GeneralItem>(GeneralItem("0"),GeneralItem("1"),GeneralItem("2"),GeneralItem("3"),GeneralItem("4"),GeneralItem("6"),
        GeneralItem("8"),GeneralItem("12"),GeneralItem("16"),GeneralItem("24"),GeneralItem("32"),GeneralItem("40"),GeneralItem("?"),GeneralItem("Cafe"))




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_deck_cards, container, false)
        val recycler_view= view.findViewById<RecyclerView>(R.id.rec)

        try {
            when (viewModel.spin) {
                "Standard" -> {

                    val adapter = Adapter(standard,view)
                    recycler_view.adapter = adapter
                }
                "T-Shirt" -> {
                    val adapter = Adapter(T_shirt,view)
                    //adapter.show = activity as Show
                    recycler_view.adapter = adapter
                }
                "Fibonacci" -> {
                    val adapter = Adapter(Fibonacci,view)
                    //adapter.show = activity as Show
                    recycler_view.adapter = adapter
                }
                "Hours" -> {
                    val adapter = Adapter(Hours,view)
                    //adapter.show = activity as Show
                    recycler_view.adapter = adapter
                }
            }
        }
        catch (e: Exception){
            val adapter = Adapter(standard,view)
            recycler_view.adapter = adapter

        }


        recycler_view.setHasFixedSize(true)
       recycler_view.layoutManager = GridLayoutManager(context, 3)





        return view
    }

    override fun onClickItem(item: Any) {

        //navHostFragment.navController.navigate(R.id.action_deck_cards_to_show_Card)
    }


}