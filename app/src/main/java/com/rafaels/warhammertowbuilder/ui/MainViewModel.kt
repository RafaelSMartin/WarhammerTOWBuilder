package com.rafaels.warhammertowbuilder.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaels.domain.Resource
import com.rafaels.domain.model.UnitModels
import com.rafaels.domain.usecase.GetUnit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.StringBuilder

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
                    createItems(result.data)
                    Log.d("MainViewModel", "Resource.Success")
                }

                is Resource.Error -> {
                    //showError(result.error)
                    Log.d("MainViewModel", "Resource.Error")
                }
            }
        }
    }

    private fun createItems(items: UnitModels){
        items.let {
            var nameList = ""
            it.unitModels.forEach{
                nameList += StringBuilder()
                    .append(it.unitName)
                    .append("\n")
                    .append(it.unitType)
                    .append("\n")
                    .append(it.otherModelInfo.troopType.value)
                    .append("\n")
                    .append(it.otherModelInfo.baseSize.value)
                    .append("\n")
                    .append(it.otherModelInfo.unitSize)
                    .append("\n\n")
                    .toString()
            }
            _uiUnitState.value = MainUiState(name = nameList)
        }
    }

}