package com.rafaels.data.repository

import com.rafaels.data.api.UnitApi
import com.rafaels.data.error.ErrorHandler
import com.rafaels.data.mapper.mapUnitModels
import com.rafaels.data.model.UnitResponseDTO
import com.rafaels.domain.Resource
import com.rafaels.domain.repository.UnitRepository
import com.rafaels.domain.model.UnitModels
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UnitRepositoryImpl(
    private val api: UnitApi,
    private val errorHandler: ErrorHandler,
): UnitRepository {

    override suspend fun getUnit(): Resource<UnitModels> =
        withContext(Dispatchers.IO) {
            try {
                val response: Response<UnitResponseDTO> = api.getUnit(0)

                if (response.isSuccessful) {
                    return@withContext Resource.Success(
                       mapUnitModels(response.body()!!.results)
                    )
                } else {
                    return@withContext Resource.Error(
                        errorHandler(
                            response.code(),
                            response.errorBody()
                        )
                    )
                }
            } catch (e: Exception) {
                return@withContext Resource.Error(errorHandler(e))
            }
        }

}