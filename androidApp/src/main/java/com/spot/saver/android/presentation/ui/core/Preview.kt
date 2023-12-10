package com.spot.saver.android.presentation.ui.core

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.spot.saver.android.theme.SpotSaverTheme

/**
 * Utility method for Previewing a
 * composable component with proper theme
 *
 * Usage:
 * ```
 * Preview {
 *    // Your component
 * }
 * ```
 */
@Composable
fun Preview(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    SpotSaverTheme {
        Surface {
            Box(modifier = modifier) {
                content()
            }
        }
    }
}

