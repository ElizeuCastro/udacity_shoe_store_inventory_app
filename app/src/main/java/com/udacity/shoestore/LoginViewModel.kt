package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private var _loggedUser = MutableLiveData<Boolean>()
    val loggedUser: LiveData<Boolean>
        get() = _loggedUser

    fun onSignIn() {
        _loggedUser.value = true
    }

    fun onRegister() {
        _loggedUser.value = true
    }

    fun openWelcomeScreenComplete() {
        _loggedUser.value = false
    }
}