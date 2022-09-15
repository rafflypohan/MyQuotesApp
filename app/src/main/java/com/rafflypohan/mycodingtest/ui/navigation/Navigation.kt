package com.rafflypohan.mycodingtest.ui.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

object Destinations {
    const val HOME_ROUTE = "home"
    const val DETAIL_ROUTE = "detail"
}

class NavigationActions(private val navHostController: NavHostController){
    fun navigate(dest: String){
        navHostController.navigate(dest){
            popUpTo(navHostController.graph.findStartDestination().id){
//                inclusive = true
//                saveState = true
            }
            launchSingleTop = true
//            restoreState = true
        }
    }
}