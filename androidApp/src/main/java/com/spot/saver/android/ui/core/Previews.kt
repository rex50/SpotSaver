package com.spot.saver.android.ui.core

import android.content.res.Configuration.*
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "Light Theme",
    group = "Component Theme",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL
)
@Preview(
    name = "Dark Theme",
    group = "Component Theme",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL
)
annotation class ThemedComponentPreviews