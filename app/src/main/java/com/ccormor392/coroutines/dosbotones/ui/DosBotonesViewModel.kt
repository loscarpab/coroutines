package com.ccormor392.coroutines.dosbotones.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class DosBotonesViewModel:ViewModel() {

    private var _resultState = MutableLiveData<Int>(0)
    var resulState : LiveData<Int> = _resultState
    private var _colorBoton = MutableLiveData<Boolean>(false)
    var colorBoton : LiveData<Boolean> = _colorBoton
    private val _estaCargando = MutableLiveData<Boolean>(false)
    val estaCargando: LiveData<Boolean> = _estaCargando

    fun bloquearApp() {
        //Nos permite crear una corrutina desde un ViewModel
        viewModelScope.launch {
            try {
                _estaCargando.value = true
                llamarApi()
            } catch (e: Exception) {
                println("Error ${e.message}")
            } finally {
                _estaCargando.value = false
            }
        }
    }
    private suspend fun llamarApi(){
        val result = withContext(Dispatchers.IO) {
            delay(5000)
            resulState.value!!.plus(1)
        }
        _resultState.value = result
    }

    fun cambiarColor(){
        _colorBoton.value = !_colorBoton.value!!
    }
    fun devolverColor(bool:Boolean):Color{
        return if(bool) Color.Blue
        else Color.Red
    }


}