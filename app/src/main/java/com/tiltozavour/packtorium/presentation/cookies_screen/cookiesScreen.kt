package com.tiltozavour.packtorium.presentation.cookies_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tiltozavour.packtorium.R
import com.tiltozavour.packtorium.presentation.ui.BottomBar
import com.tiltozavour.packtorium.presentation.ui.Stars


@Composable
internal fun CookiesMainScreen(
    viewModel: CookiesScViewModel,
    onClickPrediction: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val uiState by viewModel.uiCookiesState.collectAsStateWithLifecycle()
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.scrim,
                contentPadding = PaddingValues(horizontal = dimensionResource(R.dimen.padding_medium)),
                actions = {
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        BottomBar(R.drawable.crystal_ball)
                        BottomBar(R.drawable.open_mailbox)
                        BottomBar(R.drawable.cookies)
                        BottomBar(R.drawable.stars)
                    }

                }
            )
        }
    )
    { innerPadding ->
        val brushx = 350 / 0.5f
        val brushy = 900 / 0.5f
        val radius = 100 / 0.3f
        Box(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(

                    brush = Brush.radialGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.onPrimary,
                            MaterialTheme.colorScheme.background
                        ),
                        center = Offset(brushx, brushy),
                        radius = radius,
                        tileMode = TileMode.Clamp
                    )
                )
        ) {
            Stars()
            Column(
                modifier = modifier.padding(dimensionResource(R.dimen.padding_small_extra)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppBar()
                CookiesFrame(onClickPrediction)
                Notification()
                SendAndCollection()
                HorizontalDivider(
                    modifier = modifier.padding(
                        horizontal = dimensionResource(R.dimen.padding_small_extra),
                        vertical = dimensionResource(R.dimen.padding_card)
                    ),
                    color = MaterialTheme.colorScheme.onSecondary,
                    thickness = dimensionResource(R.dimen.border)
                )
                Text(
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = uiState.quota.quotaDay
                )
            }

        }
    }
}


