package com.captain.foodblog.database

import com.captain.foodblog.models.BlogResponseModel
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET(".")
    fun getAllBlogs(): Call<BlogResponseModel>
}