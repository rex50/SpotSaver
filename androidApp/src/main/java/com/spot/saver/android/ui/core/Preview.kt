package com.spot.saver.android.ui.core

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.spot.saver.android.theme.SpotSaverTheme

/**
 * Utility method used for Previewing a
 * composable component with proper theme
 */
@Composable
fun Preview(
    content: @Composable () -> Unit
) {
    SpotSaverTheme {
        Surface {
            Box {
                content()
            }
        }
    }
}

