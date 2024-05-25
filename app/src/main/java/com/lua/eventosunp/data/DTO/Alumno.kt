package com.lua.eventosunp.data.DTO

data class Alumno(
    val Carne: String,
    val FecNac: String,
    val Nombre: String,
    val anioIngreso: Int,
    val correo: String,
    val direccion: String,
    val idCarrera: Int,
    val nombreCarrera: String,
    val telefono: String
)

// Clase para representar la respuesta JSON completa
data class AlumnosApiResponse(
    val datos: List<Alumno>,
    val code: Int
)


