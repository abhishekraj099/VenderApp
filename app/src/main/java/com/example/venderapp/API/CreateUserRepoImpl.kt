package com.example.venderapp.API


//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.flow
//
//class CreateUserRepoImpl(
//    private val api: API_Builder
//) : CreateUserRepo {
//    override suspend fun createUser(): Flow<Result<UserCreateResponse>> {
//        return flow {
//            val userCreateResponse = try {
//
//
//                api.createUser(
//                    "Abhishek",
//                    "123456",
//                    "test@gmail.com",
//                    "1234567890",
//                    "Delhi",
//                    "110001"
//                )
//            } catch (e: Exception) {
//                emit(Result.Error(message = e.localizedMessage.toString()))
//                return@flow
//
//
//            }
//            emit(Result.Success(userCreateResponse))
//        }
//    }
//}