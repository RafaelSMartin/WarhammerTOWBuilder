package com.rafaels.warhammertowbuilder.ui.feature.magicitem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.rafaels.domain.model.MagicItemModel
import com.rafaels.warhammertowbuilder.ui.feature.home.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MagicItemsList(
    navController: NavController,
    //elvenHonoursViewModel: ElvenHonoursViewModel = koinViewModel(),
    homeViewModel: HomeViewModel = koinViewModel()
) {
    val uiState by homeViewModel.uiUnitState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Magic Items")
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
            MagicItems(
                navController = navController,
                paddingValues = paddingValues,
                magicItems = listOf(
                    uiState.magicItems.magicWeapons,
                    uiState.magicItems.magicArmour,
                    uiState.magicItems.magicStandards,
                    uiState.magicItems.talismans,
                    uiState.magicItems.enchantedItems,
                    uiState.magicItems.arcaneItems,
                ).flatten()
            )
        }
    )
}

@Composable
fun MagicItems(
    navController: NavController,
    paddingValues: PaddingValues,
    magicItems: List<MagicItemModel>,
) {
    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        items(magicItems) {
            MagicWeaponItem(it)
        }
    }
}

@Composable
fun MagicWeaponItem(magicItem: MagicItemModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = magicItem.name, textAlign = TextAlign.Start)
            Text(text = magicItem.point.toString() + " points", textAlign = TextAlign.End)
        }
        magicItem.range?.let {
            Text(text = "Rango: " + it)
        }
        magicItem.strength?.let {
            Text(text = "Fuerza: " + it)
        }
        magicItem.armourPenetration?.let {
            Text(text = "AP: " + it)
        }
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        magicItem.notes?.let {
            Text(text = "Notas: " + it)
        }
        magicItem.description?.let {
            Text(text = "Descripción: " + it)
        }

        magicItem.specialRules?.let {
            Column {
                Text(text = "Reglas Especiales")
                it.forEach {
                    Text(text = "Reglas: " + it.rule)
                    Text(text = "Descripcion " + it.description)
                }
            }

        }
        Spacer(modifier = Modifier.padding(bottom = 32.dp))
    }

}