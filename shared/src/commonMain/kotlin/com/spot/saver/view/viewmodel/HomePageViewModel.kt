package com.spot.saver.view.viewmodel

import com.spot.saver.domain.FetchSavedSpotsUseCase
import com.spot.saver.enums.Result
import com.spot.saver.store.StateStore
import com.spot.saver.view.model.SpotDetailUiModel
import com.spot.saver.view.state.HomeState
import com.spot.saver.view.state.mutable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomePageViewModel(
    private val fetchSavedSpotsUseCase: FetchSavedSpotsUseCase
) : BaseViewModel<HomeState>() {

    private val stateStore = StateStore(initialState = HomeState.initialState.mutable())
    override val state: StateFlow<HomeState> = stateStore.state

    fun fetchMySpots() = coroutineScope.launch(Dispatchers.Default) {
        stateStore.setState {
            isLoading = true
        }
        when(val result = fetchSavedSpotsUseCase.invoke()) {
            is Result.Success -> {
                stateStore.setState {
                    isLoading = false
                    savedSpots = result.data
                }
            }

            is Result.Failure -> {
                stateStore.setState {
                    isLoading = false
                    error = "Problem while loading saved spots"
                }
            }
        }
    }
}