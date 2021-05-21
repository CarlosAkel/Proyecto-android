package com.example.pp.base

import androidx.lifecycle.LiveData

class SalaRepository (private val salaDao: SalaDao){


    val readAllData: LiveData<List<Sala>> = salaDao.readAllData()

    suspend fun addSala(sala: Sala){
        salaDao.addContact(sala)
    }

    suspend fun delete(sala: Sala){

        salaDao.delete(sala)
    }
}