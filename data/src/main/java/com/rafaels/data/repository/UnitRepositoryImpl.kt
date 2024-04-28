package com.rafaels.data.repository

import com.rafaels.domain.UnitRepository
import com.rafaels.domain.model.UnitModel

class UnitRepositoryImpl(
    //private val api: UnitApi,
): UnitRepository {

    override suspend fun getUnit() = UnitModel(
        id = 0,
        name = "Tyrion"
    )

}