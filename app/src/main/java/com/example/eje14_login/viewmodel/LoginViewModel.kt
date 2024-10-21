package com.example.eje14_login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> get() = _loginResult

    fun validateLogin(email: String, password: String) {
        // Aquí podrías validar con un servicio o base de datos
        // Para este ejemplo, asumiremos un usuario fijo
        val correctEmail = "matias@gmail.com"
        val correctPassword = "password123"

        if (email == correctEmail && password == correctPassword) {
            _loginResult.value = true
        } else {
            _loginResult.value = false
        }
    }
}