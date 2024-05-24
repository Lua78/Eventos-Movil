package com.lua.eventosunp.ui.Repos

import com.lua.eventosunp.api.RetrofitClient
import com.lua.eventosunp.api.catalogs.Alumnos
import com.lua.eventosunp.api.catalogs.Categorias
import com.lua.eventosunp.data.modelos.Alumno
import com.lua.eventosunp.data.modelos.Categoria


class CategoriasRepos {
    private val apiService = RetrofitClient.instance.create(Categorias::class.java)
     suspend fun getCategorias(): List<Categoria> {
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