package com.rafaels.warhammertowbuilder.ui.navigation

sealed class AppScreens(val route: String) {
    data object HomeScreen : AppScreens("main_screen")
    data object UnitScreen : AppScreens("unit_screen")
    data object ElvenHonourScreen : AppScreens("elven_honour_screen")
}