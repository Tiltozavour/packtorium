package com.tiltozavour.packtorium.cookies_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class CookiesScViewModel : ViewModel() {

    private val _uiCookiesState = MutableStateFlow<CookieUiState>(CookieUiState.isMain)
    val uiCookiesState = _uiCookiesState.asStateFlow()

    init {
        getPrediction()
    }

    private fun getPrediction() {
        viewModelScope.launch {
            //получение информации с бэка
        }
    }


}