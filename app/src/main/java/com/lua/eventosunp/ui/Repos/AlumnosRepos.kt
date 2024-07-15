package com.lua.eventosunp.ui.Repos

import com.lua.eventosunp.api.RetrofitClient
import com.lua.eventosunp.api.catalogs.Alumnos
import com.lua.eventosunp.data.DTO.Alumno
import com.lua.eventosunp.ui.fragments.CRUDS.DTOs.AlumnoDto

class AlumnosRepos {
    private val apiService = RetrofitClient.instance.create(Alumnos::class.java)

    // Obtener lista de alumnos
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

    // Agregar un alumno
    suspend fun agregarAlumno(alumno: AlumnoDto): String {
        return try {
            val response = apiService.post(alumno)
            if (response.isSuccessful) {
                "Alumno agregado correctamente"
            } else {
                "Error al agregar alumno"
            }
        } catch (e: Exception) {
            "Error"
        }
    }

    // Eliminar un alumno
    suspend fun eliminarAlumno(alumno: Alumno): String {
        return try {
            val response = apiService.delete(alumno.Carne)
            if (response.isSuccessful) {
                "Alumno eliminado correctamente"
            } else {
                "Error al eliminar alumno"
            }
        } catch (e: Exception) {
            "Error"
        }
    }
}
