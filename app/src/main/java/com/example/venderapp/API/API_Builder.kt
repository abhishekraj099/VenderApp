package com.example.venderapp.API

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface API_Builder {

    //    Create User
    @FormUrlEncoded
    @POST("/createUser")
    suspend fun createUser(
        @Field("name") name: String,
        @Field("password") password: String,
        @Field("email") email: String,
        @Field("address") address: String,
        @Field("phone") phone: String,
        @Field("pincode") pinCode: String,
    ): Response<UserCreateResponse>

//    @GET("/getAllUsers")
//    suspend fun getAllUsers()




}