package com.andrescalco.singletonmvvm.api

import com.andrescalco.singletonmvvm.model.User
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface ApiService {
    @GET("placeholder/user/{userId}")
    suspend fun getUser(
        @Path("userId") userId: String
    ) : User
}