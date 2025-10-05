package com.route.islamic42gsunwed.fragments.radio.api

import com.route.islamic42gsunwed.fragments.radio.api.model.RadioResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RadioServices {
    @GET("radios")
    fun getRadios(@Query("language") language: String? = "eng"): Call<RadioResponse>
}