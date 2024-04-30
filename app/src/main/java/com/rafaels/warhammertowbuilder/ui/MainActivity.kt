package com.rafaels.warhammertowbuilder.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
                    KoinAndroidContext(){
                        ArmyList()
                    }

                }
            }
        }
    }
}

@Composable
fun ArmyList(
    modifier: Modifier = Modifier,
             mainViewModel: MainViewModel = koinViewModel(),
){
    val uiState by mainViewModel.uiUnitState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        uiState.units.forEach {
            Text(
                text = it.unitName,
                modifier = modifier
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WarhammerTOWBuilderTheme {
        ArmyList()
    }
}