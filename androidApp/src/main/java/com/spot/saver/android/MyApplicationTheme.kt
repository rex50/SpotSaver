package com.spot.saver.android

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.spot.saver.android.theme.DarkPrimaryColor
import com.spot.saver.android.theme.DarkSecondaryColor
import com.spot.saver.android.theme.DarkTertiaryColor
import com.spot.saver.android.theme.LightPrimaryColor
import com.spot.saver.android.theme.LightSecondaryColor
import com.spot.saver.android.theme.LightTertiaryColor

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColorScheme(
            primary = DarkPrimaryColor,
            secondary = DarkSecondaryColor,
            tertiary = DarkTertiaryColor
        )
    } else {
        lightColorScheme(
            primary = LightPrimaryColor,
            secondary = LightSecondaryColor,
            tertiary = LightTertiaryColor
        )
    }
    val typography = Typography(
        bodyMedium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colorScheme = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
