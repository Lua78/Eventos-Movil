package com.lua.eventosunp.api.catalogs

import com.lua.eventosunp.data.DTO.Alumno
import com.lua.eventosunp.data.DTO.AlumnosApiResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
private const val semiUrl: String = "api/alumnos/"

interface Alumnos {

    @GET(semiUrl)
    suspend fun get(): Response<AlumnosApiResponse>

    @DELETE("$semiUrl{carne}")
    suspend fun delete()

    @PUT(semiUrl)
    suspend fun update(@Body data: Alumno)

    @POST(semiUrl)
    suspend fun post(@Body alumno: Alumno)
}