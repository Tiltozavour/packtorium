package com.tiltozavour.packtorium.cookies_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.tiltozavour.packtorium.R
import com.tiltozavour.packtorium.ui.CardCustom
import com.tiltozavour.packtorium.ui.TextWithIcon
import com.tiltozavour.packtorium.ui.TitleAndSubtitle

@Composable
fun AppBar() {
    Row(
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_card))
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                style = MaterialTheme.typography.titleSmall,
                text = stringResource(R.string.date_main_page),
            )
            Text(
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.outline,
                text = stringResource(R.string.main_page_title)
            )
        }
        Box(
            modifier = Modifier
                .size(dimensionResource(R.dimen.size_card))
                .border(
                    width = dimensionResource(R.dimen.border),
                    color = MaterialTheme.colorScheme.outline,
                    shape = MaterialTheme.shapes.extraLarge
                )
                .clip(CircleShape)
                .background(
                    color = MaterialTheme.colorScheme.secondary
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.size(dimensionResource(R.dimen.image_medium)),
                painter = painterResource(R.drawable.crystal_ball),
                contentDescription = "Crystal ball",
            )
        }
    }
}

@Composable
fun CookiesFrame(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
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
                brush = Brush.linearGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.5f),
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CookiesMain(onClick)
        }
    }
}

@Composable
fun CookiesMain(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Image(
        modifier = Modifier
            .size(dimensionResource(R.dimen.extra_size_card))
            .padding(dimensionResource(R.dimen.image_medium)),
        alignment = Alignment.Center,
        painter = painterResource(R.drawable.fortune_cookie),
        contentDescription = "cookies",
    )
    TitleAndSubtitle(
        title = stringResource(R.string.title_crack_cookie),
        subtitle = stringResource(R.string.subtitle_crack_cookie)
    )
    Button(
        modifier = Modifier.padding(dimensionResource(R.dimen.image_medium)),
        onClick = { onClick() }) {
        Text(
            color = MaterialTheme.colorScheme.surfaceBright,
            style = MaterialTheme.typography.labelSmall,
            text = stringResource(R.string.button_crack_cookie)
        )
    }
}

@Composable
fun Notification() {
    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(dimensionResource(R.dimen.padding_small))
            .border(
                width = dimensionResource(R.dimen.border),
                color = MaterialTheme.colorScheme.surface,
                shape = MaterialTheme.shapes.medium
            )
            .clip(RoundedCornerShape(dimensionResource(R.dimen.padding_small_extra)))
            .background(color = MaterialTheme.colorScheme.surface.copy(alpha = 0.3f))
            .padding(dimensionResource(R.dimen.padding_small_extra)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        TextWithIcon(
            title = stringResource(R.string.notification_cookie, "2"),
            subtitle = stringResource(R.string.notification_cookie_subtitle),
            painter = R.drawable.open_mailbox
        )
        Badge(
            modifier = Modifier.size(dimensionResource(R.dimen.padding_card_extra)),
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            contentColor = MaterialTheme.colorScheme.surface
        ) {
            Text(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.surfaceBright,
                style = MaterialTheme.typography.bodyMedium,
                text = "2" //hardcore
            )
        }

    }
}

@Composable
fun SendAndCollection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CardCustom(
            modifier = Modifier.weight(1f),
            colorFirst = MaterialTheme.colorScheme.onSecondary,
            colorSecond = MaterialTheme.colorScheme.primary,
            borderColor = MaterialTheme.colorScheme.onSecondary,
            icon = R.drawable.rocket,
            title = stringResource(R.string.send_cookies_title),
            subtitle = stringResource(R.string.send_cookies_subtitle)
        )
        CardCustom(
            modifier = Modifier.weight(1f),
            colorFirst = MaterialTheme.colorScheme.onSecondary,
            colorSecond = MaterialTheme.colorScheme.primary,
            borderColor = MaterialTheme.colorScheme.onSecondary,
            icon = R.drawable.stars,
            title = stringResource(R.string.collection_title),
            subtitle = stringResource(R.string.collection_subtitle)
        )
    }

}

data class Star(
    val x: Float,
    val y: Float,
    val radius: Float,
)