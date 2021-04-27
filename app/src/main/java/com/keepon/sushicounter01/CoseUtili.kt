package com.keepon.sushicounter01


import android.content.ClipData
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.reflect.typeOf

class CoseUtili : ViewModel(){

    private val mutableSelectedItem = MutableLiveData<Any>()
    val selectedItem: LiveData<Any> get() = mutableSelectedItem

    fun selectItem(item: Any) {
        mutableSelectedItem.value = item
    }


    companion object {

        var contatore = 0
        var textToPass :String? = null
        var provaListaMenu = ArrayList<PiattoClass>()
    }
}