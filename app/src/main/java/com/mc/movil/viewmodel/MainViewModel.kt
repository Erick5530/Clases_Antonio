package com.mc.movil.viewmodel

import android.content.Context
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _textoSaludo = MutableLiveData("Hola")
    val textoSaludo: LiveData<String> = _textoSaludo

    fun saludarCada3s() {
        viewModelScope.launch(Dispatchers.Default) {
            do {
                Thread.sleep(10000)
                _textoSaludo.postValue(_textoSaludo.value + " 1")
            } while (true)
        }
    }


    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }


}