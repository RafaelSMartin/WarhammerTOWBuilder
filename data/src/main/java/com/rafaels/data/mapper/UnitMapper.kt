package com.rafaels.data.mapper

import com.rafaels.data.model.ModelProfileDTO
import com.rafaels.data.model.OtherModelInfoDTO
import com.rafaels.data.model.UnitDTO
import com.rafaels.domain.model.BaseSizeModel
import com.rafaels.domain.model.ModelProfileModel
import com.rafaels.domain.model.OtherModelInfoModel
import com.rafaels.domain.model.TroopTypeModel
import com.rafaels.domain.model.UnitModel
import com.rafaels.domain.model.UnitModels
import com.rafaels.domain.model.UnitTypeModel

fun mapUnitModels(values: List<UnitDTO>): UnitModels {
    return UnitModels(unitModels = values.map { it.toUnitModel() })
}

fun UnitDTO.toUnitModel(): UnitModel =
    UnitModel(
        id = id,
        unitType = unitType.toUnitTypeModel(),
        unitName = this.unitName,
        attributes = this.attributes.toModelProfileModel(),
        otherModelInfo = this.otherModelInfo.toOtherProfileModel(),
        equipment = emptyList(),
        options = emptyList(),
        specialRules = emptyList(),
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
        movement = this.movement,
        weaponSkill = this.weaponSkill,
        ballisticSkill = this.ballisticSkill,
        strength = this.strength,
        toughness = this.toughness,
        wounds = this.wounds,
        initiative = this.initiative,
        attacks = this.attacks,
        leadership = this.leadership,
        basicPoint = this.basicPoint,
    )

fun OtherModelInfoDTO.toOtherProfileModel(): OtherModelInfoModel =
    OtherModelInfoModel(
        troopType = this.troopType.toTroopTypeModel(),
        baseSize = this.baseSize.toBaseSizeModel(),
        unitSize = this.unitSize,
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