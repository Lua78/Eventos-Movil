package com.lua.eventosunp.data.Repos

import com.lua.eventosunp.api.RetrofitClient
import com.lua.eventosunp.api.catalogs.Alumnos
import com.lua.eventosunp.data.modelos.Alumno


class AlumnosRepos {
    private val apiService = RetrofitClient.instance.create(Alumnos::class.java)
     suspend fun getAlumnos(): List<Alumno> {
        return try {
            val response = apiService.get()
            if (response.isSuccessful) {
                val res = response.body()
                if (res?.code == 1) {
                    res.datos
                } else {
                    emptyList()
                }
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}