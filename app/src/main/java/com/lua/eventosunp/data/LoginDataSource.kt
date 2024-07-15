package com.lua.eventosunp.data

import com.lua.eventosunp.data.DTO.LoggedInUser
import com.lua.eventosunp.AuthManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import android.content.Context
import com.lua.eventosunp.data.DTO.Payload
import com.google.gson.Gson

class LoginDataSource(private val context:Context) {
    suspend fun login(username: String, contrasena: String): Result<LoggedInUser> {
        return withContext(Dispatchers.IO) {
            try {
                val (exitoso, loginResponse) = AuthManager.login(username, contrasena)
                if (exitoso && loginResponse != null) {
                    val loggedInUser = LoggedInUser(
                        token = loginResponse.token,
                        displayName = loginResponse.payload.nombre_usuario,
                        payload = loginResponse.payload)
                    saveToken(loginResponse.token, loginResponse.payload)
                    Result.Success(loggedInUser)
                } else {
                    Result.Error(IOException("Inicio de sesión fallido."))
                }
            } catch (e: Exception) {
                Result.Error(IOException("Error durante la autenticación.", e))
            }
        }
    }
    private fun saveToken(token: String, payload: Payload) {
        val gson = Gson()
        val sharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val payloadJson = gson.toJson(payload)
        editor.putString("auth_token", token)
        editor.putString("user_payload", payloadJson)
        editor.apply()
    }

    fun getToken(context: Context): String? {
        val sharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        return sharedPreferences.getString("auth_token", null)
    }

    fun getPayload(context: Context): Payload? {
        val sharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        val payloadJson = sharedPreferences.getString("user_payload", null)
        return if (payloadJson != null) {
            val gson = Gson()
            gson.fromJson(payloadJson, Payload::class.java)
        } else {
            null
        }
    }
    fun logout() {
       return clearSavedData()
    }
    private fun clearSavedData() {
        val sharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.remove("auth_token")
        editor.remove("user_payload")
        editor.apply()
    }
}

