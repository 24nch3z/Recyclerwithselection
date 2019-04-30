package ru.s4nchez.recyclerwithselection

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_simple.*

class BandAdapter(private val listener: OnItemClickListener) : RecyclerView.Adapter<BandAdapter.BandHolder>() {

    private var items = ArrayList<Band>()
    private var selectedItemPosition: Int? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BandHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_simple, parent, false)
        return BandHolder(view, listener)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BandHolder, position: Int) {
        holder.bind(items[position], position == selectedItemPosition)
    }

    fun setItems(newItems: List<Band>) {
        items = ArrayList(newItems)
        selectedItemPosition?.let { selectedItemPosition = 0 }
        notifyDataSetChanged()
    }

    fun setSelectedItem(position: Int) {
        val oldPosition = selectedItemPosition
        selectedItemPosition = position
        oldPosition?.let { notifyItemChanged(it) }
        notifyItemChanged(position)
    }

    inner class BandHolder(
            override val containerView: View,
            listener: OnItemClickListener
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        private var band: Band? = null

        init {
            itemView.setOnClickListener {
                band?.let { band ->
                    setSelectedItem(adapterPosition)
                    listener.onClick(band)
                }
            }
        }

        fun bind(band: Band, isSelected: Boolean) {
            this.band = band
            label_view.text = band.label
            checkbox.isChecked = isSelected
        }
    }

    interface OnItemClickListener {
        fun onClick(band: Band)
    }
}