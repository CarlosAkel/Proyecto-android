package com.example.pp.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.pp.model.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BaseViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Sala>>
    private val repository: SalaRepository

    init{
        val productDao = SalaDatabase.getDatabase(application).salaDao()
        repository =  SalaRepository(productDao)
        readAllData = repository.readAllData
    }
    fun addProduct(sala: Sala){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addSala(sala)
        }
    }

    fun delete(product: Sala){
        viewModelScope.launch(Dispatchers.IO) {

            repository.delete(product)
        }
    }
}