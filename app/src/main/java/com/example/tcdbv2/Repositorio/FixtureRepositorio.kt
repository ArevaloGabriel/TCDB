package com.example.tcdbv2.Repositorio

import com.example.tcdbv2.CLases.Fecha
import com.example.tcdbv2.CLases.Fixture
import com.example.tcdbv2.CLases.Partido

object FixtureRepositorio {

    private val fixture: MutableList<Fecha> = mutableListOf()
    private val fecha1 = fechasRepositorio.get(1)
    private val fecha2 =fechasRepositorio.get(2)
    private val fecha3=fechasRepositorio.get(3)

    init {

        if (fecha1 != null) {
            fixture.add(fecha1)
        }

        if (fecha2 != null) {
            fixture.add(fecha2)
        }
        if (fecha3!= null) {
            fixture.add(fecha3)
        }

    }

   fun DevolverFecha(id: Int): Fecha? {
        return fixture.find { it.id == id }
    }

    fun DevolverFixture(): MutableList<Fecha> {
        return fixture
    }
}