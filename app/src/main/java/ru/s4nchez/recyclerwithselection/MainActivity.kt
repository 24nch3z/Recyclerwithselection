package ru.s4nchez.recyclerwithselection

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.s4nchez.recyclerwithselection.adapter.OnItemClickListener
import ru.s4nchez.recyclerwithselection.data.Band
import ru.s4nchez.recyclerwithselection.data.Bands

class MainActivity : AppCompatActivity(), OnItemClickListener<Band> {

    private var adapter: TestSingleChoiceBandAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = TestSingleChoiceBandAdapter(this)
        recycler_view.adapter = adapter
        recycler_view.addItemDecoration(BoundaryMarginsItemDecorator(pxFromDp(16f), 0))
        adapter?.setItems(Bands.two)
    }

    override fun onClick(item: Band) {
        Log.d("sssss", item.toString())
    }

    private fun pxFromDp(dp: Float) = (dp * applicationContext.resources.displayMetrics.density).toInt()
}
