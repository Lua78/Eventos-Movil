package com.example.eventosunp

import com.example.eventosunp.api.ApiService
import com.example.eventosunp.api.RetrofitClient
import com.example.eventosunp.api.UserData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object AuthManager {

    private val apiService = RetrofitClient.instance.create(ApiService::class.java)

    fun login(usuario: String, contrasena: String, callback: (Boolean) -> Unit) {
        val userData = UserData(usuario, contrasena)
        val call = apiService.login(userData)

        call.enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                if (response.isSuccessful) {
                    // La solicitud se realizó con éxito
                    callback(true)
                } else {
                    // Hubo un error en la solicitud
                    callback(false)
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                // Ocurrió un error en la comunicación con el servidor
                callback(false)
            }
        })
    }
}
