package com.rafaels.warhammertowbuilder.ui

import com.rafaels.domain.model.UnitModel

data class MainUiState(
    val units: List<UnitModel> = emptyList()
)