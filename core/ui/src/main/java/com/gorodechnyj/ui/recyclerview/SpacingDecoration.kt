package com.gorodechnyj.ui.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpacingDecoration(
    val spacing: Int,
    @RecyclerView.Orientation val orientation: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        if (orientation == RecyclerView.VERTICAL) {
            outRect.bottom = spacing
        } else {
            outRect.right = spacing
        }
    }
}
