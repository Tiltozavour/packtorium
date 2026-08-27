package com.tiltozavour.packtorium.prediction_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.tiltozavour.packtorium.R
import com.tiltozavour.packtorium.ui.Stars
import com.tiltozavour.packtorium.ui.TextWithIconBack
import com.tiltozavour.packtorium.ui.theme.AppTheme

@Composable
fun PredictionScreens(
    modifier: Modifier = Modifier,
    onClickCrack: () -> Unit,
    onClickBack: () -> Unit,
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        topBar = {
            TextWithIconBack(
                onClickBack = onClickBack,
                modifier = modifier
                    .padding(dimensionResource(R.dimen.padding_medium_extra)))
        }
    ) { innerPadding ->
        Stars()
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize()
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
                onClick = { onClickCrack() }) {
                Text(
                    color = MaterialTheme.colorScheme.surfaceBright,
                    style = MaterialTheme.typography.labelSmall,
                    text = stringResource(R.string.button_cookie)
                )
            }
        }
    }
}


@Composable
@Preview
fun PredictionPreview() {
    AppTheme(darkTheme = false) {
        PredictionScreens(onClickBack = {}, onClickCrack = {})
    }
}