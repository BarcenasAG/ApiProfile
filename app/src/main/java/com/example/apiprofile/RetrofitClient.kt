package com.example.apiprofile

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://randomuser.me/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val ConsumeApi = retrofit.create(com.example.apiprofile.data.remote.api.ConsumeApi::class.java)
}
