package com.example.tcdbv2.CLases

data class Partido (var id :Int, var equipoLocal: EquiposEnum, var equipoVisitante: EquiposEnum,
                    var fecha: String,var hora:String, var cancha: Cancha,
                    var golesLocal:Int,
                    var golesVisitante:Int,
                    var amonestadosLocal: List<Jugador> = listOf(),
                    var amonestadosVisitante: List<Jugador> = listOf(),
                    var expulsadosLocal: List<Jugador> = listOf(),
                    var expulsadosVisitante: List<Jugador> = listOf(),
                    var resultado: ResultadoPartido = ResultadoPartido.INDEFINIDO
){


    fun agregarGolLocal() {
        golesLocal++
    }

    fun agregarGolVisitante() {
        golesVisitante++
    }

    fun agregarAmonestacionLocal(jugador: Jugador) {
        jugador.amonestaciones++
        amonestadosLocal+=jugador
    }

    fun agregarAmonestacionVisitante(jugador: Jugador)
    {
        amonestadosVisitante += jugador
    }

    fun agregarExpulsionLocal(jugador: Jugador) {
        expulsadosLocal += jugador
    }

    fun agregarExpulsionVisitante(jugador: Jugador) {
        expulsadosVisitante += jugador
    }
}
