package com.tiltozavour.packtorium.cookies_screen

sealed interface CookieUiState {
    object isMain: CookieUiState
    object isCookiesPrediction: CookieUiState

}

data class Prediction(
    val textPrediction: String,
    val imageUrl: String,
    val fromWho: String ,
    val date: String
)
