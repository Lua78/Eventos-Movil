package com.lua.eventosunp.data

import com.lua.eventosunp.data.DTO.LoggedInUser
import com.lua.eventosunp.AuthManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException



class LoginDataSource {

    suspend fun login(username: String, contrasena: String): Result<LoggedInUser> {
        return withContext(Dispatchers.IO) {
            try {
                val (exitoso, loginResponse) = AuthManager.login(username, contrasena)
                if (exitoso && loginResponse != null) {
                    val loggedInUser = LoggedInUser(
                        token = loginResponse.token,
                        displayName = loginResponse.payload.nombre_usuario,
                        payload = loginResponse.payload)
                    Result.Success(loggedInUser)
                } else {
                    Result.Error(IOException("Inicio de sesión fallido."))
                }
            } catch (e: Exception) {
                Result.Error(IOException("Error durante la autenticación.", e))
            }
        }
    }

    fun logout() {
        // TODO: Implementa la lógica para revocar la autenticación
    }
}

