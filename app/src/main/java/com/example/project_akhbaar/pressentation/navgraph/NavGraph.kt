package com.example.project_akhbaar.pressentation.navgraph

import android.content.res.Configuration
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.project_akhbaar.domain.usecases.news.GetNews
import com.example.project_akhbaar.domain.usecases.news.NewsUseCases
import com.example.project_akhbaar.pressentation.common.SearchBar
import com.example.project_akhbaar.pressentation.home.HomeScreen
import com.example.project_akhbaar.pressentation.home.HomeViewModel
import com.example.project_akhbaar.pressentation.onboarding.OnBoardingScreen
import com.example.project_akhbaar.pressentation.onboarding.components.OnBoardingViewModel
import com.example.project_akhbaar.pressentation.search.SearchScreen
import com.example.project_akhbaar.pressentation.search.SearchViewModel
import com.example.project_akhbaar.ui.theme.ProjectAkhbaarTheme
import kotlinx.coroutines.flow.collect

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
            startDestination = Route.HomeScreen.route
        ) {
            composable(route = Route.HomeScreen.route) {
                val homeViewModel: HomeViewModel = hiltViewModel()
                val articles = homeViewModel.news.collectAsLazyPagingItems()
                HomeScreen(articles = articles, navigate = { navController.navigate(Route.SearchScreen.route) })
            }

            composable(route = Route.SearchScreen.route) {
                val viewModel: SearchViewModel = hiltViewModel()
                SearchScreen(state = viewModel.state.value, event = viewModel::onEvent)
            }
        }

    }
}

