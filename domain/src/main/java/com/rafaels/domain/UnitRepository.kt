package com.rafaels.domain

import com.rafaels.domain.model.UnitModels

interface UnitRepository {
    suspend fun getUnit(): Resource<UnitModels>
}