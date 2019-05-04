package ru.s4nchez.recyclerwithselection.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class SingleChoiceAdapter<T, VH : ChoiceHolder<T>> : RecyclerView.Adapter<VH>(), ChooseAdapterListener {

    private var items = ArrayList<T>()
    private var selectedItemPosition: Int? = null
    private var choiceType = ChoiceType.NOTHING

    abstract fun generateViewHolder(parent: ViewGroup, viewType: Int): VH

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val viewHolder = generateViewHolder(parent, viewType)
        viewHolder.setChooseAdapterListener(this)
        return viewHolder
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]
        holder.setItem(item)
        holder.bind(item, position == selectedItemPosition)
    }

    override fun selectItem(position: Int) {
        val oldPosition = selectedItemPosition
        selectedItemPosition = position
        oldPosition?.let { notifyItemChanged(it) }
        notifyItemChanged(position)
    }

    fun setItems(newItems: List<T>) {
        items = ArrayList(newItems)
        selectedItemPosition?.let { selectedItemPosition = 0 }
        notifyDataSetChanged()
    }

    fun setChoiceType(type: ChoiceType) {
        this.choiceType = type
    }

    enum class ChoiceType {
        NOTHING, SINGLE_CHOICE, MULTIPLE_CHOICE
    }
}