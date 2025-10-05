package com.route.islamic42gsunwed.fragments.radio.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RadioApi {
    companion object {
        lateinit var retrofit: Retrofit

        fun getRadioServices(): RadioServices {
            return initRetrofit().create(RadioServices::class.java)
        }

        private fun initRetrofit(): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(" https://mp3quran.net/api/v3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                return retrofit
            } else {
                return retrofit
            }
        }
    }
}