package com.example.venderapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.venderapp.API.ProductDataClassItem
import com.example.venderapp.API.RetrofitInstance
import com.example.venderapp.pref.DataStoreManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class VendorViewModel(private val dataStoreManager: DataStoreManager) : ViewModel() {

    var state = mutableStateOf("")
    var products = mutableStateOf<List<ProductDataClassItem?>>(emptyList())
    private val _userId = MutableStateFlow(0)
    val userId = _userId.asStateFlow()

    init {
        state.value = State.DEFAULT.name
        viewModelScope.launch {
            products.value = RetrofitInstance.api.getAllProducts()
            dataStoreManager.userPref.getPref().collect {
                _userId.value = it
            }
        }
    }

    fun savePref(id: Int){
        viewModelScope.launch {
            dataStoreManager.userPref.setPref(id)
        }
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
                    savePref(151)
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
