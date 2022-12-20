package com.gorodechnyj.ui.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GridSpacingItemDecoration(
    private val spanCount: Int,
    private val spacing: Int,
    private val applyTo: (position: Int) -> Boolean
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        if (applyTo(position)) {
            val column = position % spanCount
            outRect.top = spacing
            outRect.bottom = spacing
            outRect.left = spacing - column * (spacing / spanCount)
            outRect.right = (column + 1) * (spacing / spanCount)
        }
    }
}
