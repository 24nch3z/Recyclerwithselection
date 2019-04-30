package ru.s4nchez.recyclerwithselection

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_simple.view.*

class BandAdapter(private val listener: OnItemClickListener) : RecyclerView.Adapter<BandAdapter.BandHolder>() {

    private var items = ArrayList<Band>()
    private var selectedItem: Band? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BandHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_simple, parent, false)
        return BandHolder(view, listener)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BandHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setItems(newItems: List<Band>) {
        items = ArrayList(newItems)
        notifyDataSetChanged()
    }

    fun setSelectedItem(item: Band) {
        this.selectedItem = item
    }

    inner class BandHolder(itemView: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {

        private var band: Band? = null

        init {
            itemView.setOnClickListener { v ->
                band?.let {
                    setSelectedItem(it)
                    listener.onClick(it)
                }
            }
        }

        fun bind(band: Band) {
            this.band = band
            itemView.label_view.text = band.label
        }
    }

    interface OnItemClickListener {
        fun onClick(band: Band)
    }
}