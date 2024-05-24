package com.lua.eventosunp.data.modelos

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