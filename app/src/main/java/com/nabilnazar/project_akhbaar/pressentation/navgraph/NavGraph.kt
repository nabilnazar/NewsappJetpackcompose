package com.nabilnazar.project_akhbaar.pressentation.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.paging.compose.collectAsLazyPagingItems
import com.nabilnazar.project_akhbaar.pressentation.details.DetailsScreen
import com.nabilnazar.project_akhbaar.pressentation.home.HomeScreen
import com.nabilnazar.project_akhbaar.pressentation.home.HomeViewModel
import com.nabilnazar.project_akhbaar.pressentation.news_navigator.NewsNavigator
import com.nabilnazar.project_akhbaar.pressentation.onboarding.OnBoardingScreen
import com.nabilnazar.project_akhbaar.pressentation.onboarding.components.OnBoardingViewModel
import com.nabilnazar.project_akhbaar.pressentation.search.SearchScreen
import com.nabilnazar.project_akhbaar.pressentation.search.SearchViewModel

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(route = Route.OnBoardingScreen.route) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(onEvent = viewModel::onEvent)
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ) {
            composable(route = Route.NewsNavigatorScreen.route){
                NewsNavigator()
            }
        }
    }
}