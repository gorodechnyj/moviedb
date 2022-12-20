package com.gorodechnyj.ui

import android.content.Context
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View
import com.gorodechnyj.moviedb.R
import com.gorodechnyj.ui.theme.getColorFromAttr

fun SpannableString.setWebLinkSpan(
    context: Context,
    text: String,
    onClickAction: () -> Unit,
) {
    val span = object : ClickableSpan() {

        override fun onClick(widget: View) {
            onClickAction.invoke()
        }

        override fun updateDrawState(ds: TextPaint) {
            ds.color = context.getColorFromAttr(com.google.android.material.R.attr.colorPrimary)
            ds.isUnderlineText = false
        }
    }
    val textStart = indexOf(text)
    val textLength = text.length
    setSpan(span, textStart, textStart + textLength, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
}
