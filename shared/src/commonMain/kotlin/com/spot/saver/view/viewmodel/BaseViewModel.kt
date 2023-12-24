package com.spot.saver.view.viewmodel

import com.spot.saver.util.CoroutineViewModel
import com.spot.saver.view.state.State
import kotlinx.coroutines.flow.StateFlow

/**
 * Base for all the ViewModels
 */
abstract class BaseViewModel<STATE : State> : CoroutineViewModel() {
    /**
     * State to be exposed to the UI layer
     */
    abstract val state: StateFlow<STATE>

    /**
     * Retrieves the current UI state
     */
    val currentState: STATE get() = state.value
}