package com.tiltozavour.packtorium

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
import com.tiltozavour.packtorium.cookies_screen.CookiesMainScreen
import com.tiltozavour.packtorium.prediction_screen.PredictionScreens

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
    navController: NavHostController = rememberNavController(),
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
                    onClickPrediction = {
                        navController.navigate(CookiesScreens.Prediction.name)
                    }
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
                    onClickCrack = {}
                )
            }
            composable(route = CookiesScreens.Notification.name) {}
            composable(route = CookiesScreens.Send.name) {}
            composable(route = CookiesScreens.Collection.name) {}
        }
    }
}