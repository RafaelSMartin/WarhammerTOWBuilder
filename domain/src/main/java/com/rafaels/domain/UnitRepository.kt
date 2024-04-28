package com.rafaels.domain

import com.rafaels.domain.model.UnitModel

interface UnitRepository {
    suspend fun getUnit(): Resource<UnitModel>
}