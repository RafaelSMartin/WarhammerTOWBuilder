package com.rafaels.data.model

data class RemoteResponseDTO(
    val current: Int,
    val total: Int,
    val result: ResultDTO,
)

data class ResultDTO(
    val characters: List<UnitDTO>,
    val core: List<UnitDTO>,
    val special: List<UnitDTO>,
    val rare: List<UnitDTO>,
    val specialRulesDetails: List<SpecialRulesDTO>,
    val elvenHonours: List<ElvenHonoursDTO>,
    val elvenArmoury: List<MagicItemDTO>,
    val magicItems: MagicItemsDTO,
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
    val armourValue: String?,
)

data class SpecialRulesDTO(
    val rule: String,
    val description: String,
)

data class ElvenHonoursDTO(
    val honour: String,
    val honourPoints: Int,
    val honourDescription: String,
    val addSpecialRules: List<String>
)

data class MagicItemsDTO(
    val magicWeapons: List<MagicItemDTO>,
    val magicArmour: List<MagicItemDTO>,
    val magicStandards: List<MagicItemDTO>,
    val talismans: List<MagicItemDTO>,
    val enchantedItems: List<MagicItemDTO>,
    val arcaneItems: List<MagicItemDTO>,
)

data class MagicItemDTO(
    val name: String,
    val point: Int,
    val range: String?,
    val strength: String?,
    val armourPenetration: Int?,
    val specialRules: List<String>?,
    val notes: String?,
    val description: String?,
)