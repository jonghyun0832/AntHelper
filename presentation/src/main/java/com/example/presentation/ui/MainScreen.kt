package com.example.presentation.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.presentation.navigation.MainNav
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
        bottomBar = { MainNavigationBar(navHostController, currentRoute) }
    ) { innerPadding ->
        MainNavigationScreen(
            mainViewModel = mainViewModel,
            navHostController = navHostController,
            innerPaddings = innerPadding
        )
    }
}

@Composable
fun MainNavigationBar(navHostController: NavHostController, currentRoute: String?) {
    val navigationItems = listOf(
        MainNav.Home,
        MainNav.Fluctuation,
        MainNav.News,
        MainNav.MyPage
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
            route = MainNav.Fluctuation.route
        ) {
            // TODO : Fluctuation Screen
        }

        composable(
            route = MainNav.News.route
        ) {
            // TODO : News Screen
        }

        composable(
            route = MainNav.MyPage.route
        ) {
            // TODO : MyPage Screen
        }
    }
}