package com.rafaels.warhammertowbuilder.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rafaels.warhammertowbuilder.ui.unitItem.UnitItemColumn
import com.rafaels.warhammertowbuilder.ui.theme.WarhammerTOWBuilderTheme
import org.koin.androidx.compose.KoinAndroidContext
import org.koin.androidx.compose.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

class MainActivity : ComponentActivity() {


    @OptIn(KoinExperimentalAPI::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WarhammerTOWBuilderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    KoinAndroidContext() {
                        ArmyList()
                    }

                }
            }
        }
    }
}

@Composable
fun ArmyList(mainViewModel: MainViewModel = koinViewModel()) {
    val uiState by mainViewModel.uiUnitState.collectAsState()
    Column {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Elven Honours")
        }
        UnitItemColumn(uiState.units)
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WarhammerTOWBuilderTheme {
        ArmyList()
    }
}