package com.keepon.sushicounter01

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.keepon.sushicounter01.ui.ordineFolder.OrdineFragment

class MenuRecycler : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_ordine)


/*
        val items = ArrayList<PiattoClass>()

        items.add(PiattoClass("Futomaki", "Il futomaki ha l'alga all'interno", "salmone", R.drawable.futomaki))
        items.add(PiattoClass("Gunkan", "Il gunkan è l'evoluzione dell'hosomaki", "tonno", R.drawable.gunkan))

        val recycle = findViewById<RecyclerView>(R.id.ordineRecycler)    //recyclerView contenuto nel xml di questa activity
        val adapter = OrdineAdapter(items, applicationContext)
        //i layout manager, ce ne sono di vario tipo, sono quelli che definiscono come distribuire graficamente gli elementi della lista
        recycle.layoutManager = GridLayoutManager(applicationContext, 1)    //spanCount è il numero di colonne
        var decorazione = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
        getDrawable(R.drawable.menu_divisorio!!)?.let { decorazione.setDrawable(it) }
        recycle.addItemDecoration(decorazione)
        recycle.adapter = adapter*/
    }
}
