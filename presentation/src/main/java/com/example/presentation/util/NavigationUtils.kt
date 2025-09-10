package com.example.presentation.util

import androidx.navigation.NavHostController
import com.example.presentation.navigation.Destination
import com.example.presentation.navigation.MainNav
import com.example.presentation.navigation.NavigationRouteName

object NavigationUtils {
    fun navigate(
        navHostController: NavHostController,
        routeName: String,
        backStackRouteName: String? = null,
        isLaunchSingleTop: Boolean = true,
        needToRestoreState: Boolean = true
    ) {
        navHostController.navigate(routeName) {
            if (backStackRouteName != null) {
                popUpTo(backStackRouteName) { saveState = true }
            }
            launchSingleTop = isLaunchSingleTop
            restoreState = needToRestoreState
        }
    }

    fun findDestination(route: String?) : Destination {
        return when(route) {
            NavigationRouteName.MAIN_HOME -> MainNav.Home
            NavigationRouteName.MAIN_EXCHANGE -> MainNav.Fluctuation
            NavigationRouteName.MAIN_CHANNEL -> MainNav.Channel
            NavigationRouteName.MAIN_NEWS -> MainNav.News
            else -> MainNav.Home
        }
    }
}