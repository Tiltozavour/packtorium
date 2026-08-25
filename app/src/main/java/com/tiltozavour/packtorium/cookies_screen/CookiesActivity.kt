package com.tiltozavour.packtorium.cookies_screen

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tiltozavour.packtorium.R
import com.tiltozavour.packtorium.ui.theme.AppTheme

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