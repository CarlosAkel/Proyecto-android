package com.example.pp.model

import retrofit2.Response

class Repository {




    suspend fun pushPost(post: Login): Response<Login>{
        return RetrofitInstance.api.pushPost(post)
    }

    suspend fun pushPost2(post: Singup): Response<Singup>{
        return RetrofitInstance.api.pushPost2(post)
    }
}