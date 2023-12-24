package com.spot.saver.domain

import com.spot.saver.enums.Result

interface NoInputUseCase<Output: Any> {
    suspend fun invoke() : Result<Output>
}