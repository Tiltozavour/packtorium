package com.tiltozavour.packtorium.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tiltozavour.packtorium.R
import com.tiltozavour.packtorium.cookies_screen.Star
import kotlin.random.Random


@Composable
internal fun Stars(modifier: Modifier = Modifier) {
    val stars = remember {
        List(30) {
            Star(
                x = Random.nextFloat(),
                y = Random.nextFloat(),
                radius = Random.nextFloat()
            )
        }
    }
    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {
        stars.forEach { star ->
            val radius = (0.5.dp.toPx()) + star.radius * (2.dp.toPx() - 0.5.dp.toPx())
            drawCircle(
                alpha = 0.5f,
                color = Color.White,
                radius = radius,
                center = Offset(
                    x = star.x * size.width,
                    y = star.y * size.height
                )
            )
        }
    }
}

@Composable
internal fun TitleAndSubtitle(title: String, subtitle: String) {
    Column(horizontalAlignment = Alignment.Start) {
        Text(
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.surfaceVariant,
            text = title
        )
        Text(
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            text = subtitle
        )

    }
}

@Composable
internal fun TitleAndSubtitleBody(title: String, subtitle: String) {
    Column(horizontalAlignment = Alignment.Start) {
        Text(
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.surfaceVariant,
            fontWeight = FontWeight.Bold,
            text = title
        )
        Text(
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            text = subtitle
        )

    }
}

@Composable
internal fun TextWithIcon(title: String, subtitle: String, painter: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
    ) {
        Image(
            modifier = Modifier
                .size(dimensionResource(R.dimen.size_card))
                .padding(end = dimensionResource(R.dimen.padding_small_extra)),
            painter = painterResource(painter),
            contentDescription = "mailbox_icon",
        )
        Column(horizontalAlignment = Alignment.Start) {
            Text(
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.surfaceVariant,
                fontWeight = FontWeight.Bold,
                text = title
            )
            Text(
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                text = subtitle
            )
        }
    }
}

@Composable
internal fun TextWithIconBack(modifier: Modifier = Modifier, onClickBack: () -> Unit) {
    Button( onClick = onClickBack,
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = Color.Transparent)
        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(dimensionResource(R.dimen.padding_small))
        ) {
            Image(
                modifier = Modifier
                    .size(dimensionResource(R.dimen.image_medium_extra))
                    .padding(end = dimensionResource(R.dimen.padding_small_extra)),
                painter = painterResource(R.drawable.arrow_back),
                contentDescription = "mailbox_icon",
            )
            Text(
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                text = stringResource(R.string.back_button)
            )
        }
    }

}

@Composable
internal fun CardCustom(
    modifier: Modifier = Modifier,
    colorFirst: Color,
    colorSecond: Color,
    borderColor: Color,
    icon: Int,
    title: String,
    subtitle: String,
) {
    Box(
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_small))
            .border(
                width = dimensionResource(R.dimen.border),
                color = borderColor,
                shape = MaterialTheme.shapes.large
            )
            .clip(RoundedCornerShape(dimensionResource(R.dimen.padding_medium_extra)))
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        colorFirst.copy(alpha = 0.5f),
                        colorSecond.copy(alpha = 0.5f)
                    )
                )
            )
            .padding(20.dp)
    ) {
        Column(horizontalAlignment = Alignment.Start) {
            Image(
                modifier = Modifier
                    .padding(bottom = dimensionResource(R.dimen.padding_small_extra))
                    .size(dimensionResource(R.dimen.padding_card)),
                painter = painterResource(icon),
                contentDescription = "icon ${R.drawable.crystal_ball}",//TODO: Временный хардкор
            )
            TitleAndSubtitleBody(title, subtitle)
        }

    }
}

@Composable
internal fun BottomBar(icon: Int) { //TODO клики прописать
    IconButton(
        modifier = Modifier.alpha(0.5f),
        onClick = {}
    ) {
        Image(
            painterResource(icon),
            contentDescription = "smth des"
        )
    }
}


@Preview
@Composable
fun PreviewElement() {
    TextWithIconBack(onClickBack = {})
}