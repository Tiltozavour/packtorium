package com.tiltozavour.packtorium.presentation.prediction_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tiltozavour.packtorium.R
import com.tiltozavour.packtorium.presentation.ui.CircularIndicator
import com.tiltozavour.packtorium.presentation.ui.CookieDivider
import com.tiltozavour.packtorium.presentation.ui.Stars
import com.tiltozavour.packtorium.presentation.ui.TextWithIconBack
import com.tiltozavour.packtorium.presentation.ui.theme.AppTheme
import kotlinx.coroutines.launch

@Composable
internal fun PredictionScreens(
    viewModel: PredictionViewModel,
    onClickBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val uiState by viewModel.uiPredictState.collectAsStateWithLifecycle()
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        topBar = {
            TextWithIconBack(
                onClickBack = onClickBack,
                modifier = modifier
                    .padding(dimensionResource(R.dimen.padding_medium_extra))
            )
        }
    ) { innerPadding ->
        Stars()
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(innerPadding)
                .padding(14.dp)
                .fillMaxSize()
        ) {
            when (uiState.currentScreenState) {
                PredictionScreenState.IsLoading -> CircularIndicator()
                PredictionScreenState.PredictionClosed -> ClosedCookie(viewModel::clickCrack)
                PredictionScreenState.PredictionOpen -> OpenedCookie(uiState.prediction.textPrediction)
                PredictionScreenState.Error -> {
                    // snackbarHostState.showSnackbar("Snackbar")
                }
            }

        }
    }
}

@Composable
private fun ClosedCookie(
   onClickCrack: () -> Unit
) {
    Text(
        text = stringResource(R.string.tap_cookie_title),
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        style = MaterialTheme.typography.bodyMedium
    )
    Image(
        modifier = Modifier
            .size(dimensionResource(R.dimen.extra_size_image))
            .padding(dimensionResource(R.dimen.padding_medium)),
        painter = painterResource(R.drawable.fortune_cookie),
        contentDescription = "mailbox_icon",
    )

    Button(
        onClick = { onClickCrack()}) {
        Text(
            color = MaterialTheme.colorScheme.surfaceBright,
            style = MaterialTheme.typography.labelSmall,
            text = stringResource(R.string.button_cookie)
        )
    }
}


@Composable
private fun OpenedCookie(prediction: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.padding_small))
            .border(
                width = dimensionResource(R.dimen.border),
                color = MaterialTheme.colorScheme.onSecondary,
                shape = MaterialTheme.shapes.large
            )
            .clip(RoundedCornerShape(dimensionResource(R.dimen.padding_medium_extra)))
            .background(
                brush = Brush.radialGradient(
                    radius = 500f,
                    colors = listOf(
                        MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.5f),
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
                    )
                )
            )
    ) {
        CookieDivider()
        Text(
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.outlineVariant,
            fontStyle = FontStyle.Italic,
            text = prediction
        )
        CookieDivider()
    }
}


@SuppressLint("ViewModelConstructorInComposable")
@Composable
@Preview
fun PredictionPreview() {
    AppTheme(darkTheme = false) {
        OpenedCookie(prediction = "Text ex")
    }
}