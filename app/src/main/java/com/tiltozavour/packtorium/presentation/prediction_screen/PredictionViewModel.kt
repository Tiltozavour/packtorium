package com.tiltozavour.packtorium.presentation.prediction_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tiltozavour.packtorium.data.ResultWrapper
import com.tiltozavour.packtorium.domain.repository.PredictionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
internal class PredictionViewModel @Inject constructor(private val repository: PredictionRepository) : ViewModel() {


    private val _uiPredictState = MutableStateFlow(PredictionUiState())
    val uiPredictState = _uiPredictState.asStateFlow()

    init {
        getPrediction()
    }

    private fun getPrediction() {
        viewModelScope.launch {
            when (val predict = repository.getPrediction()) {
                is ResultWrapper.Success -> {
                    _uiPredictState.update {
                        it.copy(
                            prediction = predict.data,
                            currentScreenState = PredictionScreenState.PredictionClosed
                        )
                    }
                }

                is ResultWrapper.Error -> errorState()
            }
        }
    }

    private fun errorState() {
        _uiPredictState.update {
            it.copy(
                currentScreenState = PredictionScreenState.Error
            )
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