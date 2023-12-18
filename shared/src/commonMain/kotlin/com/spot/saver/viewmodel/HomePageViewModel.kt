package com.spot.saver.viewmodel

import com.spot.saver.enums.LabelType
import com.spot.saver.models.ui.SpotDetailUiModel
import com.spot.saver.models.ui.SpotLabelUiModel
import com.spot.saver.util.CoroutineViewModel
import com.spot.saver.util.dummySpotDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomePageViewModel() : CoroutineViewModel() {

    private val _savedSpots = MutableStateFlow<List<SpotDetailUiModel>>(emptyList())
    val savedSpots = _savedSpots.asStateFlow()


    private val labels = listOf(
        SpotLabelUiModel("Expires in 4 hours", LabelType.EXPIRY_RED),
        SpotLabelUiModel("Expires in 24 hours", LabelType.EXPIRY_YELLOW),
        SpotLabelUiModel("Expires in 1 month", LabelType.EXPIRY_GREEN),
        SpotLabelUiModel("General label", LabelType.GENERAL),
    )

    fun fetchMySpots() = coroutineScope.launch(Dispatchers.Default) {
        delay(1000)
        val list = mutableListOf<SpotDetailUiModel>()
        (1..10).forEach {
            list.add(
                dummySpotDetail.copy(
                    id = "$it",
                    title = "A spot to visit in a season $it",
                    labels = listOf(labels.random())
                )
            )
        }
        _savedSpots.emit(list)
    }

}
