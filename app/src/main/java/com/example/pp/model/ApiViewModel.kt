package com.example.pp.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class ApiViewModel(private  val  repository: Repository): ViewModel() {



    var myResponse: MutableLiveData<Response<Login>> = MutableLiveData()
    var myResponse2: MutableLiveData<Response<Singup>> = MutableLiveData()


    fun pushPost(post: Login){
        viewModelScope.launch {
            val response = repository.pushPost(post)
            myResponse.value = response
        }
    }


    fun pushPost2(post: Singup){
        viewModelScope.launch {
            val response = repository.pushPost2(post)
            myResponse2.value = response
        }
    }






}