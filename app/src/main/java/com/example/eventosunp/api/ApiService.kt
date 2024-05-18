package api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

data class UserData(val usuario: String, val contrasena: String)

interface ApiService {
    @POST("/api/usuarios/login")
    fun login(@Body userData: UserData): Call<Any> // Cambia 'Any' al tipo de respuesta que esperas recibir
}
