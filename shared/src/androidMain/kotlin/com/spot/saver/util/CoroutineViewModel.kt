package com.spot.saver.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel

/**
 * Actual Android CoroutineViewModel
 */
actual abstract class CoroutineViewModel : ViewModel() {

    actual val coroutineScope = viewModelScope

    actual fun dispose() {
        coroutineScope.cancel()
        onCleared()
    }

    actual override fun onCleared() {
        super.onCleared()
    }
}