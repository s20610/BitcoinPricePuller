package com.example.bitcoinapp.api

import retrofit2.Response

object Repository {
    suspend fun getCurrentPrice(): Response<CoindeskResponse> {
        return RetrofitInstance.api.getCurrentPrice()
    }
}