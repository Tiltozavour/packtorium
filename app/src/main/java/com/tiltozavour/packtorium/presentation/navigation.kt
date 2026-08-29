package com.tiltozavour.packtorium.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tiltozavour.packtorium.data.repositoryImpl.PredictionRepositoryImpl
import com.tiltozavour.packtorium.presentation.cookies_screen.CookiesMainScreen
import com.tiltozavour.packtorium.presentation.cookies_screen.CookiesScViewModel
import com.tiltozavour.packtorium.presentation.prediction_screen.PredictionScreens
import com.tiltozavour.packtorium.presentation.prediction_screen.PredictionViewModel

enum class CookiesScreens() {
    Main,
    Prediction,
    Notification,
    Send,
    Collection
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CookiesScreen(
    viewModelCookies: CookiesScViewModel = CookiesScViewModel(
        repository = PredictionRepositoryImpl(),
    ), //Todo DI,
    navController: NavHostController = rememberNavController(),
    viewModelPredict: PredictionViewModel = PredictionViewModel(repository = PredictionRepositoryImpl()),
) {
    Scaffold() { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = CookiesScreens.Main.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(route = CookiesScreens.Main.name) {
                CookiesMainScreen(
                    viewModel = viewModelCookies,
                    onClickPrediction = {
                        navController.navigate(CookiesScreens.Prediction.name)
                    },
                    modifier = Modifier
                )
            }
            composable(route = CookiesScreens.Prediction.name) {
                PredictionScreens(
                    onClickBack = {
                        navController.popBackStack(
                            CookiesScreens.Main.name,
                            inclusive = false
                        )
                    },
                    viewModel = viewModelPredict
                )
            }
            composable(route = CookiesScreens.Notification.name) {}
            composable(route = CookiesScreens.Send.name) {}
            composable(route = CookiesScreens.Collection.name) {}
        }
    }
}