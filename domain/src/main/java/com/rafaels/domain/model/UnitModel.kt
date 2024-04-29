package com.rafaels.domain.model


data class UnitModels(
    val unitModels: List<UnitModel>
)
data class UnitModel(
    val id: Int,
    val unitType: UnitTypeModel,
    val unitName: String,
    val attributes: ModelProfileModel,
    val otherModelInfo: OtherModelInfoModel,
    val equipment: List<String>,
    val options: List<String>,
    val specialRules: List<String>,
)

enum class UnitTypeModel(val value: String? = "unknown") {
    CHARACTERS("characters"),   //Max 50%
    CORE("core"),               //At least 25%
    SPECIAL("special"),         //Max 50%
    RARE("rare"),               //Max 25%
    MERCENARIES("mercenaries"), //Max 20%
    ALLIES("allies"),           //Max 25%
    UNKNOWN("unknown"),
}

data class ModelProfileModel(
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

data class OtherModelInfoModel(
    val troopType: TroopTypeModel,
    val baseSize: BaseSizeModel,
    val unitSize: Int,
)

enum class TroopTypeModel(val value: String? = "unknown") {
    REGULAR_INFANTRY("regular Infantry"),
    HEAVY_INFANTRY("heavy Infantry"),
    LIGHT_CAVALRY("light Cavalry"),
    HEAVY_CAVALRY("heavy Cavalry"),
    LIGHT_CHARIOT("light Chariot"),
    HEAVY_CHARIOT("heavy Chariot"),
    WAR_MACHINE("war Machine"),
    MONSTROUS_CREATURE("monstrous Creature"),
    BEHEMOTH("behemoth"),
    BEHEMOTH_CHARACTER("behemoth Character"),
    UNKNOWN("unknown"),
}

enum class BaseSizeModel(val value: String? = "unknown") {
    SMALL_25x25("25x25 mm"),
    MEDIUM_30x60("30x60 mm"),
    MEDIUM_50x50("50x50 mm"),
    LARGE_50x100("50x100 mm"),
    LARGE_60x100("60x100 mm"),
    UNKNOWN("unknown"),
}