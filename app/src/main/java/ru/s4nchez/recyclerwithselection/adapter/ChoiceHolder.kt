package ru.s4nchez.recyclerwithselection.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class ChoiceHolder<T>(containerView: View) : RecyclerView.ViewHolder(containerView) {

    private var item: T? = null
    private var chooseAdapterListener: ChooseAdapterListener? = null
    private var onItemClickListener: OnItemClickListener<T>? = null

    fun setChooseAdapterListener(chooseAdapterListener: ChooseAdapterListener) {
        this.chooseAdapterListener = chooseAdapterListener
        itemView.setOnClickListener {
            item?.also {
                chooseAdapterListener.selectItem(adapterPosition)
                onItemClickListener?.onClick(it)
            }
        }
    }

    fun setClickListener(onItemClickListener: OnItemClickListener<T>) {
        this.onItemClickListener = onItemClickListener
        itemView.setOnClickListener {
            item?.also {
                onItemClickListener.onClick(it)
                chooseAdapterListener?.selectItem(adapterPosition)
            }
        }
    }

    fun setItem(item: T?) {
        this.item = item
    }

    abstract fun bind(item: T, isSelected: Boolean)
}