package com.example.tcdbv2.Pantallas

import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tcdbv2.CLases.Equipo
import com.example.tcdbv2.R
import com.example.tcdbv2.Repositorio.FixtureRepositorio
import com.example.tcdbv2.Repositorio.JugadoresRepositorio
import com.example.tcdbv2.Repositorio.ListaEquiposRepositorio
import com.example.tcdbv2.Repositorio.ListaEquiposRepositorio.ObtenerLogoPorJugador
import com.example.tcdbv2.Repositorio.fechasRepositorio


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            PantallaPrincipal()

        }
    }


    @Composable
    fun PantallaPrincipal() {
        val listaComposables: List<@Composable () -> Unit> = listOf(
            { LogoPrincipal() },
            //  { Menu() },
            { tabla() },
            { proximosPartidos() },
            {Goleadores()}
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
        }
    }
    @Preview
    @Composable
    fun LogoPrincipal() {
        Box(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .height(70.dp)
                .background(Color.Blue, shape = RoundedCornerShape(7.dp))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Imagen
                Image(
                    painter = painterResource(id = R.drawable.logo), // Reemplaza con tu imagen
                    contentDescription = "logo", // Agrega una descripción si es necesario
                    modifier = Modifier.size(48.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column(
                    modifier = Modifier
                        .weight(1f) // Para que ocupe el espacio restante en el Row
                ) {
                    Text(
                        text = "Torneo Casa Don Bosco",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                    Text(
                        text = "Casa Salesiana Don Bosco de Ramos Mejia",
                        fontSize = 12.sp,
                        color = Color.White
                    )
                }
            }
        }
    }


    @Preview
    @SuppressLint("SuspiciousIndentation")
    @Composable
    fun tabla(){

        val equipos = ListaEquiposRepositorio.get()

        Column() {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .height(400.dp)
                    .background(color = LightGray, shape = RoundedCornerShape(30.dp))
                    .clip(RoundedCornerShape(7.dp))
                    //.padding(10.dp) // Agregamos padding para que el contenido no esté pegado a los bordes redondeados
                    .align(CenterHorizontally)
            ) {
                Column(modifier =Modifier.background(Color.Blue)) {
                    Text(text = "TABLA GENERAL",
                        color = White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(35.dp)
                            .padding(5.dp),
                        textAlign = TextAlign.Center

                    )
                    Box(
                        modifier = Modifier
                            .background(color = Color.Blue, shape = RoundedCornerShape(3.dp))
                            .fillMaxWidth()
                    ) {

                    }

                    Box(
                        modifier = Modifier
                            .background(Color(0xFF68AECE))
                            .fillMaxWidth()
                            .height(20.dp)
                            .border(width = 0.dp, color = Color.Black)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Spacer(modifier = Modifier.padding(16.dp))
                            Text(text = "EQUIPO",modifier= Modifier
                                .width(140.dp), textAlign = TextAlign.Center, color =Color.White
                            )
                            Text(text = "J", modifier = Modifier.width(30.dp), textAlign = TextAlign.Center, color =Color.White)

                            Text(text = "G", modifier = Modifier.width(30.dp), color =Color.White, textAlign = TextAlign.Center)

                            Text(text = "E", modifier = Modifier.width(30.dp), color =Color.White, textAlign = TextAlign.Center)

                            Text(text = "P", modifier = Modifier.width(30.dp), color =Color.White, textAlign = TextAlign.Center)

                            Text(text = "DG", modifier = Modifier.width(30.dp), color =Color.White, textAlign = TextAlign.Center)

                            Text(text = "PTS", modifier = Modifier.width(35.dp), color =Color.White, textAlign = TextAlign.Center)
                        }

                    }
                    equipos.forEach { equipo->
                        equipo.calcularPuntos(equipo)
                    }
                    ListaEquiposRepositorio.ordenarEquiposPorPuntos(equipos as MutableList<Equipo>)

                    var posicion:Int =0
                    equipos.forEach { equipo ->
                        posicion+=1
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(30.dp)
                                .background(Color(0xFFBAE1F3))
                                .border(width = 0.5.dp, color = Color.White)

                                .clickable {/*
                                    startActivity(
                                        Intent(
                                            this@MainActivity,
                                            ListaDeJugadoresActivity::class.java
                                        )
                                            .putExtra("Equipo", equipo.nombre.toString())
                                            .putExtra("logoEquipo", equipo.logo)
                                    )*/ }
                            , verticalAlignment =  Alignment.CenterVertically
                        ) {
                            Text(text ="  "+ posicion.toString(), color =Color.White ,modifier= Modifier
                                .background(Color(0xFF68AECE))
                                .width(30.dp)
                                .fillMaxHeight())
                            Spacer(modifier = Modifier.padding(1.dp))
                            Text(modifier = Modifier.width(140.dp),text = equipo.nombre.toString())

                            Text(text = " "+equipo.partidosjugados.toString(),modifier=Modifier.width(30.dp), textAlign = TextAlign.Center)

                            Text(text =" "+ equipo.partidoGanado.toString(),modifier=Modifier.width(30.dp), textAlign = TextAlign.Center)

                            Text(text =" "+ equipo.partidoEmpatado.toString(),modifier=Modifier.width(30.dp), textAlign = TextAlign.Center)

                            Text(text =" "+ equipo.partidoPerdido.toString(),modifier=Modifier.width(30.dp), textAlign = TextAlign.Center)

                            Text(text = equipo.calcularDiferenciaDeGoles().toString(),modifier=Modifier.width(30.dp), textAlign = TextAlign.Center)

                            Text(text = equipo.puntos.toString(),modifier=Modifier.width(35.dp),
                                textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    }

    @Preview
    @Composable
    fun proximosPartidos() {
        val fixture = FixtureRepositorio.DevolverFecha(1)
        Column() {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .height(250.dp)
                    .background(color = LightGray, shape = RoundedCornerShape(30.dp))
                    .clip(RoundedCornerShape(7.dp))
                    //.padding(10.dp) // Agregamos padding para que el contenido no esté pegado a los bordes redondeados
                    .align(CenterHorizontally)
                //.border(width = 2.dp, color = Color.Black)

            ) {
                Column(modifier =Modifier.background(Color.Blue)) {
                    Text(text = "PROXIMOS PARTIDOS",
                        color = White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(35.dp)
                            .padding(5.dp),
                        textAlign = TextAlign.Center

                    )
                    Box(
                        modifier = Modifier
                            .background(color = Color.Blue, shape = RoundedCornerShape(3.dp))
                            .fillMaxWidth()
                    ) {

                    }

                    Box(
                        modifier = Modifier
                            .background(Color(0xFF68AECE))
                            .fillMaxWidth()
                            .height(20.dp)
                            .border(width = 0.5.dp, color = Color.White)
                    ) {
                        Row(verticalAlignment = CenterVertically) {

                            Text(text = " LOCAL",modifier= Modifier
                                .width(106.dp), color =Color.White, textAlign = TextAlign.Center )

                            Text(text = " CANCHA", color =Color.White, textAlign = TextAlign.Center,modifier=Modifier.width(65.dp))

                            Text(text = " FECHA", color =Color.White, textAlign = TextAlign.Center,modifier=Modifier.width(48.dp))

                            Text(text = " HORA", color =Color.White, textAlign = TextAlign.Center,modifier=Modifier.width(48.dp))

                            Text(text = " VISITANTE", color =Color.White,modifier= Modifier.width(106.dp), textAlign = TextAlign.Center)
                        }
                    }

                    if (fixture != null) {
                        fixture.listaPartidos.forEach { partido ->

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(30.dp)
                                    .background(Color(0xFFBAE1F3))
                                    .border(width = 0.5.dp, color = Color.White)
                                    // .align(CenterHorizontally)

                                    .clickable {
                                        startActivity(
                                            Intent(
                                                this@MainActivity,
                                                DatosDelPartidoActivity::class.java
                                            )
                                                .putExtra("idFecha",fixture.id)
                                                .putExtra("idPartido", partido.id)
                                        )

                                    }
                            ) {

                                Text(modifier = Modifier
                                    .width(106.dp)
                                    .fillMaxHeight(),text = partido.equipoLocal.toString(), textAlign = TextAlign.Center)

                                Text(text = partido.cancha.toString(),modifier = Modifier
                                    .width(65.dp)
                                    .fillMaxHeight(), textAlign = TextAlign.Center)

                                Text(text =partido.fecha.toString(),modifier = Modifier
                                    .width(48.dp)
                                    .fillMaxHeight(), textAlign = TextAlign.Center)

                                Text(text =partido.hora,modifier = Modifier
                                    .width(48.dp)
                                    .fillMaxHeight(), textAlign = TextAlign.Center)

                                Text(text =partido.equipoVisitante.toString(),modifier= Modifier
                                    .width(106.dp)
                                    .fillMaxHeight(), textAlign = TextAlign.Center)
                            }
                        }
                    }
                }
            }
        }


    }


    @Preview
    @Composable
    fun Goleadores(){
        val listaJugadores = JugadoresRepositorio.get1()
        Column() {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .height(250.dp)
                    .background(color = LightGray, shape = RoundedCornerShape(30.dp))
                    .clip(RoundedCornerShape(7.dp))
                    //.padding(10.dp) // Agregamos padding para que el contenido no esté pegado a los bordes redondeados
                    .align(CenterHorizontally)
                //.border(width = 2.dp, color = Color.Black)

            ) {
                Column(modifier =Modifier.background(Color.Blue)) {
                    Text(text = "GOLEADORES",
                        color = White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(35.dp)
                            .padding(5.dp),
                        textAlign = TextAlign.Center

                    )
                    Box(
                        modifier = Modifier
                            .background(color = Color.Blue, shape = RoundedCornerShape(3.dp))
                            .fillMaxWidth()
                    ) {

                    }
                    Row( modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                        .background(Color(0xFF68AECE))
                        .border(width = 0.5.dp, color = Color.Black))
                    {
                        Text(
                            text = "POS",textAlign = TextAlign.Center, color =Color.White, modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                        )
                        Text(
                            text = "JUGADOR",textAlign = TextAlign.Center, color =Color.White, modifier = Modifier
                                .width(160.dp)
                                .height(30.dp)
                        )
                        Text(
                            text = "GOLES",textAlign = TextAlign.Center, color =Color.White, modifier = Modifier
                                .width(160.dp)
                                .height(30.dp)
                        )


                    }
                    var posicion=0
                    JugadoresRepositorio.OrdenarJugadoresPorGoles(listaJugadores)
                    listaJugadores.take(5). forEach{jugador->
                        val logoEquipo = ObtenerLogoPorJugador(jugador)
                        posicion+=1
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(30.dp)
                                .background(Color(0xFFBAE1F3))
                                .border(width = 0.5.dp, color = Color.White)
                                .clickable {
                                }, verticalAlignment = Alignment.CenterVertically
                        ) {

                            Text(
                                text = posicion.toString(),textAlign = TextAlign.Center,color = Color.White, modifier = Modifier
                                    .background(Color(0xFF68AECE))
                                    .width(30.dp)
                                    .height(30.dp)
                            )
                            Image(modifier= Modifier
                                .width(30.dp)
                                .height(30.dp),
                                painter = painterResource(id =  logoEquipo), contentDescription = "")

                            Text(modifier = Modifier.width(130.dp),
                                text = jugador.nombre+jugador.apellido, textAlign = TextAlign.Center)

                            Text(
                                text = " " + jugador.goles.toString(),
                                modifier = Modifier.width(160.dp),
                                textAlign = TextAlign.Center
                            )


                        }
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
                IconButton(onClick = { startActivity(
                    Intent(
                        this@MainActivity,
                        EstadisticasActivity::class.java
                    )

                ) }) {
                    Image(
                        painter = painterResource(id = R.drawable.gol),
                        contentDescription = "goleadores"
                    )
                }
                Spacer(modifier = Modifier.width(120.dp))
                IconButton(onClick = {startActivity(
                    Intent(
                        this@MainActivity,
                        FechasActivity::class.java
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

