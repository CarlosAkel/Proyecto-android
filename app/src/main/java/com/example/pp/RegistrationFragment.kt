package com.example.pp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.pp.model.*


class RegistrationFragment : Fragment() {

    private lateinit var viewModel: ApiViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_registration, container, false)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this,viewModelFactory).get(ApiViewModel::class.java)


        view.findViewById<Button>(R.id.register).setOnClickListener{

            val user = view.findViewById<EditText>(R.id.RegUser).text.toString()
            val name = view.findViewById<EditText>(R.id.RegName).text.toString()
            val password = view.findViewById<EditText>(R.id.RegPassword).text.toString()

            val myPost2 = Singup(user,name,password)
            viewModel.pushPost2(myPost2)



        }
        view.findViewById<Button>(R.id.RegBack).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_registrationFragment_to_f1)
        }

        viewModel.myResponse2.observe(viewLifecycleOwner, Observer {response ->
            if(response.isSuccessful){
                Log.d("Main",response.body().toString())
                Log.d("CORRECT",response.code().toString())
                Log.d("Main3",response.message())
                Navigation.findNavController(view).navigate(R.id.action_registrationFragment_to_f1)
            }
            else{
                Log.d("ERROR",response.code().toString())
                Toast.makeText(activity, "ERROR", Toast.LENGTH_SHORT).show();
            }
        })


        return view
    }


}