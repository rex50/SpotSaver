package com.spot.saver.data.repo.spot

import com.spot.saver.enums.Result
import com.spot.saver.view.model.SpotDetailUiModel

interface SpotsRepo {
    suspend fun fetchSavedSpots() : Result<List<SpotDetailUiModel>>
}