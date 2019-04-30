package ru.s4nchez.recyclerwithselection

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class BoundaryMarginsItemDecorator(
        private val topMarginOnFirstItem: Int,
        private val bottomMarginOnLastItem: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State) {

        val position = parent.getChildLayoutPosition(view)
        if (position == 0) outRect.top = topMarginOnFirstItem
        if (position + 1 == state.itemCount) outRect.bottom = bottomMarginOnLastItem
    }
}
