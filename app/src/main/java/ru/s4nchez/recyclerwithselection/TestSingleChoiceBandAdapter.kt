package ru.s4nchez.recyclerwithselection

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_simple.*
import ru.s4nchez.recyclerwithselection.adapter.ChoiceHolder
import ru.s4nchez.recyclerwithselection.adapter.SingleChoiceAdapter

class TestSingleChoiceBandAdapter : SingleChoiceAdapter<Band, TestSingleChoiceBandAdapter.BandViewHolder>() {

    override fun generateViewHolder(parent: ViewGroup, viewType: Int): BandViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_simple, parent, false)
        return BandViewHolder(view)
    }

    class BandViewHolder(
        override val containerView: View
    ) : ChoiceHolder<Band>(containerView), LayoutContainer {

        override fun bind(item: Band, isSelected: Boolean) {
            label_view.text = item.label
            checkbox.isChecked = isSelected
        }
    }
}