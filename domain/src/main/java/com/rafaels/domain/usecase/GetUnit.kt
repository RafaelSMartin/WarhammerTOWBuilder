package com.rafaels.domain.usecase

import com.rafaels.domain.Resource
import com.rafaels.domain.UnitRepository
import com.rafaels.domain.model.UnitModel

class GetUnit(
    private val repository: UnitRepository
) {
    suspend fun getUnit(): Resource<UnitModel> = repository.getUnit()
}