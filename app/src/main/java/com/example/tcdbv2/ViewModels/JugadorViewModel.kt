package com.example.tcdbv2.ViewModels

import androidx.lifecycle.ViewModel
import com.example.tcdbv2.CLases.Jugador
import com.example.tcdbv2.Repositorio.JugadoresRepositorio

class JugadorViewModel : ViewModel() {

    fun DetalleJugador(dni: Int): Jugador? {
        return JugadoresRepositorio.DatosJugador(dni)
    }
}