package com.example.pp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import com.example.pp.base.BaseViewModel
import com.example.pp.model.*


class F1 : Fragment() {

    private lateinit var viewModel: ApiViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_f1, container, false)







        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this,viewModelFactory).get(ApiViewModel::class.java)







        view.findViewById<Button>(R.id.button).setOnClickListener {


            val email = view.findViewById<EditText>(R.id.Email).text.toString()
            val password = view.findViewById<EditText>(R.id.password).text.toString()

            val myPost2 = Login(email,password)
            viewModel.pushPost(myPost2)

        }
        view.findViewById<TextView>(R.id.SingIn).setOnClickListener{

            Navigation.findNavController(view).navigate(R.id.action_f1_to_registrationFragment)

        }


        viewModel.myResponse.observe(viewLifecycleOwner, Observer {response ->
            if(response.isSuccessful){
                Log.d("Main",response.body().toString())
                Log.d("CORRECT",response.code().toString())
                Log.d("Main3",response.message())
                Navigation.findNavController(view).navigate(R.id.action_f1_to_f2_23)
            }
            else{
                Log.d("ERROR",response.code().toString())
                Toast.makeText(activity, "ERROR", Toast.LENGTH_SHORT).show();
            }
        })

        return view
    }







}