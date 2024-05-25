package com.lua.eventosunp.ui.Repos

import com.lua.eventosunp.api.RetrofitClient
import com.lua.eventosunp.api.catalogs.Carreras
import com.lua.eventosunp.data.DTO.Carrera


class CarrerasRepos {
    private val apiService = RetrofitClient.instance.create(Carreras::class.java)
     suspend fun getCarreras(): List<Carrera> {
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