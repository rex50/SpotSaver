package com.spot.saver.view.viewmodel

import com.spot.saver.domain.FetchSavedSpotsUseCase
import com.spot.saver.enums.Result
import com.spot.saver.view.model.SpotDetailUiModel
import com.spot.saver.util.CoroutineViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomePageViewModel: CoroutineViewModel(), KoinComponent {

    private val fetchSavedSpotsUseCase: FetchSavedSpotsUseCase by inject()

    private val _savedSpots = MutableStateFlow<List<SpotDetailUiModel>>(emptyList())
    val savedSpots = _savedSpots.asStateFlow()

    fun fetchMySpots() = coroutineScope.launch(Dispatchers.Default) {
        // TODO: Update state to loading
        when(val result = fetchSavedSpotsUseCase.invoke()) {
            is Result.Success -> {
                _savedSpots.emit(result.data)
            }

            is  Result.Failure -> {
                // TODO: Handle failure case
            }
        }
    }

}
