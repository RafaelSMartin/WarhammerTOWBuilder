package com.rafaels.warhammertowbuilder.ui.feature.home

import com.rafaels.domain.model.ElvenHonourModel
import com.rafaels.domain.model.MagicItemModel
import com.rafaels.domain.model.MagicItemsModel
import com.rafaels.domain.model.SpecialRuleModel
import com.rafaels.domain.model.UnitModel

data class HomeUiState(
    val units: List<UnitModel> = emptyList(),
    val specialRules: List<SpecialRuleModel> = emptyList(),
    val elvenHonours: List<ElvenHonourModel> = emptyList(),
    val elvenArmoury: List<MagicItemModel> = emptyList(),
    val magicItems: MagicItemsModel = MagicItemsModel(
        emptyList(),
        emptyList(),
        emptyList(),
        emptyList(),
        emptyList(),
        emptyList()
    ),
)