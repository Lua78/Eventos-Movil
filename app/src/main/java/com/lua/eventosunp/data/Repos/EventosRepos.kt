package com.lua.eventosunp.data.Repos

import com.lua.eventosunp.api.RetrofitClient
import com.lua.eventosunp.api.catalogs.Alumnos
import com.lua.eventosunp.api.catalogs.Eventos
import com.lua.eventosunp.data.modelos.Alumno
import com.lua.eventosunp.data.modelos.Evento


class EventosRepos {
    private val apiService = RetrofitClient.instance.create(Eventos::class.java)
     suspend fun getEventos(): List<Evento> {
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