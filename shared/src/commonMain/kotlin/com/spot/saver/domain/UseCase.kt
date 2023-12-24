package com.spot.saver.domain

import com.spot.saver.enums.Result

interface UseCase<Input: Any, Output: Any> {
    suspend fun invoke(input: Input) : Result<Output>
}