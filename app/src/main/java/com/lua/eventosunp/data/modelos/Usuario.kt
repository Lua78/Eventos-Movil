package com.lua.eventosunp.data.modelos

import com.google.gson.annotations.SerializedName

data class Usuario(
    @SerializedName("Carne") val carne: String,
    @SerializedName("Nombre") val nombre: String,
    @SerializedName("Nombre de USUARIO") val nombreDeUsuario: String,
    @SerializedName("Admin") val admin: Int
)
