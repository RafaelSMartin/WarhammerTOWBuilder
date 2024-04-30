package com.rafaels.data.model

data class UnitResponseDTO(
    val current: Int,
    val total: Int,
    val results: List<UnitDTO>
)

data class UnitDTO(
    val id: Int,
    val unitType: String,
    val unitName: String,
    val attributes: ModelProfileDTO,
    val otherModelInfo: OtherModelInfoDTO,
    val equipment: String,
    val options: List<String>,
    val specialRules: List<String>,
)

data class ModelProfileDTO(
    val movement: Int,
    val weaponSkill: Int,
    val ballisticSkill: Int,
    val strength: Int,
    val toughness: Int,
    val wounds: Int,
    val initiative: Int,
    val attacks: Int,
    val leadership: Int,
    val basicPoint: Int,
)

data class OtherModelInfoDTO(
    val troopType: String,
    val baseSize: String,
    val unitSize: Int,
)
