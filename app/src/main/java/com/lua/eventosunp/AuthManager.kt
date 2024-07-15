package com.lua.eventosunp

import com.lua.eventosunp.api.LoginPost
import com.lua.eventosunp.api.RetrofitClient
import com.lua.eventosunp.api.UserData
import com.lua.eventosunp.data.DTO.LoginResponse

object AuthManager {

    private val apiService = RetrofitClient.instance.create(LoginPost::class.java)

     suspend fun login(usuario: String, contrasena: String): Pair<Boolean, LoginResponse?> {
        val userData = UserData(usuario, contrasena)
        return try {
            val loginResponse = apiService.login(userData)
            val token = loginResponse.token
            RetrofitClient.initialize(tokeProvider = token)
            Pair(true, loginResponse)
        } catch (e: Exception) {
            Pair(false, null)
        }
    }
}
