package com.example.tcdbv2.CLases

data class Jugador(var nombre:String, var apellido:String,
                   var dni:Int, var numeroCamiseta:Int,
                   val equipo : EquiposEnum, var amonestaciones:Int,
                   var expulsiones :Int, var goles :Int, val fotoPerfil: Int)
