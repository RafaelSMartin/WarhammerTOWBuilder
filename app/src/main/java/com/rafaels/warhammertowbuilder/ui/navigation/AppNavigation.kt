package com.rafaels.warhammertowbuilder.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rafaels.warhammertowbuilder.ui.elvenhonourlist.ElvenHonoursList
import com.rafaels.warhammertowbuilder.ui.screen.Home
import com.rafaels.warhammertowbuilder.ui.unitItem.ArmyList

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.MainScreen.route) {
        composable(route = AppScreens.MainScreen.route) {
            Home(navController)
        }
        composable(route = AppScreens.UnitScreen.route) {
            ArmyList(navController)
        }
        composable(route = AppScreens.ElvenHonourScreen.route) {
            ElvenHonoursList(navController)
        }

    }
}