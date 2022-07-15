package com.example.bitcoinapp.api

import com.google.gson.annotations.SerializedName

data class CoindeskResponse(
    @SerializedName("time")
    val time: Time,
    @SerializedName("bpi")
    val bpi: Bpi
)

data class Bpi(
    @SerializedName("USD")
    val usd: Usd
)

data class Usd(
    @SerializedName("rate")
    val rate: String
)

data class Time(
    @SerializedName("updated")
    val updated: String
)