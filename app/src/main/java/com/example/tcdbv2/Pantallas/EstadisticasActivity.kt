package com.example.tcdbv2.Pantallas

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tcdbv2.CLases.Jugador
import com.example.tcdbv2.R
import com.example.tcdbv2.Repositorio.JugadoresRepositorio
import com.example.tcdbv2.Repositorio.ListaEquiposRepositorio.ObtenerLogoPorJugador

class EstadisticasActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaEstadisticas()

        }
    }

    @Preview
    @Composable
    fun PantallaEstadisticas() {
        val listaComposables: List<@Composable () -> Unit> = listOf(
            { Goleadores() },
            //  { Menu() },
            { Amonestados()},
            { Expulsados()},

        )

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Contenido principal
            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                items(listaComposables.size) { index ->
                    Spacer(modifier = Modifier.padding(5.dp))
                    listaComposables[index]()
                }
            }
            BottomBar()
        }}






@Preview
    @Composable

    fun Goleadores() {
        val listaJugadores = JugadoresRepositorio.get1()
    val goleadores= JugadoresRepositorio.DevolverJugadoresConGoles(listaJugadores)

        Box(
            modifier = Modifier
                .height(400.dp)
                .padding(10.dp)
                .background(color = LightGray, shape = RoundedCornerShape(30.dp))
                .clip(RoundedCornerShape(7.dp))

        ) {
            Column(
                modifier = Modifier
                    .background(color =Color.Blue)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()) // Hacer la parte de los jugadores desplazable
            ) {
                Text(
                    text = "GOLEADORES",
                    color = White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(35.dp)
                        .padding(5.dp),
                    textAlign = TextAlign.Center
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                        .background(Color(0xFF68AECE))
                        .border(width = 0.5.dp, color = Color.Black)
                ) {
                    Text(
                        text = "POS",
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        modifier = Modifier
                            .weight(1f)
                            .height(30.dp)
                    )
                    Text(
                        text = "JUGADOR",
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        modifier = Modifier
                            .weight(3f)
                            .height(30.dp)
                    )
                    Text(
                        text = "GOLES",
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        modifier = Modifier
                            .weight(3f)
                            .height(30.dp)
                    )
                }
                var posicion = 0
                JugadoresRepositorio.OrdenarJugadoresPorGoles(goleadores as MutableList<Jugador>)
                goleadores.forEach { jugador ->
                    val logoEquipo = ObtenerLogoPorJugador(jugador)
                    posicion += 1
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(35.dp)
                            .background(Color(0xFFBAE1F3))
                            .border(width = 0.5.dp, color = Color.White)
                            .clickable {}
                            .padding(horizontal = 5.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = posicion.toString(),
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            modifier = Modifier
                                .weight(1f)
                                .background(Color(0xFF68AECE))
                                .height(30.dp)
                        )
                        Image(
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp),
                            painter = painterResource(id = logoEquipo),
                            contentDescription = ""
                        )
                        Text(
                            modifier = Modifier.weight(3f),
                            text = "${jugador.nombre} ${jugador.apellido}",
                            textAlign = TextAlign.Center
                        )
                        Text(
                            modifier = Modifier.weight(3f),
                            text = " ${jugador.goles}",
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }

    @Preview
    @Composable
    fun Amonestados(){
        val listaJugadores = JugadoresRepositorio.get1()
        val amonestados= JugadoresRepositorio.DevolverJugadoresAmonestados(listaJugadores)

        Box(
            modifier = Modifier
                .height(400.dp)
                .padding(10.dp)
                .background(color = LightGray, shape = RoundedCornerShape(30.dp))
                .clip(RoundedCornerShape(7.dp))

        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .background(color =Color.Blue)// Hacer la parte de los jugadores desplazable
            ) {
                Text(
                    text = "AMONESTADOS",
                    color = White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(35.dp)
                        .padding(5.dp),
                    textAlign = TextAlign.Center
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                        .background(Color(0xFF68AECE))
                        .border(width = 0.5.dp, color = Color.Black)
                ) {
                    Text(
                        text = "POS",
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        modifier = Modifier
                            .weight(1f)
                            .height(30.dp)
                    )
                    Text(
                        text = "JUGADOR",
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        modifier = Modifier
                            .weight(3f)
                            .height(30.dp)
                    )
                    Text(
                        text = "AMARILLAS",
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        modifier = Modifier
                            .weight(3f)
                            .height(30.dp)
                    )
                }
                var posicion = 0
                JugadoresRepositorio.OrdenarJugadoresPorAmarillas(amonestados as MutableList<Jugador>)
                amonestados.forEach { jugador ->
                    val logoEquipo = ObtenerLogoPorJugador(jugador)
                    posicion += 1
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(35.dp)
                            .background(Color(0xFFBAE1F3))
                            .border(width = 0.5.dp, color = Color.White)
                            .clickable {}
                            .padding(horizontal = 5.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = posicion.toString(),
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            modifier = Modifier
                                .weight(1f)
                                .background(Color(0xFF68AECE))
                                .height(30.dp)
                        )
                        Image(
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp),
                            painter = painterResource(id = logoEquipo),
                            contentDescription = ""
                        )
                        Text(
                            modifier = Modifier.weight(3f),
                            text = "${jugador.nombre} ${jugador.apellido}",
                            textAlign = TextAlign.Center
                        )
                        Text(
                            modifier = Modifier.weight(3f),
                            text = " ${jugador.amonestaciones}",
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
    @Preview
    @Composable
    fun Expulsados(){
        val listaJugadores = JugadoresRepositorio.get1()
        val expulsados= JugadoresRepositorio.DevolverJugadoresExpulsados(listaJugadores)

        Box(
            modifier = Modifier
                .height(400.dp)
                .padding(10.dp)
                .background(color = LightGray, shape = RoundedCornerShape(30.dp))
                .clip(RoundedCornerShape(7.dp))

        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .background(color =Color.Blue)// Hacer la parte de los jugadores desplazable
            ) {
                Text(
                    text = "EXPULSADOS",
                    color = White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(35.dp)
                        .padding(5.dp),
                    textAlign = TextAlign.Center
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                        .background(Color(0xFF68AECE))
                        .border(width = 0.5.dp, color = Color.Black)
                ) {
                    Text(
                        text = "POS",
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        modifier = Modifier
                            .weight(1f)
                            .height(30.dp)
                    )
                    Text(
                        text = "JUGADOR",
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        modifier = Modifier
                            .weight(3f)
                            .height(30.dp)
                    )
                    Text(
                        text = "ROJAS",
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        modifier = Modifier
                            .weight(3f)
                            .height(30.dp)
                    )
                }
                var posicion = 0
                JugadoresRepositorio.OrdenarJugadoresPorExpulsiones(expulsados as MutableList<Jugador>)
                expulsados.forEach { jugador ->
                    val logoEquipo = ObtenerLogoPorJugador(jugador)
                    posicion += 1
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(35.dp)
                            .background(Color(0xFFBAE1F3))
                            .border(width = 0.5.dp, color = Color.White)
                            .clickable {}
                            .padding(horizontal = 5.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = posicion.toString(),
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            modifier = Modifier
                                .weight(1f)
                                .background(Color(0xFF68AECE))
                                .height(30.dp)
                        )
                        Image(
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp),
                            painter = painterResource(id = logoEquipo),
                            contentDescription = ""
                        )
                        Text(
                            modifier = Modifier.weight(3f),
                            text = "${jugador.nombre} ${jugador.apellido}",
                            textAlign = TextAlign.Center
                        )
                        Text(
                            modifier = Modifier.weight(3f),
                            text = " ${jugador.amonestaciones}",
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }



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
                IconButton(onClick = { }) {
                    Image(
                        painter = painterResource(id = R.drawable.home),
                        contentDescription = "home"
                    )
                }
                Spacer(modifier = Modifier.width(120.dp))
                IconButton(onClick = {  }) {
                    Image(
                        painter = painterResource(id = R.drawable.gol),
                        contentDescription = "goleadores"
                    )
                }
                Spacer(modifier = Modifier.width(120.dp))
                IconButton(onClick = {startActivity(
                    Intent(
                        this@EstadisticasActivity,
                        MainActivity::class.java
                    )

                )  }) {
                    Image(
                        painter = painterResource(id = R.drawable.time),
                        contentDescription = "tiempos"
                    )
                }
            }
        }
    }


}