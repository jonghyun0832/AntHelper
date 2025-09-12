package com.example.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.SsidChart
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.example.presentation.model.ChartUiModel
import com.example.presentation.util.GsonUtils

sealed class MainNav(
    override val route: String,
    override val title: String,
    override val deepLinks: List<NavDeepLink> = listOf(navDeepLink {
        uriPattern = "${NavigationRouteName.DEEP_LINK_SCHEME}$route"
    }),
    val icon: ImageVector
) : Destination {
    object Home : MainNav(
        route = NavigationRouteName.MAIN_HOME,
        title = NavigationTitle.MAIN_HOME,
        icon = Icons.Filled.Home
    )

    object Exchange : MainNav(
        route = NavigationRouteName.MAIN_EXCHANGE,
        title = NavigationTitle.MAIN_EXCHANGE,
        icon = Icons.Filled.AttachMoney
    )

    object ChartView : MainNav(
        route = NavigationRouteName.MAIN_CHART_VIEW,
        title = NavigationTitle.MAIN_CHART_VIEW,
        icon = Icons.Filled.SsidChart
    )

    object News : MainNav(
        route = NavigationRouteName.MAIN_NEWS,
        title = NavigationTitle.MAIN_NEWS,
        icon = Icons.Filled.Newspaper
    )

    companion object {
        fun isMainRoute(route: String?): Boolean {
            return when (route) {
                NavigationRouteName.MAIN_HOME, NavigationRouteName.MAIN_EXCHANGE, NavigationRouteName.MAIN_CHART_VIEW, NavigationRouteName.MAIN_NEWS -> true
                else -> false
            }
        }
    }
}

object ChartEnrollNav: DestinationArg<ChartUiModel?> {
    override val route: String = NavigationRouteName.CHART_ENROLL
    override val title: String = NavigationTitle.CHART_ENROLL
    override val deepLinks: List<NavDeepLink> = listOf(
        navDeepLink { uriPattern = "${NavigationRouteName.DEEP_LINK_SCHEME}$route" }
    )
    override val argName: String = "chart"
    override val arguments: List<NamedNavArgument> = listOf(navArgument(argName) {
        type = NavType.StringType
        nullable = true
        defaultValue = null
    })

    override fun navigateWithArg(item: ChartUiModel?): String {
        return if (item == null) {
            route
        } else {
            val arg = GsonUtils.toJson(item)
            "$route/$arg"
        }
    }

    override fun findArgument(navBackStackEntry: NavBackStackEntry): ChartUiModel? {
        val chartString = navBackStackEntry.arguments?.getString(argName)
        return GsonUtils.fromJson<ChartUiModel>(chartString)
    }
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