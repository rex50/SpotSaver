package com.spot.saver.android.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

/**
 * Converts [Dp] to pixels
 */
@Composable
fun Dp.toPx(): Float = with(LocalDensity.current) { toPx() }

/**
 * Converts [Float] pixel value to a Dp
 */
@Composable
fun Float.toDp(): Dp = with(LocalDensity.current) { toDp() }