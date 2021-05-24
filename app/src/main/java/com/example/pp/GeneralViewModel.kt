package com.example.pp

import android.app.Application
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class GeneralViewModel(application: Application): AndroidViewModel(application) {

    //val lista = mutableListOf<Roomitem>()
    val currentlist: MutableLiveData<MutableList<Roomitem>> by lazy { MutableLiveData<MutableList<Roomitem>>()}

    var spin = "Standard"
    var spinPos = 0
    var email = "0"

    fun changeSpin(s:String){
        spin = s
    }



}