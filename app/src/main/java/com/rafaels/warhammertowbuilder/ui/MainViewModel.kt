package com.rafaels.warhammertowbuilder.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaels.domain.usecase.GetUnit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    val getUnit: GetUnit,
): ViewModel() {

    private val _uiUnitState = MutableStateFlow(MainUiState())
    val uiUnitState: StateFlow<MainUiState> = _uiUnitState.asStateFlow()

    init {
        getUnit()
    }

    private fun getUnit() {
        viewModelScope.launch {
            val result = getUnit.getUnit()
            _uiUnitState.value = MainUiState(name = result.name)
        }
    }
}