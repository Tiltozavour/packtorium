package com.tiltozavour.packtorium.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tiltozavour.packtorium.R


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
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
        Image(
            modifier = Modifier
                .size(40.dp)
                .padding(end = 12.dp),//TODO: Временный хардкор
            painter = painterResource(painter),
            contentDescription = "mailbox_icon",//TODO: Временный хардкор
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
            .padding(8.dp)
            .border(
                0.5.dp,
                color = borderColor,
                shape = MaterialTheme.shapes.large
            )
            .clip(RoundedCornerShape(18.dp))
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
                    .padding(bottom = 12.dp)
                    .size(24.dp),
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
        modifier = Modifier.alpha(0.6f),
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

}