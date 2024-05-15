package com.rafaels.data.mapper

import com.rafaels.data.model.ElvenHonoursDTO
import com.rafaels.data.model.ModelProfileDTO
import com.rafaels.data.model.OtherModelInfoDTO
import com.rafaels.data.model.SpecialRulesDTO
import com.rafaels.data.model.UnitDTO
import com.rafaels.data.model.RemoteResponseDTO
import com.rafaels.domain.model.BaseSizeModel
import com.rafaels.domain.model.ElvenHonourModel
import com.rafaels.domain.model.ModelProfileModel
import com.rafaels.domain.model.OtherModelInfoModel
import com.rafaels.domain.model.SpecialRuleModel
import com.rafaels.domain.model.TroopTypeModel
import com.rafaels.domain.model.UnitModel
import com.rafaels.domain.model.UnitModels
import com.rafaels.domain.model.UnitTypeModel

fun mapUnitModels(response: RemoteResponseDTO): UnitModels {
    return UnitModels(
        unitModels = mapFlatUnits(response).map { it.toUnitModel(response.result.specialRulesDetails) },
        specialRuleModel = response.result.specialRulesDetails.map { it.toSpecialRuleModel() },
        elvenHonours = response.result.elvenHonours.map { it.toElvenHonoursModel() },
    )
}

fun mapFlatUnits(response: RemoteResponseDTO): List<UnitDTO> = listOf(
    response.result.characters,
    response.result.core,
    response.result.special,
    response.result.rare
).flatten()

fun UnitDTO.toUnitModel(specialRulesDetails: List<SpecialRulesDTO>): UnitModel =
    UnitModel(
        id = id,
        unitType = unitType.toUnitTypeModel(),
        unitName = unitName,
        attributes = attributes.toModelProfileModel(),
        otherModelInfo = otherModelInfo.toOtherProfileModel(),
        equipment = equipment,
        options = emptyList(),
        specialRules = specialRulesDetails.toSpecialRulesModel(specialRules),
    )

fun String.toUnitTypeModel(): UnitTypeModel =
    when (this) {
        "Characters" -> UnitTypeModel.CHARACTERS
        "Core" -> UnitTypeModel.CORE
        "Special" -> UnitTypeModel.SPECIAL
        "Rare" -> UnitTypeModel.RARE
        "Mercenaries" -> UnitTypeModel.MERCENARIES
        "Allies" -> UnitTypeModel.ALLIES
        else -> UnitTypeModel.UNKNOWN
    }

fun ModelProfileDTO.toModelProfileModel(): ModelProfileModel =
    ModelProfileModel(
        movement = movement,
        weaponSkill = weaponSkill,
        ballisticSkill = ballisticSkill,
        strength = strength,
        toughness = toughness,
        wounds = wounds,
        initiative = initiative,
        attacks = attacks,
        leadership = leadership,
        basicPoint = basicPoint,
    )

fun OtherModelInfoDTO.toOtherProfileModel(): OtherModelInfoModel =
    OtherModelInfoModel(
        troopType = troopType.toTroopTypeModel(),
        baseSize = baseSize.toBaseSizeModel(),
        unitSize = unitSize,
    )

fun String.toTroopTypeModel(): TroopTypeModel =
    when (this) {
        "regularInfantry" -> TroopTypeModel.REGULAR_INFANTRY
        "HeavyInfantry" -> TroopTypeModel.HEAVY_INFANTRY
        "LightCavalry" -> TroopTypeModel.LIGHT_CAVALRY
        "HeavyCavalry" -> TroopTypeModel.HEAVY_CAVALRY
        "LightChariot" -> TroopTypeModel.LIGHT_CHARIOT
        "HeavyChariot" -> TroopTypeModel.HEAVY_CHARIOT
        "WarMachine" -> TroopTypeModel.WAR_MACHINE
        "MonstrousCreature" -> TroopTypeModel.MONSTROUS_CREATURE
        "Behemoth" -> TroopTypeModel.BEHEMOTH
        "BehemothCharacter" -> TroopTypeModel.BEHEMOTH_CHARACTER
        else -> TroopTypeModel.UNKNOWN
    }

fun String.toBaseSizeModel(): BaseSizeModel =
    when (this) {
        "25x25" -> BaseSizeModel.SMALL_25x25
        "30x60" -> BaseSizeModel.MEDIUM_30x60
        "50x50" -> BaseSizeModel.MEDIUM_50x50
        "50x100" -> BaseSizeModel.LARGE_50x100
        "60x100" -> BaseSizeModel.LARGE_60x100
        else -> BaseSizeModel.UNKNOWN
    }

fun List<SpecialRulesDTO>.toSpecialRulesModel(keys: List<String>): List<SpecialRuleModel> =
    this.filter { it.rule in keys }.map { it.toSpecialRuleModel() }


fun SpecialRulesDTO.toSpecialRuleModel(): SpecialRuleModel =
    SpecialRuleModel(rule = rule, description = description)

fun ElvenHonoursDTO.toElvenHonoursModel(): ElvenHonourModel =
    ElvenHonourModel(
        honour = honour,
        honourPoints = honourPoints,
        honourDescription = honourDescription,
        addSpecialRules = addSpecialRules
    )

