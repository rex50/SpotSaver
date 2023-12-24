package com.spot.saver.util

import kotlinx.coroutines.CoroutineScope

/**
 * ViewModel with coroutine support
 */
expect abstract class CoroutineViewModel() {

    val coroutineScope: CoroutineScope

    fun dispose()

    protected open fun onCleared()
}