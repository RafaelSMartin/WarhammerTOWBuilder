package com.rafaels.domain.model

import androidx.annotation.DrawableRes


data class UnitModels(
    val unitModels: List<UnitModel>,
    val specialRuleModel: List<SpecialRuleModel>,
    val elvenHonours: List<ElvenHonourModel>,
    val elvenArmoury: List<MagicItemModel>,
    val magicItems: MagicItemsModel,
)

data class UnitModel(
    val id: Int,
    val unitType: UnitTypeModel,
    val unitName: String,
    @DrawableRes val unitImage: Int? = null,
    val attributes: ModelProfileModel,
    val otherModelInfo: OtherModelInfoModel,
    val equipment: String,
    val options: List<String>,
    val specialRules: List<SpecialRuleModel>,
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
    val armourValue: String?
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

data class SpecialRuleModel(
    val rule: String,
    val description: String,
)

data class ElvenHonourModel(
    val honour: String,
    val honourPoints: Int,
    val honourDescription: String,
    val addSpecialRules: List<String>
)

data class MagicItemsModel(
    val magicWeapons: List<MagicItemModel>,
    val magicArmour: List<MagicItemModel>,
    val magicStandards: List<MagicItemModel>,
    val talismans: List<MagicItemModel>,
    val enchantedItems: List<MagicItemModel>,
    val arcaneItems: List<MagicItemModel>,
)

data class MagicItemModel(
    val name: String,
    val point: Int,
    val range: String? = null,
    val strength: String? = null,
    val armourPenetration: Int? = null,
    val specialRules: List<SpecialRuleModel>? = null,
    val notes: String? = null,
    val description: String? = null,
)