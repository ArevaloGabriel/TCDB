package com.example.tcdbv2.Pantallas

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.IconButton

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tcdbv2.R
import com.example.tcdbv2.Repositorio.JugadoresRepositorio

import com.example.tcdbv2.ViewModels.JugadorViewModel


class ListaDeJugadoresActivity : ComponentActivity() {
    private val viewModel: JugadorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {

            Column {

                EquipoSeleccionado()

                ListaDeJugadoresPorEquipo(Modifier.weight(1f))
                BottomBar()

            }

        }
    }
    @Preview
    @Composable
    fun EquipoSeleccionado(){
        val nombreEquipo = intent.getStringExtra("Equipo")
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
        ) {
            if (nombreEquipo != null) {
                Text(text = nombreEquipo,
                    modifier = Modifier.align(Alignment.Center)
                    ,fontWeight = FontWeight.Bold,
                    fontSize = 30.sp)
            }
        }
    }
    @Composable
    fun ListaDeJugadoresPorEquipo(modifier: Modifier = Modifier) {
        val nombreEquipo = intent.getStringExtra("Equipo")
        val logoEquipo = intent.getIntExtra("logoEquipo", 0)
        val listaJugadores = nombreEquipo!!.let { JugadoresRepositorio.get1() }
        val jugadoresFiltrados = listaJugadores.filter { it.equipo.name == nombreEquipo }
        val sublistas = jugadoresFiltrados.chunked(4)

        Column(modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp), Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = logoEquipo), contentDescription = "",
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                )
            }
            Spacer(modifier = Modifier.padding(15.dp))
            LazyColumn(
                modifier = Modifier.weight(1f) // Ocupa todo el espacio disponible
            ) {
                items(sublistas.size) { index ->
                    Row(
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        sublistas[index].forEach { jugador ->
                            Box(
                                modifier = Modifier.padding(horizontal = 4.dp)
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Image(
                                        painter = painterResource(id = jugador.fotoPerfil),
                                        contentDescription = "Foto de perfil",
                                        modifier = Modifier
                                            .size(80.dp)
                                            .clickable {
                                                startActivity(
                                                    Intent(
                                                        this@ListaDeJugadoresActivity,
                                                        JugadorActivity::class.java
                                                    )
                                                        .putExtra("dni", jugador.dni)
                                                )
                                            }
                                    )
                                    Text(
                                        text = "${jugador.nombre} ${jugador.apellido}",
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.padding(top = 4.dp),
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    /*  @Preview
      @Composable
      fun  ListaDeJugadoresPorEquipo() {
          val nombreEquipo = intent.getStringExtra("Equipo")
          val logoEquipo = intent.getIntExtra("logoEquipo", 0)
          val listaJugadores = nombreEquipo!!.let { JugadoresRepositorio.get1() }
          val jugadoresFiltrados = listaJugadores.filter { it.Equipo.name == nombreEquipo }
          val sublistas = jugadoresFiltrados.chunked(4)
          Column() {
              Box(
                  modifier = Modifier
                      .fillMaxWidth()
                      .height(100.dp), Alignment.Center
              ) {
                  Image(
                      painter = painterResource(id = logoEquipo), contentDescription = "",
                      modifier = Modifier
                          .width(100.dp)
                          .height(100.dp)
                  )
              }
              Spacer(modifier = Modifier.padding(15.dp))
              LazyColumn(
                  modifier = Modifier.fillMaxSize()
              ) {
                  items(sublistas.size) { index ->
                      Row(
                          modifier = Modifier.padding(bottom = 8.dp)
                      ) {
                          sublistas[index].forEach { jugador ->
                              Box(
                                  modifier = Modifier.padding(horizontal = 4.dp)
                              ) {
                                  Column(
                                      horizontalAlignment = Alignment.CenterHorizontally
                                  ) {
                                      Image(
                                          painter = painterResource(id = jugador.fotoPerfil),
                                          contentDescription = "Foto de perfil",
                                          modifier = Modifier
                                              .size(80.dp)
                                              .clickable {
                                                  startActivity(
                                                      Intent(
                                                          this@ListaDeJugadoresActivity,
                                                          JugadorActivity::class.java
                                                      )
                                                          .putExtra("dni", jugador.dni)
                                                  )
                                              }
                                      )
                                      Text(
                                          text = "${jugador.nombre} ${jugador.apellido}",
                                          textAlign = TextAlign.Center,
                                          modifier = Modifier.padding(top = 4.dp),
                                          fontWeight = FontWeight.Bold
                                      )
                                  }
                              }
                          }
                      }
                  }
              }
          }
      }
  */

    @Preview
    @Composable
    fun BottomBar() {
        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.Blue)

        ) {
            Row(
                modifier = Modifier
                    .background(Color.Blue)
                    .padding(start = 8.dp, end = 8.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {  }) {
                    Image(
                        painter = painterResource(id = R.drawable.gol),
                        contentDescription = "goleadores"
                    )
                }
                IconButton(onClick = {  }) {
                    Image(
                        painter = painterResource(id = R.drawable.time),
                        contentDescription = "tiempos"
                    )
                }
                IconButton(onClick = { startActivity(Intent(this@ListaDeJugadoresActivity, MainActivity ::class.java)) }) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
                        contentDescription = "atras"
                    )
                }

            }
        }
    }


}
