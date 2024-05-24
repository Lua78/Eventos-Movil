package com.lua.eventosunp.ui.Repos

import com.lua.eventosunp.api.RetrofitClient
import com.lua.eventosunp.api.catalogs.Departamentos
import com.lua.eventosunp.data.modelos.Departamento


class DepartamentosRepos {
    private val apiService = RetrofitClient.instance.create(Departamentos::class.java)
     suspend fun getDepartamentos(): List<Departamento> {
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