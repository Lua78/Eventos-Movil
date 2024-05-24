package com.lua.eventosunp.api

import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST
import retrofit2.http.GET
import retrofit2.http.PUT
import com.lua.eventosunp.data.modelos.Alumno
import com.lua.eventosunp.data.modelos.AlumnosApiResponse
import retrofit2.Response

private const val semiUrl: String = "api/alumnos/"

interface Alumnos {
    @GET(semiUrl)
    suspend fun get():Response<AlumnosApiResponse>

    @DELETE("$semiUrl{carne}")
    suspend fun delete()

    @PUT(semiUrl)
    suspend fun update(@Body data: Alumno)

    @POST(semiUrl)
    suspend fun post(@Body alumno: Alumno)
}
