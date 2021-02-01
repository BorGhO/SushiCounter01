package com.keepon.sushicounter01.ui.ordineFolder

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.keepon.sushicounter01.MenuRecycler
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

        return root
    }

    fun openDesc(){


    }
}