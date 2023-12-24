package com.spot.saver.android.presentation.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.koin.java.KoinJavaComponent.inject

/**
 * Koin utility method for injecting
 * viewModel into composable components
 */
@Composable
inline fun <reified T : Any> koinViewModel(): T {
    // TODO: find away to bind viewModel to component lifecycle
    val viewModel by remember<Lazy<T>> {
        inject(T::class.java)
    }
    return viewModel
}