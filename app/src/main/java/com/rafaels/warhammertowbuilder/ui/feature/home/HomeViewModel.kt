package com.rafaels.warhammertowbuilder.ui.feature.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaels.domain.Resource
import com.rafaels.domain.usecase.GetUnit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getUnit: GetUnit,
) : ViewModel() {

    private val _uiUnitState = MutableStateFlow(HomeUiState())
    val uiUnitState: StateFlow<HomeUiState> = _uiUnitState.asStateFlow()

    init {
        getUnit()
    }

    private fun getUnit() {
        viewModelScope.launch {
            val result = getUnit.getUnit()
            when (result) {
                is Resource.Success -> {
                    _uiUnitState.value = HomeUiState(
                        units = result.data.unitModels,
                        specialRules = result.data.specialRuleModel,
                        elvenHonours = result.data.elvenHonours,
                        elvenArmoury = result.data.elvenArmoury,
                        magicItems = result.data.magicItems,
                    )
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