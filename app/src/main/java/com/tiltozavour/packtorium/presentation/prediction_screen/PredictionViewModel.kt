package com.tiltozavour.packtorium.presentation.prediction_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tiltozavour.packtorium.domain.repository.PredictionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class PredictionViewModel(private val repository: PredictionRepository) : ViewModel() {


    private val _uiPredictState = MutableStateFlow(PredictionUiState())
    val uiPredictState = _uiPredictState.asStateFlow()

    init {
        getPrediction()
    }

    private fun getPrediction() { //todo для сетевых данных в будущем
        viewModelScope.launch {
            try {
                val predict = repository.getPrediction()
                _uiPredictState.update {
                    it.copy(
                        prediction = predict,
                        currentScreenState = PredictionScreenState.PredictionClosed
                    )
                }
            } catch (e: Exception) {
                _uiPredictState.update {
                    it.copy(
                        currentScreenState = PredictionScreenState.Error
                    )
                }
            }
        }
    }

    internal fun clickCrack() {
        _uiPredictState.update {
            it.copy(
                currentScreenState = PredictionScreenState.PredictionOpen
            )
        }
    }

}