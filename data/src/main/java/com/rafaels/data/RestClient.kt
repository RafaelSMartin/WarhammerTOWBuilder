package com.rafaels.data

import com.rafaels.data.api.UnitApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestClient {

    private val retrofitInstance: Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(createOkHttpClient())
        .build()

    fun getUnitApi(): UnitApi = retrofitInstance.create(UnitApi::class.java)

    private fun createOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(getLoggingInterceptor())
            .build()
    }

    private fun getLoggingInterceptor() = HttpLoggingInterceptor()
        .setLevel(getLoggingInterceptorLevel())

    private fun getLoggingInterceptorLevel() = if (BuildConfig.DEBUG) Level.BODY else Level.NONE
}