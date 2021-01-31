package com.keepon.sushicounter01.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.keepon.sushicounter01.CoseUtili
import com.keepon.sushicounter01.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var buttFHomeProva: Button
    private lateinit var editTextFHomeProva: EditText
    private val viewModel: CoseUtili by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        buttFHomeProva = root.findViewById(R.id.buttFHomeProva)
        editTextFHomeProva = root.findViewById(R.id.editTextFHomeProva)

        buttFHomeProva.setOnClickListener{buttHomeFragPress()}

        return root
    }

    private fun buttHomeFragPress(){

        var coso = editTextFHomeProva.text.toString()
        CoseUtili.textToPass = coso
            viewModel.selectItem(coso)

        println(coso)
    }

}