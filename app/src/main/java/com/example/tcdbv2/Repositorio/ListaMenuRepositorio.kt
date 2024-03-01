package com.example.tcdbv2.Repositorio

import com.example.tcdbv2.CLases.MenuLista

object ListaMenuRepositorio {

    private var listaMenu: MutableList<MenuLista> = mutableListOf()

    init {
        // listaMenu.add(MenuLista.Inicio)
        listaMenu.add(MenuLista.Equipos)
        listaMenu.add(MenuLista.Estadística)
        listaMenu.add(MenuLista.Fixture)
        listaMenu.add(MenuLista.Posiciones)
        listaMenu.add(MenuLista.Resultados)
        listaMenu.add(MenuLista.Torneo)
        listaMenu.add(MenuLista.Contacto)

    }
    fun get( ): MutableList<MenuLista> {
        return listaMenu
    }

}