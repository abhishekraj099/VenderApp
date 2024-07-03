package com.example.venderapp.Screens.SignUpPage
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.venderapp.API.RetrofitInstance
import kotlinx.coroutines.launch

class SignUpScreenViewModel : ViewModel() {
    var state = mutableStateOf("")

    init {
        state.value = State.DEFAULT.name
    }

    fun setDefault() {
        state.value = State.DEFAULT.name
    }

    fun createUser(
        name: String,
        password: String,
        email: String,
        address: String,
        phoneNumber: String,
        pinCode: String,
    ) {
        state.value = State.LOADING.name
        viewModelScope.launch {
            val result = RetrofitInstance.api.createUser(
                name = name,
                password = password,
                email = email,
                address = address,
                phone = phoneNumber,
                pinCode = pinCode
            )
            if (result.isSuccessful) {
                if (result.body()?.status == 200) {
                    state.value = State.SUCCESS.name
                } else {
                    state.value = State.FAILED.name
                }
            } else {
                state.value = State.FAILED.name
            }
        }
    }
}

sealed class State(var name: String) {
    object DEFAULT : State("DEFAULT")
    object FAILED : State("FAILED")
    object SUCCESS : State("SUCCESS")
    object LOADING : State("LOADING")
}