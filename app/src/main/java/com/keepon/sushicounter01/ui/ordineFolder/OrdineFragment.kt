package com.keepon.sushicounter01.ui.ordineFolder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.getDrawable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.keepon.sushicounter01.MenuAdapter
import com.keepon.sushicounter01.OrderAdapter
import com.keepon.sushicounter01.R

private lateinit var questo: Fragment   //serve a mettere da parte l'attuale oggetto del fragment, di modo da poterlo poi richiamare
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

        questo = this

        val menuButt = root.findViewById(R.id.menuFragButt) as Button
        menuButt.setOnClickListener {
            println("premuto")

        }

        //Questo serve a fare da divisorio tra gli oggetti delle recyclerView
        var decorazione = DividerItemDecoration(activity?.applicationContext, DividerItemDecoration.VERTICAL)

        //Menu

        //qui parte per ricaricare i dati precedenti

        orderViewModel.startMenu()

        val recycleMenu = root.findViewById<RecyclerView>(R.id.menuRecycler)    //recyclerView contenuto nel xml di questa activity

        val adapterMenu = activity?.applicationContext?.let { MenuAdapter(orderViewModel.getMenu(), it) }

        

        recycleMenu.layoutManager = GridLayoutManager(activity?.applicationContext, 1)    //spanCount è il numero di colonne

        activity?.applicationContext?.let { getDrawable(it, R.drawable.menu_divisorio)?.let { decorazione.setDrawable(it) } }
        recycleMenu.addItemDecoration(decorazione)
        recycleMenu.adapter = adapterMenu





        //Ordine

        //qui parte per ricaricare i dati precedenti

        orderViewModel.startOrder()


        val recycleOrder = root.findViewById<RecyclerView>(R.id.orderRecycler)    //recyclerView contenuto nel xml di questa activity

       val adapterOrder = activity?.applicationContext?.let { OrderAdapter(orderViewModel.getOrder(), it) }!!

        recycleOrder.layoutManager = GridLayoutManager(activity?.applicationContext, 1)    //spanCount è il numero di colonne

        activity?.applicationContext?.let { getDrawable(it, R.drawable.menu_divisorio)?.let { decorazione.setDrawable(it) } }
        recycleOrder.addItemDecoration(decorazione)
        recycleOrder.adapter = adapterOrder



        return root
    }



    fun insertInOrder(indice: Int){

        orderViewModel = ViewModelProvider(questo).get(OrdineViewModel::class.java)
        orderViewModel.addToOrder(indice)

    }




}
