package com.rafaels.warhammertowbuilder.ui.elvenhonourlist

import com.rafaels.domain.model.ElvenHonourModel

data class ElvenHonourUiState(
    val elvenHonours: List<ElvenHonourModel> = emptyList(),
)
