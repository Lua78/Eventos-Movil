package com.lua.eventosunp.data.model

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class LoggedInUser(
    val token: String,
    val displayName: String,
    val payload: Any
)
data class LoginResponse(
    val mensaje: String,
    val token: String,
    val code: Int,
    val payload: Payload // Aquí puedes utilizar el tipo que corresponda al payload de la respuesta
)
data class Payload(
    val nombre_usuario: String,
    val carne_alumno: String,
    val is_admin: Int,
    val Nombre: String,
    val direccion: String,
    val telefono: String,
    val FecNac: String, // O puedes usar un tipo de datos de fecha adecuado, como LocalDate
    val correo: String
)

