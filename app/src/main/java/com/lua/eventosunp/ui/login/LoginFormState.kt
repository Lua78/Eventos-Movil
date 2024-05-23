package com.lua.eventosunp.ui.login

/**
 * Data validation state of the login form.
 */
data class LoginFormState(
    val usernameError: Int? = null,
    val contrasenaError: Int? = null,
    val isDataValid: Boolean = false
)