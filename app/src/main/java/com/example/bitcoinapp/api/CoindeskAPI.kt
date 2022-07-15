package com.example.bitcoinapp.api

import retrofit2.Response
import retrofit2.http.GET

interface CoindeskAPI {

    @GET("v1/bpi/currentprice.json")
    suspend fun getCurrentPrice() : Response<CoindeskResponse>
}