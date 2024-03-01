package com.example.tcdbv2.Repositorio

import android.annotation.SuppressLint
import com.example.tcdbv2.CLases.Equipo
import com.example.tcdbv2.CLases.EquiposEnum
import com.example.tcdbv2.CLases.Jugador
import com.example.tcdbv2.R

object ListaEquiposRepositorio {


    private var listaEquipos: MutableList<Equipo> = mutableListOf()

    //var jugadores = TraerJugadoresDeEquipo(EquiposEnum.PHILADELFIA)
    init {
        listaEquipos.add(Equipo(
            EquiposEnum.PHILADELFIA, R.drawable.philadelphia,0,2,5,0,1,5,1,TraerJugadoresDeEquipo(
                EquiposEnum.PHILADELFIA)))
        listaEquipos.add(Equipo(
            EquiposEnum.TORONTO,  R.drawable.toronto   ,0,2,2,0,3,4,2,TraerJugadoresDeEquipo(
                EquiposEnum.TORONTO) ))
        listaEquipos.add(Equipo(
            EquiposEnum.VANCOUVER,  R.drawable.vancouver,0,2,4,1,0,0,4,TraerJugadoresDeEquipo(
                EquiposEnum.VANCOUVER)))
        listaEquipos.add(Equipo(
            EquiposEnum.DCUNITED, R.drawable.dcunited,0,2,0,0,0,3,5,TraerJugadoresDeEquipo(
                EquiposEnum.DCUNITED)))
        listaEquipos.add(Equipo(
            EquiposEnum.COLUMBUS, R.drawable.columbus,0,2,5,0,1,2,1, TraerJugadoresDeEquipo(
                EquiposEnum.COLUMBUS)))
        listaEquipos.add(Equipo(
            EquiposEnum.CINCINATI, R.drawable.cincinati,0,2,0,0,0,4,9,TraerJugadoresDeEquipo(
                EquiposEnum.CINCINATI)))
        listaEquipos.add(Equipo(
            EquiposEnum.INTERMIAMI, R.drawable.intermiami,0,2,0,0,0,10,2,TraerJugadoresDeEquipo(
                EquiposEnum.INTERMIAMI)))
        listaEquipos.add(Equipo(
            EquiposEnum.PORTLAND, R.drawable.portland,0,2,1,0,0,2,3,TraerJugadoresDeEquipo(
                EquiposEnum.PORTLAND)))
        listaEquipos.add(Equipo(
            EquiposEnum.NASHVILLE, R.drawable.nashville,0,2,1,0,0,7,1,TraerJugadoresDeEquipo(
                EquiposEnum.NASHVILLE)))
        listaEquipos.add(Equipo(
            EquiposEnum.DALLAS, R.drawable.dallas,0,2,3,0,0,7,1,TraerJugadoresDeEquipo(
                EquiposEnum.DALLAS)))
    }
    fun get( ): List<Equipo> {
        return listaEquipos
    }

    @SuppressLint("SuspiciousIndentation")
    fun TraerJugadoresDeEquipo(equipos: EquiposEnum):List<Jugador>{
        val jugadores= JugadoresRepositorio.get(equipos.name)
        return  jugadores.filter { it.equipo == equipos }
    }

    fun ObtenerLogoPorJugador(jugador: Jugador): Int {
        val equipo = listaEquipos.firstOrNull { it.nombre == jugador.equipo }
        return equipo?.logo ?: R.drawable.gol // Si no se encuentra el logo, retorna un logo predeterminado
    }
    fun ObtenerLogoPorEquipo(equipo: String): Int {
        val equipo = listaEquipos.firstOrNull { it.nombre.toString() == equipo }
        return equipo?.logo ?: R.drawable.gol // Si no se encuentra el logo, retorna un logo predeterminado
    }


   fun ordenarEquiposPorPuntos(listaequipos: MutableList<Equipo>) {
       listaequipos.sortWith(compareByDescending<Equipo> { it.puntos }
           .thenByDescending { it.golesAFavor-it.golesEnContra }.thenByDescending { it.partidoGanado })
   }
}