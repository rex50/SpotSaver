package com.spot.saver.android.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.spot.saver.android.theme.SpotSaverColors.DarkPrimaryColor
import com.spot.saver.android.theme.SpotSaverColors.DarkSecondaryColor
import com.spot.saver.android.theme.SpotSaverColors.DarkTertiaryColor
import com.spot.saver.android.theme.SpotSaverColors.LightPrimaryColor
import com.spot.saver.android.theme.SpotSaverColors.LightSecondaryColor
import com.spot.saver.android.theme.SpotSaverColors.LightTertiaryColor

@Composable
fun SpotSaverTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColorScheme
    } else {
        lightColorScheme
    }

    MaterialTheme(
        colorScheme = colors,
        typography = spotSaverTypography,
        shapes = shapes,
        content = content
    )
}

private val darkColorScheme = darkColorScheme(
    primary = DarkPrimaryColor,
    secondary = DarkSecondaryColor,
    tertiary = DarkTertiaryColor
)

private val lightColorScheme = lightColorScheme(
    primary = LightPrimaryColor,
    secondary = LightSecondaryColor,
    tertiary = LightTertiaryColor
)

private val spotSaverTypography = Typography(
    bodyMedium = TextStyle(
        fontFamily = sourceSans3Family,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )

    // TODO: Add more types
)

private val shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)
