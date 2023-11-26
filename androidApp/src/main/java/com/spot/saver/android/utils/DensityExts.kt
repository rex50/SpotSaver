package com.spot.saver.android.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun Dp.toPx(): Float = with(LocalDensity.current) { toPx() }

@Composable
fun Float.toDp(): Dp = with(LocalDensity.current) { toDp() }