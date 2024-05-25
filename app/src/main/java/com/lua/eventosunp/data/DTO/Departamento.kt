package com.lua.eventosunp.data.DTO

data class Departamento(
    val Estado: Int,
    val Nombre: String,
    val idDepartamento: Int
)

data class DepartamentosApiResponse(
    val datos: List<Departamento>,
    val code: Int
)
