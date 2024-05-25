package com.lua.eventosunp.data.DTO
data class Imagen(
    val `data`: List<Int>,
    val type: String
)
data class Evento(
    val Descripcion: String,
    val Estado: Int,
    val FechaFin: String,
    val Titulo: String,
    val fechainicio: String,
    val idCategoria: Int,
    val idEvento: Int,
    val imagen: Imagen
)

data class EventosApiResponse(
    val datos: List<Evento>,
    val code: Int
)
