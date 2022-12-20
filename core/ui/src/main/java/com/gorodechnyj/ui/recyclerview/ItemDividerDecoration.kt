package com.gorodechnyj.ui.recyclerview

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.gorodechnyj.core.ui.R

class ItemDividerDecoration(
    context: Context?,
    tintColor: Int? = null,
    private val showLast: Boolean = true
) : RecyclerView.ItemDecoration() {

    private var mDivider: Drawable? = null

    init {
        if (context != null) {
            mDivider = ContextCompat.getDrawable(context, R.drawable.divider_list_item)
            tintColor?.let {
                mDivider?.setTint(it)
            }
        }
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {

        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        val childCount = parent.childCount
        val lastItem =
            if (showLast || childCount == 0) childCount else childCount - 1
        for (i in 0 until lastItem) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val top = child.bottom + params.bottomMargin
            val bottom = top + (mDivider?.intrinsicHeight ?: 0)

            mDivider?.let {
                it.setBounds(left, top, right, bottom)
                it.draw(c)
            }
        }
    }
}
