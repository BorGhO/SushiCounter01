package com.keepon.sushicounter01.ui.ordineFolder

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.getDrawable

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.keepon.sushicounter01.MenuRecycler
import com.keepon.sushicounter01.OrdineAdapter
import com.keepon.sushicounter01.PiattoClass
import com.keepon.sushicounter01.R

class OrdineFragment : Fragment() {

    private lateinit var dashboardViewModel: OrdineViewModel
    private lateinit var frecciaDesc: ImageView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel = ViewModelProvider(this).get(OrdineViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_ordine, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        val menuButt = root.findViewById(R.id.startMenuButt) as Button
        menuButt.setOnClickListener {
            println("premuto")
            val intent = Intent(activity, MenuRecycler::class.java)
            startActivity(intent)
        }


        val items = ArrayList<PiattoClass>()

        items.add(PiattoClass("Futomaki", "Il futomaki ha l'alga all'interno", "salmone", R.drawable.futomaki))
        items.add(PiattoClass("Gunkan", "Il gunkan è l'evoluzione dell'hosomaki", "tonno", R.drawable.gunkan))

        val recycle = root.findViewById<RecyclerView>(R.id.ordineRecycler)    //recyclerView contenuto nel xml di questa activity
        //val adapter = OrdineAdapter(items, applicationContext)
        val adapter = activity?.applicationContext?.let { OrdineAdapter(items, it) }

        recycle.layoutManager = GridLayoutManager(activity?.applicationContext, 1)    //spanCount è il numero di colonne
        var decorazione = DividerItemDecoration(activity?.applicationContext, DividerItemDecoration.VERTICAL)
        activity?.applicationContext?.let { getDrawable(it, R.drawable.menu_divisorio)?.let { decorazione.setDrawable(it) } }
        recycle.addItemDecoration(decorazione)
        recycle.adapter = adapter

        return root
    }


}