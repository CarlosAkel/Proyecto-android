package com.example.pp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import com.example.pp.base.BaseViewModel
import com.example.pp.model.*


class F1 : Fragment() {

    private lateinit var viewModel: ApiViewModel
    lateinit var sharedPreferences: SharedPreferences
    var isRemembered=false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_f1, container, false)





        val checkbox = view.findViewById<CheckBox>(R.id.checkBox)
        sharedPreferences=context?.getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)!!
        isRemembered=sharedPreferences.getBoolean("CHECKBOX", false)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this,viewModelFactory).get(ApiViewModel::class.java)

        if(isRemembered){
            val email = sharedPreferences.getString("Email", "")
            val password=sharedPreferences.getString("Password","")
            val myPost2=Login(email.toString(),password.toString())
            viewModel.pushPost(myPost2)
        }




        view.findViewById<Button>(R.id.button).setOnClickListener {


            val email = view.findViewById<EditText>(R.id.Email).text.toString()
            val password = view.findViewById<EditText>(R.id.password).text.toString()
            val editor: SharedPreferences.Editor=sharedPreferences.edit()
            val checked:Boolean=checkbox.isChecked
            editor.putString("Email",email)
            editor.putString("Password",password)
            editor.putBoolean("CHECKBOX",checked)
            editor.apply()
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