package com.tiltozavour.packtorium.presentation.cookies_screen

import androidx.compose.runtime.Immutable
import com.tiltozavour.packtorium.domain.entity.Quota

@Immutable
internal data class CookieUiState(
    val quota: Quota = Quota(
        quota = ""
    ),
    val currentScreenState: CookieScreenState = CookieScreenState.IsLoading,
)

internal enum class CookieScreenState {
    IsLoading, Main, Error, Toast
}

