package ru.s4nchez.recyclerwithselection.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class SingleChoiceAdapter<T, VH : ChoiceHolder<T>> : RecyclerView.Adapter<VH>(), ChooseAdapterListener {

    private var items = ArrayList<T>()
    private val selectedItemsSet = HashSet<Int>()

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
        holder.bind(item, selectedItemsSet.contains(position), choiceType)
    }

    override fun selectItem(position: Int) {
        when (choiceType) {
            ChoiceType.SINGLE_CHOICE -> {
                val oldPosition: Int? = selectedItemsSet.firstOrNull { true }
                selectedItemsSet.clear()
                selectedItemsSet.add(position)
                oldPosition?.let { notifyItemChanged(it) }
                notifyItemChanged(position)
            }
            ChoiceType.MULTIPLE_CHOICE -> {
                if (selectedItemsSet.contains(position)) {
                    selectedItemsSet.remove(position)
                } else {
                    selectedItemsSet.add(position)
                }
                notifyItemChanged(position)
            }
        }
    }

    fun setItems(newItems: List<T>) {
        items = ArrayList(newItems)
        selectedItemsSet.clear()
        notifyDataSetChanged()
    }

    fun setChoiceType(type: ChoiceType) {
        this.choiceType = type
        selectedItemsSet.clear()
        notifyDataSetChanged()
    }

    enum class ChoiceType {
        NOTHING, SINGLE_CHOICE, MULTIPLE_CHOICE
    }
}