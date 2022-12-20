package com.gorodechnyj.utils

fun <T> List<T>.replaceWhen(newValue: T, predicate: (T) -> Boolean): List<T> {
    return map {
        if (predicate(it)) newValue else it
    }
}
