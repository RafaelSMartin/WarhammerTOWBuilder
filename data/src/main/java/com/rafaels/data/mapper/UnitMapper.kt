package com.rafaels.data.mapper

import com.rafaels.data.model.BaseSizeDTO
import com.rafaels.data.model.ModelProfileDTO
import com.rafaels.data.model.OtherModelInfoDTO
import com.rafaels.data.model.TroopTypeDTO
import com.rafaels.data.model.UnitDTO
import com.rafaels.data.model.UnitTypeDTO
import com.rafaels.domain.model.BaseSizeModel
import com.rafaels.domain.model.ModelProfileModel
import com.rafaels.domain.model.OtherModelInfoModel
import com.rafaels.domain.model.TroopTypeModel
import com.rafaels.domain.model.UnitModel
import com.rafaels.domain.model.UnitTypeModel

fun UnitDTO?.toUnitModel(): UnitModel =
    UnitModel(
        id = this?.id ?: 0,
        unitType = this?.unitType?.toUnitTypeModel() ?: UnitTypeModel.CHARACTERS,
        unitName = this?.unitName ?: "Prince",
        attributes = this?.attributes.toModelProfileModel(),
        otherModelInfo = this?.otherModelInfo.toOtherProfileModel(),
        equipment = emptyList(),
        options = emptyList(),
        specialRules = emptyList(),
    )

fun UnitTypeDTO?.toUnitTypeModel(): UnitTypeModel =
    when (this) {
        UnitTypeDTO.CHARACTERS -> UnitTypeModel.CHARACTERS
        UnitTypeDTO.CORE -> UnitTypeModel.CORE
        UnitTypeDTO.SPECIAL -> UnitTypeModel.SPECIAL
        UnitTypeDTO.RARE -> UnitTypeModel.RARE
        UnitTypeDTO.MERCENARIES -> UnitTypeModel.MERCENARIES
        UnitTypeDTO.ALLIES -> UnitTypeModel.ALLIES
        else -> UnitTypeModel.UNKNOWN
    }

fun ModelProfileDTO?.toModelProfileModel(): ModelProfileModel =
    ModelProfileModel(
        movement = this?.movement ?: 5,
        weaponSkill = this?.weaponSkill ?: 7,
        ballisticSkill = this?.ballisticSkill ?: 7,
        strength = this?.strength ?: 4,
        toughness = this?.toughness ?: 3,
        wounds = this?.wounds ?: 3,
        initiative = this?.initiative ?: 6,
        attacks = this?.attacks ?: 4,
        leadership = this?.leadership ?: 10,
        basicPoint = this?.basicPoint ?: 130,
    )

fun OtherModelInfoDTO?.toOtherProfileModel(): OtherModelInfoModel =
    OtherModelInfoModel(
        troopType = this?.troopType?.toTroopTypeModel() ?: TroopTypeModel.REGULAR_INFANTRY,
        baseSize = this?.baseSize?.toBaseSizeModel() ?: BaseSizeModel.SMALL_25x25,
        unitSize = 1,
    )

fun TroopTypeDTO?.toTroopTypeModel(): TroopTypeModel =
    when (this) {
        TroopTypeDTO.REGULAR_INFANTRY -> TroopTypeModel.REGULAR_INFANTRY
        TroopTypeDTO.HEAVY_INFANTRY -> TroopTypeModel.HEAVY_INFANTRY
        TroopTypeDTO.LIGHT_CAVALRY -> TroopTypeModel.LIGHT_CAVALRY
        TroopTypeDTO.HEAVY_CAVALRY -> TroopTypeModel.HEAVY_CAVALRY
        TroopTypeDTO.LIGHT_CHARIOT -> TroopTypeModel.LIGHT_CHARIOT
        TroopTypeDTO.HEAVY_CHARIOT -> TroopTypeModel.HEAVY_CHARIOT
        TroopTypeDTO.WAR_MACHINE -> TroopTypeModel.WAR_MACHINE
        TroopTypeDTO.MONSTROUS_CREATURE -> TroopTypeModel.MONSTROUS_CREATURE
        TroopTypeDTO.BEHEMOTH -> TroopTypeModel.BEHEMOTH
        TroopTypeDTO.BEHEMOTH_CHARACTER -> TroopTypeModel.BEHEMOTH_CHARACTER
        else -> TroopTypeModel.UNKNOWN
    }

fun BaseSizeDTO?.toBaseSizeModel(): BaseSizeModel =
    when(this){
        BaseSizeDTO.SMALL_25x25 -> BaseSizeModel.SMALL_25x25
        BaseSizeDTO.MEDIUM_30x60 -> BaseSizeModel.MEDIUM_30x60
        BaseSizeDTO.MEDIUM_50x50 -> BaseSizeModel.MEDIUM_50x50
        BaseSizeDTO.LARGE_50x100 -> BaseSizeModel.LARGE_50x100
        BaseSizeDTO.LARGE_60x100 -> BaseSizeModel.LARGE_60x100
        else -> BaseSizeModel.UNKNOWN
    }