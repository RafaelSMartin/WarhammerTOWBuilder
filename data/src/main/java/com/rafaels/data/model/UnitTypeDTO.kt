package com.rafaels.data.model

enum class UnitTypeDTO(val value: String) {
    CHARACTERS("characters"),   //Max 50%
    CORE("core"),               //At least 25%
    SPECIAL("special"),         //Max 50%
    RARE("rare"),               //Max 25%
    MERCENARIES("mercenaries"), //Max 20%
    ALLIES("allies"),           //Max 25%
}