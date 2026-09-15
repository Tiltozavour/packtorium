package com.tiltozavour.packtorium.presentation.cookies_screen

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.tiltozavour.packtorium.presentation.CookiesScreen
import com.tiltozavour.packtorium.presentation.prediction_screen.PredictionViewModel
import com.tiltozavour.packtorium.presentation.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CookiesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme(darkTheme = false) {
                CookiesScreen()
            }
        }
    }
}