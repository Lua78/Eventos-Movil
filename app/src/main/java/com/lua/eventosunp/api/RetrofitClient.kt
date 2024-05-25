package com.lua.eventosunp.api

import AuthInterceptor
import android.util.proto.ProtoOutputStream
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object RetrofitClient {
    private const val BASE_URL = "http://ec2-100-25-181-7.compute-1.amazonaws.com/back/"
    private var token: String? = ""
    fun initialize(tokeProvider:String?) {
        token = tokeProvider ?:  ""
    }

    private val logging = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }



    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .addInterceptor(AuthInterceptor())
        .build()

    val instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
    fun getToken(): String? {
        return token
    }
}
