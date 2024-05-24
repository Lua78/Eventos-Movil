package com.lua.eventosunp.data.modelos

data class Categoria(
    val Estado: Int,
    val Nombre: String,
    val idCategoria: Int
)

data class CategoriasApiResponse(
    val datos: List<Categoria>,
    val code: Int
)
