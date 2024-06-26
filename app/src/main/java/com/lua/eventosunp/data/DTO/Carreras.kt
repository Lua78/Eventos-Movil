package com.lua.eventosunp.data.DTO

data class Carrera(
    val Departamento: String,
    val Nombre: String,
    val idCarrera: Int,
    val idDepartamento: Int
)

data class CarrerasApiResponse(
    val datos: List<Carrera>,
    val code: Int
)
