package com.example.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.SsidChart
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.navDeepLink

sealed class MainNav(
    override val route: String,
    override val title: String,
    override val deepLinks: List<NavDeepLink> = listOf(navDeepLink { uriPattern = "${NavigationRouteName.DEEP_LINK_SCHEME}$route" }),
    val icon: ImageVector
) : Destination {
    object Home : MainNav(
        route = NavigationRouteName.MAIN_HOME,
        title = NavigationTitle.MAIN_HOME,
        icon = Icons.Filled.Home
    )

    object Fluctuation : MainNav(
        route = NavigationRouteName.MAIN_FLUCTUATION,
        title = NavigationTitle.MAIN_FLUCTUATION,
        icon = Icons.Filled.SsidChart
    )

    object News : MainNav(
        route = NavigationRouteName.MAIN_NEWS,
        title = NavigationTitle.MAIN_NEWS,
        icon = Icons.Filled.Newspaper
    )

    object MyPage : MainNav(
        route = NavigationRouteName.MAIN_MY_INFO,
        title = NavigationTitle.MAIN_MY_INFO,
        icon = Icons.Filled.AccountBox
    )
}

interface Destination {
    val route: String
    val title: String
    val deepLinks: List<NavDeepLink>
}

interface DestinationArg<T> : Destination {
    val argName: String
    val arguments: List<NamedNavArgument>

    fun routeWithArgName() = "$route/{$argName}"
    fun navigateWithArg(item: T): String
    fun findArgument(navBackStackEntry: NavBackStackEntry): T?
}