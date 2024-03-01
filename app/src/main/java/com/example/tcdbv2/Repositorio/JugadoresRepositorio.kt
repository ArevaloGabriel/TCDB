package com.example.tcdbv2.Repositorio

import com.example.tcdbv2.CLases.EquiposEnum
import com.example.tcdbv2.CLases.Jugador
import com.example.tcdbv2.R

object JugadoresRepositorio {
    private var listaJugadores: MutableList<Jugador> = mutableListOf()

    init {
        listaJugadores.add(Jugador("gabriel ","arevalo",30732787,15, EquiposEnum.PHILADELFIA, 2,1,8, R.drawable.logo ))
        listaJugadores.add(Jugador("jorge ","motto",225457845,11, EquiposEnum.PHILADELFIA, 1,2,6, R.drawable.avatar ))
        listaJugadores.add(Jugador("leo  ","trevia",2214521,10, EquiposEnum.PHILADELFIA, 3,0,4, R.drawable.avatar ))
        listaJugadores.add(Jugador("alejo ","garcia",2241578,7, EquiposEnum.PHILADELFIA, 4,1,0, R.drawable.avatar ))
        listaJugadores.add(Jugador("marcelo ","alvarez",3365874,12, EquiposEnum.PHILADELFIA, 1,0,0, R.drawable.avatar ))
        listaJugadores.add(Jugador("roman ","arevalo",39732787,15, EquiposEnum.PHILADELFIA, 2,0,8, R.drawable.logo ))
        listaJugadores.add(Jugador("jorge ","motto",225455845,11, EquiposEnum.PHILADELFIA, 6,0,6, R.drawable.avatar ))
        listaJugadores.add(Jugador("leo  ","trevia",22164521,10, EquiposEnum.PHILADELFIA, 1,0,4, R.drawable.avatar ))
        listaJugadores.add(Jugador("alejo ","garcia",22432578,7, EquiposEnum.PHILADELFIA, 2,0,0, R.drawable.avatar ))
        listaJugadores.add(Jugador("marcelo ","alvarez",3061874,12, EquiposEnum.PHILADELFIA, 3,0,0, R.drawable.avatar ))
        listaJugadores.add(Jugador("marcelo ","alvarez",3365874,12, EquiposEnum.PHILADELFIA, 7,0,0, R.drawable.avatar ))
        listaJugadores.add(Jugador("luis ","arevalo",39732787,15, EquiposEnum.PHILADELFIA, 0,0,8, R.drawable.logo ))
        listaJugadores.add(Jugador("jorge ","motto",225455845,11, EquiposEnum.PHILADELFIA, 0,0,6, R.drawable.avatar ))
        listaJugadores.add(Jugador("leo  ","trevia",22164521,10, EquiposEnum.PHILADELFIA, 0,0,4, R.drawable.avatar ))
        listaJugadores.add(Jugador("alejo ","garcia",22432578,7, EquiposEnum.PHILADELFIA, 0,0,0, R.drawable.avatar ))
        listaJugadores.add(Jugador("marcelo ","alvarez",3061874,12, EquiposEnum.PHILADELFIA, 0,0,0, R.drawable.avatar ))
        listaJugadores.add(Jugador("marcelo ","alvarez",3365874,12, EquiposEnum.PHILADELFIA, 0,0,0, R.drawable.avatar ))
        listaJugadores.add(Jugador("alex ","arevalo",39732787,15, EquiposEnum.PHILADELFIA, 0,0,8, R.drawable.logo ))
        listaJugadores.add(Jugador("jorge ","motto",225455845,11, EquiposEnum.PHILADELFIA, 0,0,6, R.drawable.avatar ))
        listaJugadores.add(Jugador("leo  ","trevia",22164521,10, EquiposEnum.PHILADELFIA, 0,0,4, R.drawable.avatar ))
        listaJugadores.add(Jugador("alejo ","garcia",22432578,7, EquiposEnum.PHILADELFIA, 0,0,0, R.drawable.avatar ))
        listaJugadores.add(Jugador("marcelo ","alvarez",3061874,12, EquiposEnum.PHILADELFIA, 0,0,0, R.drawable.avatar ))

        listaJugadores.add(
            Jugador("gabfsdfriel ","sdfsdfsdfs",3658744,15,
                EquiposEnum.VANCOUVER, 0,0,0, R.drawable.avatar )
        )
        listaJugadores.add(
            Jugador("fsdfdsf ","mottsdfsdfso",12457811,11,
                EquiposEnum.VANCOUVER, 0,1,1, R.drawable.avatar )
        )
        listaJugadores.add(Jugador("sdfsdf  ","sfdfsfdsdf",2547845,10, EquiposEnum.VANCOUVER, 0,0,2, R.drawable.avatar ))
        listaJugadores.add(Jugador("sfsdf ","sfsdfsfsdf",3658745,7, EquiposEnum.VANCOUVER, 0,0,0, R.drawable.avatar ))

        listaJugadores.add(Jugador("torres ","arevalo",548745,15, EquiposEnum.TORONTO, 0,0,0, R.drawable.avatar))
        listaJugadores.add(Jugador("jorge ","motto",122356,11, EquiposEnum.TORONTO, 0,0,5, R.drawable.avatar ))
        listaJugadores.add(Jugador("leo  ","daniel",124978,10, EquiposEnum.TORONTO, 0,0,2, R.drawable.avatar ))
        listaJugadores.add(Jugador("david ","garcia",124778,7, EquiposEnum.TORONTO, 0,0,2, R.drawable.avatar ))
        listaJugadores.add(Jugador("martin ","alvarez",1242378,12, EquiposEnum.TORONTO, 0,0,0, R.drawable.avatar ))


    }
    fun get(equipos: String): MutableList<Jugador> {
        // Filtrar la lista de jugadores para obtener solo los jugadores del Equipo especificado
        return listaJugadores.filter { it.equipo.name.equals(equipos.toString()) }.toMutableList()
    }


    fun get1(): MutableList<Jugador> {
        return listaJugadores
    }
    fun DatosJugador(dni: Int): Jugador? {
        return listaJugadores.find { it.dni == dni }
    }
    fun DevolverJugadoresConGoles(listaJugadores: MutableList<Jugador>): List<Jugador> {
        return listaJugadores.filter { it.goles > 0 }
    }
    fun DevolverJugadoresAmonestados(listaJugadores: MutableList<Jugador>): List<Jugador> {
        return listaJugadores.filter { it.amonestaciones > 0 }
    }
    fun DevolverJugadoresExpulsados(listaJugadores: MutableList<Jugador>): List<Jugador> {
        return listaJugadores.filter { it.expulsiones > 0 }
    }
    fun OrdenarJugadoresPorExpulsiones(listaJugadores:MutableList<Jugador>) {
        return listaJugadores.sortByDescending { it.expulsiones }
    }
    fun OrdenarJugadoresPorAmarillas(listaJugadores:MutableList<Jugador>) {
        return listaJugadores.sortByDescending { it.amonestaciones }
    }
    fun OrdenarJugadoresPorGoles(listaJugadores:MutableList<Jugador>) {
        return listaJugadores.sortByDescending { it.goles }
    }

}
