package com.tiltozavour.packtorium.presentation.cookies_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tiltozavour.packtorium.domain.repository.PredictionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class CookiesScViewModel(
    private val repository: PredictionRepository,
) : ViewModel() {

    private val _uiCookiesState = MutableStateFlow(CookieUiState())
    val uiCookiesState = _uiCookiesState.asStateFlow()

    init {
        getQuota()
    }

    private fun getQuota() { //todo для сетевых данных в будущем
        viewModelScope.launch {
            try {
                val quota = repository.getQuota()
                _uiCookiesState.update {
                    it.copy(
                        quota = quota,
                        currentScreenState = CookieScreenState.Main
                    )
                }
            } catch (e: Exception) {
                _uiCookiesState.update {
                    it.copy(
                        currentScreenState = CookieScreenState.Error
                    )
                }
            }
        }
    }


}