package com.keepon.sushicounter01.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.keepon.sushicounter01.CoseUtili

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment " + (CoseUtili.contatore++).toString()
    }
    val text: LiveData<String> = _text
}