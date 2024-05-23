package com.lua.eventosunp.api

import retrofit2.http.Body
import retrofit2.http.POST
import com.lua.eventosunp.data.model.LoginResponse

data class UserData(val user: String, val password: String)

interface LoginPost {
    @POST("api/usuarios/login")
    suspend fun login(@Body userData: UserData): LoginResponse
}
