package com.example.misrecetasapplication.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://ec2-3-95-227-60.compute-1.amazonaws.com:3101/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}


