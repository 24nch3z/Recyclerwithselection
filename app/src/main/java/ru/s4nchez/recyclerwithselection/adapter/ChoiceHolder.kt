package ru.s4nchez.recyclerwithselection.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class ChoiceHolder<T>(containerView: View) : RecyclerView.ViewHolder(containerView) {

    private var item: T? = null

    fun setChooseAdapterListener(chooseAdapterListener: ChooseAdapterListener) {
        itemView.setOnClickListener {
            item?.let {
                chooseAdapterListener.selectItem(adapterPosition)
            }
        }
    }

    fun setItem(item: T?) {
        this.item = item
    }

    abstract fun bind(item: T, isSelected: Boolean)
}