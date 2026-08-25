package com.tiltozavour.packtorium.cookies_screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tiltozavour.packtorium.R
import com.tiltozavour.packtorium.ui.BottomBar
import com.tiltozavour.packtorium.ui.CardCustom
import com.tiltozavour.packtorium.ui.TextWithIcon
import com.tiltozavour.packtorium.ui.TitleAndSubtitle
import com.tiltozavour.packtorium.ui.theme.AppTheme
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CookiesScreen(
    uiState: CookieUiState
) {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.scrim,
                contentPadding = PaddingValues(horizontal = 16.dp),
                actions = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
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
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.onPrimary,
                            MaterialTheme.colorScheme.background
                        ),
                        center = Offset(350 / 0.5f, 900 / 0.5f),
                        radius = 100 / 0.3f,
                        tileMode = TileMode.Clamp
                    )
                )
        ) {
            Stars()
            Column(
                modifier = Modifier.padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppBar()
                CookiesFrame(uiState)
                Notification()
                SendAndCollection()
                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 24.dp),
                    color = MaterialTheme.colorScheme.onSecondary,
                    thickness = 0.5.dp
                )
                Text(
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = "Длинная цитата для примера будет тут красивым шрифтом когда-нибудь, точно"
                )
            }

        }
    }
}

@Composable
fun AppBar() {
    Row(
        modifier = Modifier
            .padding(24.dp) //TODO: Временный хардкор
            .fillMaxWidth(1f),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                style = MaterialTheme.typography.titleSmall,
                text = "Friday, AUG 21", //TODO: Временный хардкор
            )
            Text(
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.outline,
                text = "Cosmic Cookie" //TODO: Временный хардкор
            )
        }
        Box(
            modifier = Modifier
                .size(40.dp)//TODO: Временный хардкор
                .border(
                    width = 0.5.dp,//TODO: Временный хардкор
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
                modifier = Modifier.size(20.dp),//TODO: Временный хардкор
                painter = painterResource(R.drawable.crystal_ball),
                contentDescription = "Crystal ball",//TODO: Временный хардкор
            )
        }
    }
}

@Composable
fun CookiesFrame(uiState: CookieUiState) {
    Box(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(8.dp)
            .border(
                0.5.dp,
                color = MaterialTheme.colorScheme.onSecondary,
                shape = MaterialTheme.shapes.large
            )
            .clip(RoundedCornerShape(18.dp))
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
            modifier = Modifier.fillMaxWidth(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when(uiState){
                CookieUiState.isCookiesPrediction -> CookiesPredictionMode()
                CookieUiState.isMain -> CookiesMain()
            }
        }
    }
}

@Composable
private fun CookiesMain(){
    Image(
        modifier = Modifier
            .size(100.dp)
            .padding(20.dp),
        alignment = Alignment.Center,
        painter = painterResource(R.drawable.fortune_cookie),
        contentDescription = "cookies",
    )
    TitleAndSubtitle(title = "Crack cookie", subtitle = "The stars....")
    Button(
        modifier = Modifier.padding(20.dp),
        onClick = {}) {
        Text(
            color = MaterialTheme.colorScheme.surfaceBright,
            style = MaterialTheme.typography.labelSmall,
            text = "Open now"
        )
    }
}

@Composable
private fun CookiesPredictionMode(){
    Text(
        modifier = Modifier.padding(14.dp),
        color = MaterialTheme.colorScheme.surfaceBright,
        style = MaterialTheme.typography.labelSmall,
        text = "Предсказание открыто"
    )
}

@Composable
fun Stars(modifier: Modifier = Modifier) {
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
fun Notification() {
    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(8.dp)
            .border(
                0.5.dp,
                color = MaterialTheme.colorScheme.surface,
                shape = MaterialTheme.shapes.medium
            )
            .clip(RoundedCornerShape(12.dp))
            .background(color = MaterialTheme.colorScheme.surface.copy(alpha = 0.3f))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        TextWithIcon(
            title = "3 cookies waiting",
            subtitle = "From cosmic friends",
            painter = R.drawable.open_mailbox
        )
        Badge(
            modifier = Modifier.size(28.dp),
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            contentColor = MaterialTheme.colorScheme.surface
        ) {
            Text(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.surfaceBright,
                style = MaterialTheme.typography.bodyMedium,
                text = "2"
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
            title = "Send Cookie",
            subtitle = "Share a fortune"
        )
        CardCustom(
            modifier = Modifier.weight(1f),
            colorFirst = MaterialTheme.colorScheme.onSecondary,
            colorSecond = MaterialTheme.colorScheme.primary,
            borderColor = MaterialTheme.colorScheme.onSecondary,
            icon = R.drawable.stars,
            title = "Collection",
            subtitle = "Your saved fortunes"
        )
    }

}

data class Star(
    val x: Float,
    val y: Float,
    val radius: Float,
)


@Preview
@Composable
fun CookiesPreview() {
    AppTheme(darkTheme = false) {
        CookiesScreen(uiState = CookieUiState.isCookiesPrediction)
    }
}
