package com.ccormor392.coroutines.dosbotones.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class DosBotonesViewModel:ViewModel() {

    private var _resultState = MutableLiveData<Int>()
    var resulState : LiveData<Int> = _resultState
    private var _colorBoton = MutableLiveData<Boolean>(false)
    var colorBoton : LiveData<Boolean> = _colorBoton

    fun bloquearApp(){
        Thread.sleep(5000)
        _resultState.value = _resultState.value?.plus(1)
    }
    fun cambiarColor(){
        _colorBoton.value = !_colorBoton.value!!
    }
    fun devolverColor(bool:Boolean):Color{
        return if(bool) Color.Blue
        else Color.Red
    }


}