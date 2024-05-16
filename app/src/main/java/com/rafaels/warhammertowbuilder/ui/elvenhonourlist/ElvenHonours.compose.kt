package com.rafaels.warhammertowbuilder.ui.elvenhonourlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.rafaels.domain.model.ElvenHonourModel
import com.rafaels.warhammertowbuilder.ui.MainViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun ElvenHonoursList(
    navController: NavController,
    elvenHonoursViewModel: ElvenHonoursViewModel = koinViewModel(),
    mainViewModel: MainViewModel = koinViewModel()
) {
    val uiState by mainViewModel.uiUnitState.collectAsState()
    Column {
        Text(text = "Elven Honours")
        ElvenHonours(uiState.elvenHonours)
    }
}

@Composable
fun ElvenHonours(
    elvenHonours: List<ElvenHonourModel>,
) {
    LazyColumn(
        Modifier.padding(16.dp)
    ) {
        items(elvenHonours) {
            UnitHonour(it)
        }
    }
}

@Composable
fun UnitHonour(elvenHonour: ElvenHonourModel) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color.Red),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = elvenHonour.honour, textAlign = TextAlign.Start)
        Text(text = elvenHonour.honourPoints.toString(), textAlign = TextAlign.End)
    }
}