package com.gorodechnyj.ui

import android.text.InputFilter
import android.widget.EditText

fun EditText.setRegexFilter(pattern: String) {
    filters = arrayOf(
        InputFilter { charSequence, _, _, _, _, _ ->
            filterStringOrNull(charSequence.toString(), Regex(pattern))
        }
    )
}

private fun filterStringOrNull(input: String, notAllowed: Regex): String? {
    val filtered = input.replace(notAllowed, "")
    return if (input == filtered) {
        null
    } else {
        filtered
    }
}

fun EditText.doOnUnfocused(callback: () -> Unit) {
    this.setOnFocusChangeListener { _, focused ->
        if (!focused) {
            callback()
        }
    }
}
