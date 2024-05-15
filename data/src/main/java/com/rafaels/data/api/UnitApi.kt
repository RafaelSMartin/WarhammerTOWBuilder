package com.rafaels.data.api

import com.rafaels.data.model.RemoteResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UnitApi {

    @GET
    suspend fun getUnit(@Path("id") id: Int): Response<RemoteResponseDTO>
}