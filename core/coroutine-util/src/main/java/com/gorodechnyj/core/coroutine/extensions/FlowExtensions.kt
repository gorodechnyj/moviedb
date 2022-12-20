package com.gorodechnyj.core.coroutine.extensions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

inline fun <T> Flow<T>.withValue(
    scope: CoroutineScope,
    crossinline action: (T) -> Unit
) {
    scope.launch {
        this@withValue.first().also(action)
    }
}

inline fun <T, R> Flow<List<T>>.mapList(crossinline transform: suspend (value: T) -> R): Flow<List<R>> =
    map { list ->
        list.map { value ->
            transform(value)
        }
    }
