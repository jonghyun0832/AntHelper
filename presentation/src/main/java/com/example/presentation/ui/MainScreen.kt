package com.example.presentation.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.presentation.navigation.ChartEnrollNav
import com.example.presentation.navigation.MainNav
import com.example.presentation.ui.chart.ChartEnrollScreen
import com.example.presentation.ui.chart.ChartViewScreen
import com.example.presentation.ui.home.HomeScreen
import com.example.presentation.util.NavigationUtils
import com.example.presentation.viewmodel.MainViewModel

@Composable
fun MainScreen(

) {
    val mainViewModel: MainViewModel = hiltViewModel<MainViewModel>()
    val navHostController = rememberNavController()
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { MainTopBar(navHostController = navHostController, currentRoute = currentRoute) },
        bottomBar = { MainNavigationBar(navHostController, currentRoute) }
    ) { innerPadding ->
        MainNavigationScreen(
            mainViewModel = mainViewModel,
            navHostController = navHostController,
            innerPaddings = innerPadding
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(navHostController: NavHostController, currentRoute: String?) {
    if (!MainNav.isMainRoute(currentRoute)) {
        TopAppBar(
            title = {
                Text(
                    text = NavigationUtils.findDestination(currentRoute).title,
                    style = MaterialTheme.typography.headlineSmall
                )
            },
            navigationIcon = {
                IconButton(
                    onClick = { navHostController.popBackStack() }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back Icon"
                    )
                }
            }
        )
    } else {
        null
    }
}

@Composable
fun MainNavigationBar(navHostController: NavHostController, currentRoute: String?) {
    val navigationItems = listOf(
        MainNav.Home,
        MainNav.Exchange,
        MainNav.ChartView,
        MainNav.News
    )

    NavigationBar {
        navigationItems.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    NavigationUtils.navigate(
                        navHostController = navHostController,
                        routeName = item.route,
                        backStackRouteName = navHostController.graph.startDestinationRoute
                    )
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(text = item.title)
                }
            )
        }
    }
}

@Composable
fun MainNavigationScreen(
    mainViewModel: MainViewModel,
    navHostController: NavHostController,
    innerPaddings: PaddingValues
) {
    NavHost(
        navController = navHostController,
        startDestination = MainNav.Home.route,
        modifier = Modifier.padding(innerPaddings)
    ) {
        composable(
            route = MainNav.Home.route
        ) {
            HomeScreen()
        }

        composable(
            route = MainNav.Exchange.route
        ) {
            // TODO : Exchange Screen
        }

        composable(
            route = MainNav.ChartView.route
        ) {
            ChartViewScreen(
                navHostController = navHostController
            )
        }

        composable(
            route = ChartEnrollNav.route,
            arguments = ChartEnrollNav.arguments
            ) {
            val chart = ChartEnrollNav.findArgument(it)
            ChartEnrollScreen(
                chart = chart,
                navHostController = navHostController
            )
        }

        composable(
            route = MainNav.News.route
        ) {
            // TODO : News Screen
        }
    }
}