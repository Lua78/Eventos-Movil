package com.lua.eventosunp.api.catalogs

import com.lua.eventosunp.data.modelos.Alumno
import com.lua.eventosunp.data.modelos.AlumnosApiResponse
import com.lua.eventosunp.data.modelos.DepartamentosApiResponse
import com.lua.eventosunp.data.modelos.EventosApiResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
private const val semiUrl: String = "api/eventos/"

interface Eventos {

    @GET(semiUrl)
    suspend fun get(): Response<EventosApiResponse>

    @DELETE("$semiUrl{id}")
    suspend fun delete()

    @PUT(semiUrl)
    suspend fun update(@Body data: Alumno)

    @POST(semiUrl)
    suspend fun post(@Body alumno: Alumno)
}