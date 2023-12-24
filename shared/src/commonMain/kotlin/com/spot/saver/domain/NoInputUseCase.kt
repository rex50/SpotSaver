package com.spot.saver.domain

import com.spot.saver.enums.Result

interface NoInputUseCase<Output: Any> : UseCase<Any, Output> {
    suspend fun invoke() : Result<Output>

    override suspend fun invoke(input: Any): Result<Output> {
        return invoke()
    }
}