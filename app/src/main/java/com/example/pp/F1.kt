package com.example.pp

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.pp.base.BaseViewModel
import com.example.pp.model.*
import java.io.IOException


class F1 : Fragment() {

    private lateinit var viewModel: ApiViewModel
    lateinit var sharedPreferences: SharedPreferences
    lateinit var sharedPreferences2: SharedPreferences
    private val viewModel2: GeneralViewModel by activityViewModels()
    var isRemembered=false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_f1, container, false)




        val connectionManager : ConnectivityManager = activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? =  connectionManager.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true

        val checkbox = view.findViewById<CheckBox>(R.id.checkBox)
        sharedPreferences=context?.getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)!!
        isRemembered=sharedPreferences.getBoolean("CHECKBOX", false)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this,viewModelFactory).get(ApiViewModel::class.java)
        val email = sharedPreferences.getString("Email", "")
        val password=sharedPreferences.getString("Password","")

        if(isRemembered){

            checkbox.isChecked = true





            val myPost2=Login(email.toString(),password.toString())





            if(isConnected){
                viewModel.pushPost(myPost2)
            }
            else{
                Toast.makeText(activity, "No Internet connection", Toast.LENGTH_SHORT).show()
            }

        }




        view.findViewById<Button>(R.id.button).setOnClickListener {

            //viewModel2.spinPos =  sharedPreferences.getInt(viewModel2.email, 0)


            val email2 = view.findViewById<EditText>(R.id.Email).text.toString()
            val password2 = view.findViewById<EditText>(R.id.password).text.toString()
            val myPost2 = Login(email2,password2)





            if(isConnected){
                viewModel.pushPost(myPost2)
            }
            else{
                Toast.makeText(activity, "No Internet connection", Toast.LENGTH_SHORT).show()
            }


        }
        view.findViewById<TextView>(R.id.SingIn).setOnClickListener{


            if(isConnected){
                Navigation.findNavController(view).navigate(R.id.action_f1_to_registrationFragment)
            }
            else{
                Toast.makeText(activity, "No Internet connection", Toast.LENGTH_SHORT).show()
            }



        }


        viewModel.myResponse.observe(viewLifecycleOwner, Observer {response ->
                if(response.isSuccessful){
                    Log.d("Main",response.body().toString())
                    Log.d("CORRECT",response.code().toString())
                    Log.d("Main3",response.message())

                    viewModel2.email = email.toString()

                    if(email == "" && password == ""){

                        val email = view.findViewById<EditText>(R.id.Email).text.toString()
                        val password = view.findViewById<EditText>(R.id.password).text.toString()
                        val editor: SharedPreferences.Editor=sharedPreferences.edit()
                        val checked:Boolean=checkbox.isChecked
                        editor.putString("Email",email)
                        editor.putString("Password",password)
                        editor.putBoolean("CHECKBOX",checked)


                        viewModel2.email = email.toString()
                        editor.apply()
                    }





                    sharedPreferences2=context?.getSharedPreferences("SHARED_PREF2", Context.MODE_PRIVATE)!!//new

                    var loc = sharedPreferences2.getInt(viewModel2.email, 0)
                    viewModel2.spinPos =  loc

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