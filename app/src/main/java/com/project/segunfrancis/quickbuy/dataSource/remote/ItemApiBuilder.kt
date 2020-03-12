package com.project.segunfrancis.quickbuy.dataSource.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by SegunFrancis
 */
object ItemApiBuilder {
    private const val BASE_URL = "https://mobilebackend.turing.com/"

    fun create(): ItemService {
        val logger = HttpLoggingInterceptor()
        logger.level = Level.BASIC

        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ItemService::class.java)
    }
}