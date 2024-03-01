package com.example.tcdbv2.CLases

data class Equipo(val nombre : EquiposEnum, var logo:Int,
                  var puntos :Int,
                  var partidosjugados:Int,
                  var partidoGanado :Int,
                  var partidoPerdido :Int,
                  var partidoEmpatado :Int,
                  var golesAFavor:Int,
                  var golesEnContra:Int,
                  var jugadores:List<Jugador>){

    fun calcularDiferenciaDeGoles(): Int {
        val diferencia = golesAFavor - golesEnContra
        return diferencia
    }

    fun calcularPuntos(equipo:Equipo){
        equipo.puntos = partidoGanado * 3 + partidoEmpatado
    }




}
