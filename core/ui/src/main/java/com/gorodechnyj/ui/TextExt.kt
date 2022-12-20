package com.gorodechnyj.ui

import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.core.widget.doAfterTextChanged
import com.gorodechnyj.moviedb.R
import java.text.DecimalFormat
import com.gorodechnyj.core.ui.R as utilR

val priceFormat = DecimalFormat("###,###.##")

fun TextView.setPrice(value: Float?, @StringRes wrapperResId: Int = R.string.price) {
    text = context.getString(wrapperResId, priceFormat.format(value ?: 0))
}

fun EditText.setTextSilently(value: String?, afterTextChanged: ((text: String?) -> Unit)? = null) {
    val textWatcher = getTag(utilR.id.text_watcher) as? TextWatcher
    if (value != text?.toString()) {
        textWatcher?.let {
            removeTextChangedListener(textWatcher)
        }
        setText(value)
        setSelection(value?.length ?: 0)
        if (textWatcher != null) {
            addTextChangedListener(textWatcher)
        }
    }
    if (textWatcher == null && afterTextChanged != null) {
        val newTextWatcher = doAfterTextChanged {
            afterTextChanged(it?.toString())
        }
        addTextChangedListener(newTextWatcher)
        setTag(utilR.id.text_watcher, newTextWatcher)
    }
}
