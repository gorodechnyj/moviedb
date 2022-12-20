package com.gorodechnyj.ui

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.Group

class ClickableGroup @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : Group(context, attrs, defStyleAttr) {

    override fun setOnClickListener(l: OnClickListener?) {
        super.setOnClickListener(l)
        this.applyLayoutFeatures()
    }
}
