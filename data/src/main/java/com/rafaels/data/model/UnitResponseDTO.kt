package com.rafaels.data.model

data class UnitResponseDTO(
    val current: Int,
    val total: Int,
    val results: List<UnitDTO>
)
