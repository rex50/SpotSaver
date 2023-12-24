package com.spot.saver.view.state

import com.spot.saver.view.model.SpotDetailUiModel
import dev.shreyaspatil.mutekt.core.annotations.GenerateMutableModel

/**
 * UI state for Home page
 */
@GenerateMutableModel
interface HomePageState : State {
    val isLoading: Boolean
    val savedSpots: List<SpotDetailUiModel>
    val error: String?

    companion object {
        val initialState = HomeState(isLoading = true, savedSpots = emptyList(), error = null)
    }
}
