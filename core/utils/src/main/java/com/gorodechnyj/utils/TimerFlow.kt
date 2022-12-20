package com.gorodechnyj.utils

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

@ExperimentalCoroutinesApi
fun timerFlow(
    initSecondsCountDown: Long,
    intervalMilliseconds: Long
) = flow {
    var secondsCountDown = initSecondsCountDown

    do {
        emit(secondsCountDown)
        --secondsCountDown
        delay(intervalMilliseconds)
    } while (secondsCountDown >= 0L)
}
