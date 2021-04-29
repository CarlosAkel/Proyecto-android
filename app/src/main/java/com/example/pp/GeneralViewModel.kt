package com.example.pp

import android.app.Application
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.AndroidViewModel

class GeneralViewModel(application: Application): AndroidViewModel(application) {


    var spin = "Standard"

    fun changeSpin(s:String){
        spin = s
    }



}