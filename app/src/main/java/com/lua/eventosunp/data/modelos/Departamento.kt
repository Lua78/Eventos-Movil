package com.lua.eventosunp.data.modelos

data class Departamento(
    val Estado: Int,
    val Nombre: String,
    val idDepartamento: Int
)

data class DepartamentosApiResponse(
    val datos: List<Departamento>,
    val code: Int
)
