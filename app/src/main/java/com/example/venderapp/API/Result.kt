package com.example.venderapp.API

sealed class Result<T>(
    val data: T? = null,
    val message: String? = null
) {
    //    Constant ki classes banti hai sealed class me
    class Success<T>(data: T?) : Result<T>(data = data)
    class Loading(message: String?) : Result<String>(message = message)
    class Error<T>(data: T? = null, message: String?) : Result<T>(data = data, message = message)
}

