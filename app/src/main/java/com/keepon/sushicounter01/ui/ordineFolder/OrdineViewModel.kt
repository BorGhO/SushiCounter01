package com.keepon.sushicounter01.ui.ordineFolder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.keepon.sushicounter01.CoseUtili
import com.keepon.sushicounter01.PiattoClass
import com.keepon.sushicounter01.R

class OrdineViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment " + (CoseUtili.contatore++).toString()
    }
    val text: LiveData<String> = _text

    fun getOrder() : ArrayList<PiattoClass>{

        return itemsFood.value!!
    }

   fun startOrder(){

       if (itemsFood.value == null){

           itemsFood.value = ArrayList<PiattoClass>()

           itemsFood.value?.add(PiattoClass("Futomaki", "Il futomaki ha l'alga all'interno", "salmone", R.drawable.futomaki, false))

           itemsFood.value?.add(PiattoClass("Gunkan", "Il gunkan è l'evoluzione dell'hosomaki", "tonno", R.drawable.gunkan, false))

       }
   }


    companion object {

        var cliccato = false
        var itemsFood : MutableLiveData<ArrayList<PiattoClass>> = MutableLiveData()

    }


}