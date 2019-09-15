package com.test.retofitcalldemo1.network

import com.test.retofitcalldemo1.model.AppPages
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitService {

    @GET("/api/users/")
    suspend fun getPosts(): Response<AppPages>

    @POST("/api/users/")
    suspend fun addUsers(@Field("name") name : String,
                         @Field("email") email: String): Response<AppPages>
}