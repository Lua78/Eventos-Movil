package com.lua.eventosunp.data.DTO

data class Categoria(
    val Estado: Int,
    val Nombre: String,
    val idCategoria: Int
)

data class CategoriasApiResponse(
    val datos: List<Categoria>,
    val code: Int
)
