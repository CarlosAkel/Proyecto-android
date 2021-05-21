package com.example.pp.base

import androidx.lifecycle.LiveData
import androidx.room.*
@Dao
interface SalaDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addContact(sala: Sala)

    @Delete
    suspend fun delete(sala: Sala)


    @Query("Select * From contact_table ORDER BY  id ASC")
    fun readAllData(): LiveData<List<Sala>>
}