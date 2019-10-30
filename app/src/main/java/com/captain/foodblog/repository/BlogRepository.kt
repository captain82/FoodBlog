package com.captain.foodblog.repository

import com.captain.foodblog.database.ServiceGenerator
import com.captain.foodblog.models.BlogResponseModel
import retrofit2.Call

class BlogRepository {

    private val mApiClient = ServiceGenerator.api

    fun getAllBlogs(): Call<BlogResponseModel>
    {


        return mApiClient.getAllBlogs()
    }

    companion object
    {
        @Volatile
        private var instance:BlogRepository? = null

        fun getInstance() = instance?: synchronized(this){
            instance?:BlogRepository().also { instance = it }
        }
    }
}