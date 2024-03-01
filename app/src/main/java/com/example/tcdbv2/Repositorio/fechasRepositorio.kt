package com.example.tcdbv2.Repositorio

import com.example.tcdbv2.CLases.Cancha
import com.example.tcdbv2.CLases.EquiposEnum
import com.example.tcdbv2.CLases.Fecha
import com.example.tcdbv2.CLases.Partido
import com.example.tcdbv2.CLases.ResultadoPartido

/*object fechasRepositorio {

private var ListaDeFechas:MutableList<Fecha> = mutableListOf()
    private var fecha1: MutableList<Partido> = mutableListOf()
    private var fecha2: MutableList<Partido> = mutableListOf()

    init {
        fecha1.add(
            Partido(
                1, EquiposEnum.PHILADELFIA, EquiposEnum.DALLAS, "25/03", "08:00", Cancha.BAU, 0, 0,
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(), ResultadoPartido.INDEFINIDO
            )
        )
        fecha1.add(
            Partido(
                2,
                EquiposEnum.COLUMBUS,
                EquiposEnum.CINCINATI,
                "25/03",
                "10:00",
                Cancha.BAU,
                0,
                0,
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                ResultadoPartido.INDEFINIDO
            )
        )
        fecha1.add(
            Partido(
                3,
                EquiposEnum.NASHVILLE,
                EquiposEnum.DCUNITED,
                "25/03",
                "11:30",
                Cancha.BAU,
                0,
                0,
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                ResultadoPartido.INDEFINIDO
            )
        )
        fecha1.add(
            Partido(
                4,
                EquiposEnum.INTERMIAMI,
                EquiposEnum.PORTLAND,
                "25/03",
                "08:00",
                Cancha.PEDRO,
                0,
                0,
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                ResultadoPartido.INDEFINIDO
            )
        )
        fecha1.add(
            Partido(
                5,
                EquiposEnum.TORONTO,
                EquiposEnum.VANCOUVER,
                "25/03",
                "10:00",
                Cancha.PEDRO,
                0,
                0,
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                ResultadoPartido.INDEFINIDO
            )
        )
        fecha2.add(
            Partido(
                1,
                EquiposEnum.PHILADELFIA,
                EquiposEnum.COLUMBUS,
                "25/03",
                "08:00",
                Cancha.BAU,
                0,
                0,
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                ResultadoPartido.INDEFINIDO
            )
        )
        fecha2.add(
            Partido(
                2,
                EquiposEnum.DALLAS,
                EquiposEnum.CINCINATI,
                "25/03",
                "10:00",
                Cancha.BAU,
                0,
                0,
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                ResultadoPartido.INDEFINIDO
            )
        )
        fecha2.add(
            Partido(
                3,
                EquiposEnum.PORTLAND,
                EquiposEnum.DCUNITED,
                "25/03",
                "11:30",
                Cancha.BAU,
                0,
                0,
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                ResultadoPartido.INDEFINIDO
            )
        )
        fecha2.add(
            Partido(
                4,
                EquiposEnum.VANCOUVER,
                EquiposEnum.NASHVILLE,
                "25/03",
                "08:00",
                Cancha.PEDRO,
                0,
                0,
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                ResultadoPartido.INDEFINIDO
            )
        )
        fecha2.add(
            Partido(
                5,
                EquiposEnum.TORONTO,
                EquiposEnum.INTERMIAMI,
                "25/03",
                "10:00",
                Cancha.PEDRO,
                0,
                0,
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                ResultadoPartido.INDEFINIDO
            )
        )

    }

    fun get(numeroFecha :Int): Fecha? {
        return  ListaDeFechas.find {it.id == numeroFecha  }

    }

    fun DatosPartido(id: Int): Partido? {
        return fecha1.find { it.id == id }
    }
}*/
object fechasRepositorio {
    private val ListaDeFechas: MutableList<Fecha> = mutableListOf()

    init {
        val fecha1 = mutableListOf(

                Partido(
                    1, EquiposEnum.PHILADELFIA, EquiposEnum.DALLAS, "25/03", "08:00", Cancha.BAU, 0, 0,
                    emptyList(),
                    emptyList(),
                    emptyList(),
                    emptyList(), ResultadoPartido.INDEFINIDO
                ),
                    Partido(
                        2,
                        EquiposEnum.COLUMBUS,
                        EquiposEnum.CINCINATI,
                        "25/03",
                        "10:00",
                        Cancha.BAU,
                        0,
                        0,
                        emptyList(),
                        emptyList(),
                        emptyList(),
                        emptyList(),
                        ResultadoPartido.INDEFINIDO
                    ),
                    Partido(
                        3,
                        EquiposEnum.NASHVILLE,
                        EquiposEnum.DCUNITED,
                        "25/03",
                        "11:30",
                        Cancha.BAU,
                        0,
                        0,
                        emptyList(),
                        emptyList(),
                        emptyList(),
                        emptyList(),
                        ResultadoPartido.INDEFINIDO
                    ),
                    Partido(
                        4,
                        EquiposEnum.INTERMIAMI,
                        EquiposEnum.PORTLAND,
                        "25/03",
                        "08:00",
                        Cancha.PEDRO,
                        0,
                        0,
                        emptyList(),
                        emptyList(),
                        emptyList(),
                        emptyList(),
                        ResultadoPartido.INDEFINIDO
                    ),
                    Partido(
                        5,
                        EquiposEnum.TORONTO,
                        EquiposEnum.VANCOUVER,
                        "25/03",
                        "10:00",
                        Cancha.PEDRO,
                        0,
                        0,
                        emptyList(),
                        emptyList(),
                        emptyList(),
                        emptyList(),
                        ResultadoPartido.INDEFINIDO

                    )
        )
        val fecha2 = mutableListOf(
                Partido(
                    1,
                    EquiposEnum.PHILADELFIA,
                    EquiposEnum.COLUMBUS,
                    "25/03",
                    "08:00",
                    Cancha.BAU,
                    0,
                    0,
                    emptyList(),
                    emptyList(),
                    emptyList(),
                    emptyList(),
                    ResultadoPartido.INDEFINIDO
                ),


                    Partido(
                        2,
                        EquiposEnum.DALLAS,
                        EquiposEnum.CINCINATI,
                        "25/03",
                        "10:00",
                        Cancha.BAU,
                        0,
                        0,
                        emptyList(),
                        emptyList(),
                        emptyList(),
                        emptyList(),
                        ResultadoPartido.INDEFINIDO
                    ),


                    Partido(
                        3,
                        EquiposEnum.PORTLAND,
                        EquiposEnum.DCUNITED,
                        "25/03",
                        "11:30",
                        Cancha.BAU,
                        0,
                        0,
                        emptyList(),
                        emptyList(),
                        emptyList(),
                        emptyList(),
                        ResultadoPartido.INDEFINIDO
                    ),


                    Partido(
                        4,
                        EquiposEnum.VANCOUVER,
                        EquiposEnum.NASHVILLE,
                        "25/03",
                        "08:00",
                        Cancha.PEDRO,
                        0,
                        0,
                        emptyList(),
                        emptyList(),
                        emptyList(),
                        emptyList(),
                        ResultadoPartido.INDEFINIDO

                    ),

                    Partido(
                        5,
                        EquiposEnum.TORONTO,
                        EquiposEnum.INTERMIAMI,
                        "25/03",
                        "10:00",
                        Cancha.PEDRO,
                        0,
                        0,
                        emptyList(),
                        emptyList(),
                        emptyList(),
                        emptyList(),
                        ResultadoPartido.INDEFINIDO
                    )
        )
        val fecha3 = mutableListOf(
                Partido(
                    1,
                    EquiposEnum.PHILADELFIA,
                    EquiposEnum.PORTLAND,
                    "25/03",
                    "08:00",
                    Cancha.BAU,
                    0,
                    0,
                    emptyList(),
                    emptyList(),
                    emptyList(),
                    emptyList(),
                    ResultadoPartido.INDEFINIDO
                ),


        Partido(
            2,
            EquiposEnum.COLUMBUS,
            EquiposEnum.VANCOUVER,
            "25/03",
            "10:00",
            Cancha.BAU,
            0,
            0,
            emptyList(),
            emptyList(),
            emptyList(),
            emptyList(),
            ResultadoPartido.INDEFINIDO
        ),


        Partido(
            3,
            EquiposEnum.NASHVILLE,
            EquiposEnum.DCUNITED,
            "25/03",
            "11:30",
            Cancha.BAU,
            0,
            0,
            emptyList(),
            emptyList(),
            emptyList(),
            emptyList(),
            ResultadoPartido.INDEFINIDO
        ),


        Partido(
            4,
            EquiposEnum.DALLAS,
            EquiposEnum.TORONTO,
            "25/03",
            "08:00",
            Cancha.PEDRO,
            0,
            0,
            emptyList(),
            emptyList(),
            emptyList(),
            emptyList(),
            ResultadoPartido.INDEFINIDO

        ),

        Partido(
            5,
            EquiposEnum.CINCINATI,
            EquiposEnum.INTERMIAMI,
            "25/03",
            "10:00",
            Cancha.PEDRO,
            0,
            0,
            emptyList(),
            emptyList(),
            emptyList(),
            emptyList(),
            ResultadoPartido.INDEFINIDO
        )


        )

        ListaDeFechas.add(Fecha(1, fecha1))
        ListaDeFechas.add(Fecha(2, fecha2))
        ListaDeFechas.add(Fecha(3, fecha3))
    }

    fun get(id: Int): Fecha? {
        return ListaDeFechas.find { it.id == id }
    }

    fun DatosPartidoPorFecha(idFecha: Int,idPartido:Int): Partido? {

        val numeroFecha = get(idFecha)
     val partido = numeroFecha?.listaPartidos?.find { it.id==idPartido }

        return partido
    }






}

