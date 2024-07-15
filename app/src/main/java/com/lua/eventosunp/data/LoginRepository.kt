package com.lua.eventosunp.data

import android.content.Context
import com.lua.eventosunp.data.DTO.LoggedInUser
import com.lua.eventosunp.data.DTO.Payload

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepository(val dataSource: LoginDataSource) {

    // in-memory cache of the loggedInUser object
    var user: LoggedInUser? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        user = null
    }

    fun logout() {
        user = null
        dataSource.logout()
    }

    suspend fun login(username: String, contrasena: String): Result<LoggedInUser> {
        val result = dataSource.login(username, contrasena)
        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }

        return result
    }

    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
        this.user = loggedInUser
    }
    fun getToken(context: Context): String? {
        return dataSource.getToken(context)
    }

    fun getPayload(context: Context): Payload? {
        return dataSource.getPayload(context)
    }
}