package com.rafaels.data.api

import com.rafaels.data.model.UnitDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UnitApi {

    @GET("napptilus/oompa-loompas/{id}")
    suspend fun getUnit(@Path("id") id: Int): Response<UnitDTO>
}