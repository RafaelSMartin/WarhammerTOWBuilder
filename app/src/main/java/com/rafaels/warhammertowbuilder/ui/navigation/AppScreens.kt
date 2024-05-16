package com.rafaels.warhammertowbuilder.ui.navigation

sealed class AppScreens(val route: String) {
    object MainScreen : AppScreens("main_screen")
    object UnitScreen : AppScreens("unit_screen")
    object ElvenHonourScreen : AppScreens("elven_honour_screen")
}