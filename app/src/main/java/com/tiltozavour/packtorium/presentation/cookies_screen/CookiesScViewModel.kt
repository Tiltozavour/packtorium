package com.tiltozavour.packtorium.presentation.cookies_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tiltozavour.packtorium.data.ResultWrapper
import com.tiltozavour.packtorium.domain.repository.PredictionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class CookiesScViewModel(
    private val repository: PredictionRepository, //todo DI
) : ViewModel() {

    private val _uiCookiesState = MutableStateFlow(CookieUiState())
    val uiCookiesState = _uiCookiesState.asStateFlow()

    init {
        getQuota()
    }

    private fun getQuota() {
        viewModelScope.launch {
            when (val res = repository.getQuota()) {
                is ResultWrapper.Success -> {
                    _uiCookiesState.update {
                        it.copy(
                            quota = res.data,
                            currentScreenState = CookieScreenState.Main
                        )
                    }
                }
                is ResultWrapper.Error -> stateError()
            }
        }
    }

    private fun stateError() {
        _uiCookiesState.update {
            it.copy(
                currentScreenState = CookieScreenState.Error
            )
        }
    }

}