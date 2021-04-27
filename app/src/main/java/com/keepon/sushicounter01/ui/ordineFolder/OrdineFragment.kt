package com.keepon.sushicounter01.ui.ordineFolder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.getDrawable
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.keepon.sushicounter01.MenuAdapter
import com.keepon.sushicounter01.R

class OrdineFragment : Fragment() {

    private lateinit var orderViewModel: OrdineViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        orderViewModel = ViewModelProvider(this).get(OrdineViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_ordine, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        orderViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        val menuButt = root.findViewById(R.id.menuFragButt) as Button
        menuButt.setOnClickListener {
            println("premuto")

        }

        //qui parte per ricaricare i dati precedenti

        orderViewModel.startOrder()


        val recycle = root.findViewById<RecyclerView>(R.id.menuRecycler)    //recyclerView contenuto nel xml di questa activity

        val adapter = activity?.applicationContext?.let { MenuAdapter(orderViewModel.getOrder(), it) }

        recycle.layoutManager = GridLayoutManager(activity?.applicationContext, 1)    //spanCount è il numero di colonne
        var decorazione = DividerItemDecoration(activity?.applicationContext, DividerItemDecoration.VERTICAL)
        activity?.applicationContext?.let { getDrawable(it, R.drawable.menu_divisorio)?.let { decorazione.setDrawable(it) } }
        recycle.addItemDecoration(decorazione)
        recycle.adapter = adapter
        return root
    }

}