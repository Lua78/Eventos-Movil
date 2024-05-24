package com.lua.eventosunp.data.Repos

import com.lua.eventosunp.api.RetrofitClient
import com.lua.eventosunp.api.catalogs.Usuarios
import com.lua.eventosunp.data.modelos.Usuario


class UsuariosRepos {
    private val apiService = RetrofitClient.instance.create(Usuarios::class.java)
     suspend fun getUsuarios(): List<Usuario> {
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