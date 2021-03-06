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

    fun getMenu() : ArrayList<PiattoClass>{

        return itemsFood.value!!
    }

    fun getOrder() : ArrayList<PiattoClass>{

        return orderList.value!!
    }

   fun startMenu(){

       if (itemsFood.value == null){

           itemsFood.value = ArrayList<PiattoClass>()

           itemsFood.value?.add(PiattoClass("Futomaki", "Il futomaki ha l'alga all'interno", "salmone", R.drawable.futomaki, false))

           itemsFood.value?.add(PiattoClass("Gunkan", "Il gunkan è l'evoluzione dell'hosomaki", "tonno", R.drawable.gunkan, false))

       }
   }

    fun startOrder(){

        if (orderList.value == null){

            orderList.value = ArrayList<PiattoClass>()

            orderList.value?.add(PiattoClass("Piatti", "Qui Compariranno i piatti selezionati", "hint", R.drawable.futomaki, false))

            //orderList.value?.add(PiattoClass("Gunkan2", "Il gunkan è l'evoluzione dell'hosomaki", "tonno", R.drawable.gunkan, false))

        }
    }


    fun addToOrder(indice : Int){

        val firstElementOrderListCat = orderList.value?.get(0)?.categ ?: "none"
        if(firstElementOrderListCat  == "hint")
            orderList.value?.removeAt(0)

        orderList.value!!.add(itemsFood.value!![indice])

    }

    companion object {

        var itemsFood : MutableLiveData<ArrayList<PiattoClass>> = MutableLiveData()
        var orderList : MutableLiveData<ArrayList<PiattoClass>> = MutableLiveData()
    }


}