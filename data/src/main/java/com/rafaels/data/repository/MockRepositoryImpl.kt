package com.rafaels.data.repository

import android.content.Context
import com.google.gson.Gson
import com.rafaels.data.extensions.getJsonDataFromAsset
import com.rafaels.data.mapper.mapUnitModels
import com.rafaels.data.model.UnitResponseDTO
import com.rafaels.domain.Resource
import com.rafaels.domain.repository.UnitRepository
import com.rafaels.domain.model.UnitModels
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

class MockRepositoryImpl(
    private val context: Context,
) : UnitRepository {

    override suspend fun getUnit(): Resource<UnitModels> =
        withContext(Dispatchers.IO) {
            val jsonFileString = context.getJsonDataFromAsset("mock.json")
            val gson = Gson()
            val result = gson.fromJson(jsonFileString, UnitResponseDTO::class.java)

            return@withContext Resource.Success(mapUnitModels(result.results))
        }

}