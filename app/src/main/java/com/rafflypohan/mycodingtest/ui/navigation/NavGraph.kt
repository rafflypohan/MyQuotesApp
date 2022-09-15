package com.rafflypohan.mycodingtest.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.rafflypohan.mycodingtest.ui.features.detail.DetailScreen
import com.rafflypohan.mycodingtest.ui.features.home.HomeScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Destinations.HOME_ROUTE
) {
    val navActions = remember(navController) {
        NavigationActions(navController)
    }

    NavHost(navController = navController, startDestination = startDestination) {
        composable(Destinations.HOME_ROUTE) {
            HomeScreen(navigateTo = navActions::navigate)
        }
        composable(route = "${Destinations.DETAIL_ROUTE}/{${Args.ID}}",
            arguments = listOf(
                navArgument(Args.ID) {
                    type = NavType.StringType
                }
            )
        ) {
            DetailScreen()
        }
    }
}

object Args {
    const val ID = "id"
}