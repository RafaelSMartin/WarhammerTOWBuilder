package com.rafaels.data.repository

import com.rafaels.data.BuildConfig
import com.rafaels.data.api.UnitApi
import com.rafaels.data.error.ErrorHandler
import com.rafaels.domain.Resource
import com.rafaels.domain.UnitRepository
import com.rafaels.domain.model.UnitModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UnitRepositoryImpl(
    private val api: UnitApi,
    private val errorHandler: ErrorHandler,
): UnitRepository {

    override suspend fun getUnit(): Resource<UnitModel> =
        withContext(Dispatchers.IO) {
            try {

                val response = api.getUnit(0)

                if (response.isSuccessful) {
                    //return@withContext Resource.Success(response.body()!!.toOompaLoompaModel())
                    return@withContext Resource.Success(
                       UnitModel(0, "Teclis")
                    )
                } else {
                    /*return@withContext Resource.Error(
                        errorHandler(
                            response.code(),
                            response.errorBody()
                        )
                    )*/
                    return@withContext Resource.Success(
                        UnitModel(0, "Teclis")
                    )
                }
            } catch (e: Exception) {
                return@withContext Resource.Error(errorHandler(e))
            }
        }

}