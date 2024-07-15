package com.lua.eventosunp.api.catalogs

import com.lua.eventosunp.data.DTO.Alumno
import com.lua.eventosunp.data.DTO.AlumnosApiResponse
import com.lua.eventosunp.ui.fragments.CRUDS.DTOs.AlumnoDto
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
    suspend fun delete(@retrofit2.http.Path("carne") carne: String): Response<Unit>

    @PUT(semiUrl)
    suspend fun update(@Body data: AlumnoDto): Response<Unit>

    @POST(semiUrl)
    suspend fun post(@Body alumno: AlumnoDto): Response<Unit>
}
