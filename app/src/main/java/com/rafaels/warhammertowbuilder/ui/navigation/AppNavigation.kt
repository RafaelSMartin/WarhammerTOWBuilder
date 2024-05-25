package com.rafaels.warhammertowbuilder.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.rafaels.warhammertowbuilder.ui.feature.elvenarmour.ElvenArmourList
import com.rafaels.warhammertowbuilder.ui.feature.elvenhonourlist.ElvenHonoursList
import com.rafaels.warhammertowbuilder.ui.feature.home.Home
import com.rafaels.warhammertowbuilder.ui.feature.magicitem.MagicItemsList
import com.rafaels.warhammertowbuilder.ui.feature.unitItem.ArmyList

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.HomeScreen.route) {
        composable(route = AppScreens.HomeScreen.route) {
            Home(navController)
        }
        composable(
            route = AppScreens.UnitScreen.route + "/{text}",
            arguments = listOf(navArgument(name = "text") {
                type = NavType.StringType
            })
        ) {
            ArmyList(navController, it.arguments?.getString("text"))
        }
        composable(route = AppScreens.ElvenHonourScreen.route) {
            ElvenHonoursList(navController)
        }
        composable(route = AppScreens.ElvenArmouryScreen.route) {
            ElvenArmourList(navController)
        }
        composable(route = AppScreens.MagicItemsScreen.route) {
            MagicItemsList(navController)
        }

    }
}