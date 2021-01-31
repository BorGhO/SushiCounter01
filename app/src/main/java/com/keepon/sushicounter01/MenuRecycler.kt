package com.keepon.sushicounter01

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MenuRecycler : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_ordine)



        val items = ArrayList<PiattoClass>()

        items.add(PiattoClass("Futomaki", "Il futomaki ha l'alga all'interno", R.drawable.futomaki, "salmone"))
        items.add(PiattoClass("Gunkan", "Il gunkan è l'evoluzione dell'hosomaki", R.drawable.gunkan, "salmone"))
        items.add(PiattoClass("Futomaki2", "Il futomaki ha l'alga all'interno", R.drawable.futomaki, "salmone"))
        items.add(PiattoClass("Gunkan2", "Il gunkan è l'evoluzione dell'hosomaki", R.drawable.gunkan, "salmone"))
        items.add(PiattoClass("Futomaki3", "Il futomaki ha l'alga all'interno", R.drawable.futomaki, "salmone"))
        items.add(PiattoClass("Gunkan3", "Il gunkan è l'evoluzione dell'hosomaki", R.drawable.gunkan, "salmone"))

        val recycle = findViewById<RecyclerView>(R.id.ordineRecycler)    //recyclerView contenuto nel xml di questa activity

        val adapter = OrdineAdapter(items, applicationContext)

        //i layout manager, ce ne sono di vario tipo, sono quelli che definiscono come distribuire graficamente gli elementi della lista
        recycle.layoutManager = GridLayoutManager(applicationContext, 1)    //spanCount è il numero di colonne

        recycle.adapter = adapter
    }
}
