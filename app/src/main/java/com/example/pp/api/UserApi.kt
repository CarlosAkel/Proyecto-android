package com.example.pp.api

import com.example.pp.model.Login
import com.example.pp.model.Singup
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {



    @POST("login")//Encouded
    suspend fun pushPost(
            @Body post: Login
    ): Response<Login>


    @POST("signup")//Encouded
    suspend fun pushPost2(
        @Body post: Singup
    ): Response<Singup>




}