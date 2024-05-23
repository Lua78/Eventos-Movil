package com.lua.eventosunp.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lua.eventosunp.data.LoginRepository
import com.lua.eventosunp.data.Result

import com.lua.eventosunp.R

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    suspend fun login(username: String, contrasena: String) {
        // can be launched in a separate asynchronous job
        val result = loginRepository.login(username, contrasena)

        if (result is Result.Success) {
            _loginResult.value =
                LoginResult(success = LoggedInUserView(displayName = result.data.displayName))
        } else {
            _loginResult.value = LoginResult(error = R.string.login_failed)
        }
    }

    fun loginDataChanged(username: String, contrasena: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!iscontrasenaValid(contrasena)) {
            _loginForm.value = LoginFormState(contrasenaError = R.string.invalid_contrasena)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
         if (username.isEmpty()) {
            return username.isNotBlank()
        }
        return true
    }

    // A placeholder contrasena validation check
    private fun iscontrasenaValid(contrasena: String): Boolean {
        return contrasena.length > 5
    }
}