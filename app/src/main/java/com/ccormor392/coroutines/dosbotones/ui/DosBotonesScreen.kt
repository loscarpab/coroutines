package com.ccormor392.coroutines.dosbotones.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun dosBotones(viewModel: DosBotonesViewModel) {
    val colorBoton: Boolean by viewModel.colorBoton.observeAsState(false)
    val resultState: Int by viewModel.resulState.observeAsState(0)
    Column(verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = { viewModel.cambiarColor() },
            colors = ButtonDefaults.buttonColors(containerColor = viewModel.devolverColor(colorBoton))
        ) {
            Text(text = "Cambiar boton")
        }
        Text(text = "Respuesta de la API $resultState")
        Button(
            onClick = { viewModel.bloquearApp() },
        ) {
            Text(text = "Llamar API")
        }
    }
}