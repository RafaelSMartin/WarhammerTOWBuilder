package com.rafaels.warhammertowbuilder.ui.feature.elvenhonourlist

import com.rafaels.domain.model.ElvenHonourModel

data class ElvenHonourUiState(
    val elvenHonours: List<ElvenHonourModel> = emptyList(),
)
