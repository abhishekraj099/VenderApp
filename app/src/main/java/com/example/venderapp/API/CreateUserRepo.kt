package com.example.venderapp.API

import kotlinx.coroutines.flow.Flow
import kotlin.Result

interface CreateUserRepo {
    suspend fun createUser(): Flow<Result<UserCreateResponse>>
}