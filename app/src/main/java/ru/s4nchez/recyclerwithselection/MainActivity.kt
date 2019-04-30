package ru.s4nchez.recyclerwithselection

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BandAdapter.OnItemClickListener {

    private var adapter: BandAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = BandAdapter(this)
        recycler_view.adapter = adapter
        recycler_view.addItemDecoration(BoundaryMarginsItemDecorator(pxFromDp(16f), 0))
        adapter?.setItems(Bands.list)
    }

    override fun onClick(band: Band) {
        Log.d("sssss", band.toString())
    }

    private fun pxFromDp(dp: Float) = (dp * applicationContext.resources.displayMetrics.density).toInt()
}
