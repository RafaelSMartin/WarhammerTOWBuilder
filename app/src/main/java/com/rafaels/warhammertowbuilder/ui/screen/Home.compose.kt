package com.rafaels.warhammertowbuilder.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.rafaels.warhammertowbuilder.ui.MainViewModel
import com.rafaels.warhammertowbuilder.ui.navigation.AppScreens
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController, mainViewModel: MainViewModel = koinViewModel()) {
    val uiState by mainViewModel.uiUnitState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Home")
                }
            )
        },
        content = { paddingValues ->
            BodyContent(navController, paddingValues)
        }
    )
}

@Composable
private fun BodyContent(navController: NavController, paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = { navController.navigate(route = AppScreens.UnitScreen.route) }) {
            Text(text = "Units")
        }

        Button(onClick = { navController.navigate(route = AppScreens.ElvenHonourScreen.route) }) {
            Text(text = "Elven Honours")
        }
    }
}


@Preview
@Composable
fun DefaultPreview() {
    //Home()
}
