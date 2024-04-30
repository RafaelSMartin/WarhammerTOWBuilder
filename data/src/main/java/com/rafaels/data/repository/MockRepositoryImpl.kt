package com.rafaels.data.repository

import android.content.Context
import com.google.gson.Gson
import com.rafaels.data.mapper.mapUnitModels
import com.rafaels.data.model.UnitResponseDTO
import com.rafaels.domain.Resource
import com.rafaels.domain.UnitRepository
import com.rafaels.domain.model.UnitModels
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

class MockRepositoryImpl(
    private val context: Context,
): UnitRepository {

    override suspend fun getUnit(): Resource<UnitModels> =
        withContext(Dispatchers.IO) {
            val jsonFileString = getJsonDataFromAsset(context, "mock.json")
            val gson = Gson()
            val result = gson.fromJson(jsonFileString, UnitResponseDTO::class.java)

            return@withContext Resource.Success(mapUnitModels(result.results))
        }


    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

}