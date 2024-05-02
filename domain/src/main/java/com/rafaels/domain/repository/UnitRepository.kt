package com.rafaels.domain.repository

import com.rafaels.domain.Resource
import com.rafaels.domain.model.UnitModels

interface UnitRepository {
    suspend fun getUnit(): Resource<UnitModels>
}