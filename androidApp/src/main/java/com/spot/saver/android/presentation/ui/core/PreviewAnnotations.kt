package com.spot.saver.android.presentation.ui.core

import android.content.res.Configuration.*
import androidx.compose.ui.tooling.preview.Preview

/**
 * Generates Light and Dark theme preview of the component
 *
 * Note: Use [Preview] which allows to view component with different themes
 */
@LightThemePreview
@DarkThemePreview
annotation class ThemedComponentPreviews

/**
 * Generates Light theme preview of the component
 *
 * Note: Use [Preview] which allows to view component with different themes
 */
@Preview(
    name = "Light Theme",
    group = "Component Theme",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL
)
annotation class LightThemePreview

/**
 * Generates Dark theme preview of the component
 *
 * Note: Use [Preview] which allows to view component with different themes
 */
@Preview(
    name = "Dark Theme",
    group = "Component Theme",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL
)
annotation class DarkThemePreview

/**
 * Generates Light and Dark theme previews of the
 * screen in a device frame with system UI
 *
 * Note: Use [Preview] which allows to view component with different themes
 */
@LightThemeDevicePreview
@DarkThemeDevicePreview
annotation class ThemedDevicePreviews

/**
 * Generates Light theme preview of the
 * screen in a device frame with system UI
 *
 * Note: Use [Preview] which allows to view component with different themes
 */
@Preview(
    name = "Light Theme",
    group = "Screen Theme",
    showBackground = true,
    showSystemUi = true,
    device = "id:pixel_7",
    uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL
)
annotation class LightThemeDevicePreview

/**
 * Generates Dark theme preview of the
 * screen in a device frame with system UI
 *
 * Note: Use [Preview] which allows to view component with different themes
 */
@Preview(
    name = "Dark Theme",
    group = "Screen Theme",
    showBackground = true,
    showSystemUi = true,
    device = "id:pixel_7",
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL
)
annotation class DarkThemeDevicePreview