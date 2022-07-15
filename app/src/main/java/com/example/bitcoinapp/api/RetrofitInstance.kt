package com.example.bitcoinapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.coindesk.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val api = retrofit.create(CoindeskAPI::class.java)
}