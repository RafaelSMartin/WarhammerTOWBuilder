package com.rafaels.data.model

data class UnitDTO(
    val id: Int,
    val unitType: UnitTypeDTO,
    val unitName: String,
    val attributes: ModelProfileDTO,
    val otherModelInfo: OtherModelInfoDTO,
    val equipment: List<String>,
    val options: List<String>,
    val specialRules: List<String>,
)








