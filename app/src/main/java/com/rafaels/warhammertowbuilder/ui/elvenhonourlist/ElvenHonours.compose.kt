package com.rafaels.warhammertowbuilder.ui.elvenhonourlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ElvenHonoursList(
    navController: NavController,
    elvenHonoursViewModel: ElvenHonoursViewModel = koinViewModel(),
    mainViewModel: MainViewModel = koinViewModel()
) {
    val uiState by mainViewModel.uiUnitState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Elven Honours")
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            )
        },
        content = { paddingValues ->
            ElvenHonours(
                navController = navController,
                paddingValues = paddingValues,
                elvenHonours = uiState.elvenHonours
            )
        }
    )
}

@Composable
fun ElvenHonours(
    elvenHonours: List<ElvenHonourModel>,
    navController: NavController,
    paddingValues: PaddingValues,
) {
    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(paddingValues)
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
            .padding(16.dp)
            .background(Color.Red),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = elvenHonour.honour, textAlign = TextAlign.Start)
        Text(text = elvenHonour.honourPoints.toString(), textAlign = TextAlign.End)
    }
}