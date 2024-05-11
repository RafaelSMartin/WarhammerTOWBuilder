package com.rafaels.data.api

import com.rafaels.data.model.UnitResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UnitApi {

    //Result
    @GET
    suspend fun getUnit(@Path("id") id: Int): Response<UnitResponseDTO>
}