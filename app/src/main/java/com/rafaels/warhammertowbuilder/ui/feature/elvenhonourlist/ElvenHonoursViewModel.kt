package com.rafaels.warhammertowbuilder.ui.feature.elvenhonourlist

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ElvenHonoursViewModel() : ViewModel() {
    private val _uiElvenHonourState = MutableStateFlow(ElvenHonourUiState())
    val uiElvenHonourState: StateFlow<ElvenHonourUiState> = _uiElvenHonourState.asStateFlow()

    init {

    }
}