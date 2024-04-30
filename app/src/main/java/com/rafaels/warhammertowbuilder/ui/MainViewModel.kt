package com.rafaels.warhammertowbuilder.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaels.domain.Resource
import com.rafaels.domain.usecase.GetUnit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val getUnit: GetUnit,
): ViewModel() {

    private val _uiUnitState = MutableStateFlow(MainUiState())
    val uiUnitState: StateFlow<MainUiState> = _uiUnitState.asStateFlow()

    init {
        getUnit()
    }

    private fun getUnit() {
        viewModelScope.launch {
            val result = getUnit.getUnit()
            when(result) {
                is Resource.Success -> {
                    _uiUnitState.value = MainUiState(units = result.data.unitModels)
                    Log.d("MainViewModel", "Resource.Success")
                }

                is Resource.Error -> {
                    //showError(result.error)
                    Log.d("MainViewModel", "Resource.Error")
                }
            }
        }
    }



}