package com.captain.foodblog.database

import com.captain.foodblog.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {

    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())

    private val retrofit = retrofitBuilder.build()

    val api: Api = retrofit.create(Api::class.java)
}