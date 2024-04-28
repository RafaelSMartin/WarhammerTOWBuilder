package com.rafaels.domain.usecase

import com.rafaels.domain.UnitRepository

class GetUnit(
    private val repository: UnitRepository
) {
    suspend fun getUnit() = repository.getUnit()
}