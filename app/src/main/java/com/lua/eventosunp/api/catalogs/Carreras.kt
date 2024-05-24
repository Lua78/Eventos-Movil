package com.lua.eventosunp.api.catalogs

import com.lua.eventosunp.data.modelos.Alumno
import com.lua.eventosunp.data.modelos.AlumnosApiResponse
import com.lua.eventosunp.data.modelos.CarrerasApiResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
private const val semiUrl: String = "api/carreras/"

interface Carreras {

    @GET(semiUrl)
    suspend fun get(): Response<CarrerasApiResponse>

    @DELETE("$semiUrl{id}")
    suspend fun delete()

    @PUT(semiUrl)
    suspend fun update(@Body data: Alumno)

    @POST(semiUrl)
    suspend fun post(@Body alumno: Alumno)
}