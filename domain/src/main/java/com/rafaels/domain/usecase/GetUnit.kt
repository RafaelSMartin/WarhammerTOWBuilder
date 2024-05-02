package com.rafaels.domain.usecase

import com.rafaels.domain.Resource
import com.rafaels.domain.repository.UnitRepository
import com.rafaels.domain.model.UnitModels

class GetUnit(
    private val repository: UnitRepository
) {
    suspend fun getUnit(): Resource<UnitModels> = repository.getUnit()
}