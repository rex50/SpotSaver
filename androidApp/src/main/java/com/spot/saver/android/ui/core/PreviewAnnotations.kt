package com.spot.saver.android.ui.core

import android.content.res.Configuration.*
import androidx.compose.ui.tooling.preview.Preview as ComposePreview

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
@ComposePreview(
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
@ComposePreview(
    name = "Dark Theme",
    group = "Component Theme",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL
)
annotation class DarkThemePreview