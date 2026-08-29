package com.tiltozavour.packtorium.presentation.cookies_screen

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.tiltozavour.packtorium.presentation.CookiesScreen
import com.tiltozavour.packtorium.presentation.ui.theme.AppTheme

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