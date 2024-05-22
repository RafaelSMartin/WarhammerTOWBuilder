package com.rafaels.warhammertowbuilder.ui.feature.home

import com.rafaels.domain.model.ElvenHonourModel
import com.rafaels.domain.model.SpecialRuleModel
import com.rafaels.domain.model.UnitModel

data class HomeUiState(
    val units: List<UnitModel> = emptyList(),
    val specialRules: List<SpecialRuleModel> = emptyList(),
    val elvenHonours: List<ElvenHonourModel> = emptyList(),
)