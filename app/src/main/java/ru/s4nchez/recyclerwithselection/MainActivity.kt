package ru.s4nchez.recyclerwithselection

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BandAdapter.OnItemClickListener {

    private var adapter: BandAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = BandAdapter(this)
        recycler_view.adapter = adapter
        adapter?.setItems(Bands.list)
    }

    override fun onClick(band: Band) {
        Toast.makeText(this, band.label, Toast.LENGTH_SHORT).show()
    }
}
