package com.example.pp.base

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(entities = [Sala::class],version = 1, exportSchema = false)
abstract class SalaDatabase: RoomDatabase() {

    abstract fun salaDao(): SalaDao


    companion object{
        @Volatile
        private var INSTANCE: SalaDatabase? = null

        fun getDatabase(context: Context): SalaDatabase{
            val temInstance = INSTANCE
            if(temInstance != null){
                return temInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SalaDatabase::class.java,
                    "sala_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}