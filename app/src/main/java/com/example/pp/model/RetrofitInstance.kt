package com.example.pp.model

import com.example.pp.api.UserApi
import com.example.pp.url.Url.Companion.Base_url
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {


    private val retrofit by lazy{
        Retrofit.Builder().
        baseUrl(Base_url).
        addConverterFactory(GsonConverterFactory.create()).
        build()
    }

    val api: UserApi by lazy {
        retrofit.create(UserApi::class.java)
    }

}