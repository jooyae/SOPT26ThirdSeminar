package com.example.practicesecond.data

import com.google.gson.annotations.SerializedName

data class ResponseLogin(
    val status : Int,
    val success : Boolean,
    @SerializedName("data")
    val data: SomeData?
)

data class SomeData(
    val jwt: String
)