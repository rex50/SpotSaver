package com.spot.saver.store

import dev.shreyaspatil.mutekt.core.MutektMutableState
import kotlinx.coroutines.flow.StateFlow

/**
 * A single source of truth for storing UI state
 *
 * [STATE] represents immutable state model.
 * [MUTABLE_STATE] represents mutable state model.
 *
 * @param initialState The initial state which is mutable
 */
class StateStore<STATE, MUTABLE_STATE : MutektMutableState<STATE, out STATE>>(
    initialState: MUTABLE_STATE
) {
    /**
     * Mutable state model
     */
    private val mutableState = initialState

    /**
     * Reactive flow of Read only state model
     */
    val state: StateFlow<STATE> = mutableState.asStateFlow()

    /**
     * Updates state atomically.
     *
     * @param update The lambda block to perform state updates
     */
    @Suppress("UNCHECKED_CAST")
    fun setState(update: MUTABLE_STATE.() -> Unit) {
        mutableState.update(update as STATE.() -> Unit)
    }
}