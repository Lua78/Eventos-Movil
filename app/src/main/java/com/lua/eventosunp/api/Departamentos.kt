package com.lua.eventosunp.api


import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.GET

private const val semiUrl:String = "api/departamentos/"
interface Departamentos {
    @GET(semiUrl)
    suspend fun get()

}