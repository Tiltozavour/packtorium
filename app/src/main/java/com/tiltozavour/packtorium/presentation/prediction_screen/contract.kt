package com.tiltozavour.packtorium.presentation.prediction_screen


import androidx.compose.runtime.Immutable
import com.tiltozavour.packtorium.domain.entity.Prediction

@Immutable
internal data class PredictionUiState(
    val prediction: Prediction = Prediction(
        textPrediction = "",
        imageUrl = "",
        fromWho = "",
        date = "",
        userPrediction = false
    ),
    val currentScreenState: PredictionScreenState = PredictionScreenState.IsLoading,
)

internal enum class PredictionScreenState {
    IsLoading, PredictionClosed, PredictionOpen,  Error
}

