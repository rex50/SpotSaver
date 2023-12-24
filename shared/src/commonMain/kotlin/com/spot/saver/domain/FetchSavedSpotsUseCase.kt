package com.spot.saver.domain

import com.spot.saver.data.repo.spot.SpotsRepo
import com.spot.saver.enums.Result
import com.spot.saver.view.model.SpotDetailUiModel

class FetchSavedSpotsUseCase(private val spotsRepo: SpotsRepo) : NoInputUseCase<List<SpotDetailUiModel>> {
    override suspend fun invoke(): Result<List<SpotDetailUiModel>> {
        return spotsRepo.fetchSavedSpots()
    }
}