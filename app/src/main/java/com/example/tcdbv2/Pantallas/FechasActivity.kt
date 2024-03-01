package com.example.tcdbv2.Pantallas

import android.content.Intent
import android.graphics.Paint.Align
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tcdbv2.R
import com.example.tcdbv2.Repositorio.FixtureRepositorio

class FechasActivity : ComponentActivity() {
   
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {
            PantallaFechas()
        }
    }

    @Preview
    @Composable
    fun PantallaFechas() {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Contenido principal
            Column(
                modifier = Modifier.weight(1f)
            ) {
                MostrarFechas()


                }
            BottomBar()
            }


        }




      /*  @Preview
        @Composable
        fun MostrarFechas() {
            val fixture = FixtureRepositorio.DevolverFixture()
            var posicion=0
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 10.dp)
            ) {
                items(fixture.size) { numeroFecha ->
                     posicion ++
                    val fecha = fixture[numeroFecha]

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                            .background(color = Color.LightGray, shape = RoundedCornerShape(30.dp))
                            .clip(RoundedCornerShape(7.dp))
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(10.dp)
                        ) {
                            Text(
                                text = "Fecha ${numeroFecha + 1}",
                                color = Color.White,
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
                                    .height(20.dp)
                            ) {
                                // Contenido de la caja
                            }

                            Box(
                                modifier = Modifier
                                    .background(Color(0xFF68AECE))
                                    .fillMaxWidth()
                                    .height(20.dp)
                                    .border(width = 0.5.dp, color = Color.White)
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = " LOCAL",
                                        modifier = Modifier.width(106.dp),
                                        color = Color.White,
                                        textAlign = TextAlign.Center
                                    )

                                    Text(
                                        text = " CANCHA",
                                        color = Color.White,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.width(65.dp)
                                    )

                                    Text(
                                        text = " FECHA",
                                        color = Color.White,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.width(48.dp)
                                    )

                                    Text(
                                        text = " HORA",
                                        color = Color.White,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.width(48.dp)
                                    )

                                    Text(
                                        text = " VISITANTE",
                                        color = Color.White,
                                        modifier = Modifier.width(106.dp),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                            val fecha = FixtureRepositorio.DevolverFecha(numeroFecha)
                            if (fecha != null) {
                                fecha.listaPartidos.forEach {  partido ->
                                    //fecha.listaPartidos.forEach { partido ->
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(30.dp)
                                            .background(Color(0xFFBAE1F3))
                                            .border(width = 0.5.dp, color = Color.White)
                                            .clickable {
                                                startActivity(
                                                    Intent(
                                                        this@FechasActivity,
                                                        DatosDelPartidoActivity::class.java
                                                    )
                                                        .putExtra("idPartido", partido.id)
                                                )
                                            }
                                    ) {
                                        Text(
                                            modifier = Modifier.width(106.dp).fillMaxHeight(),
                                            text = partido.equipoLocal.toString(),
                                            textAlign = TextAlign.Center
                                        )

                                        Text(
                                            text = partido.cancha.toString(),
                                            modifier = Modifier.width(65.dp).fillMaxHeight(),
                                            textAlign = TextAlign.Center
                                        )

                                        Text(
                                            text = partido.fecha.toString(),
                                            modifier = Modifier.width(48.dp).fillMaxHeight(),
                                            textAlign = TextAlign.Center
                                        )

                                        Text(
                                            text = partido.hora,
                                            modifier = Modifier.width(48.dp).fillMaxHeight(),
                                            textAlign = TextAlign.Center
                                        )

                                        Text(
                                            text = partido.equipoVisitante.toString(),
                                            modifier = Modifier.width(106.dp).fillMaxHeight(),
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }*/
     @Preview
      @Composable
      fun MostrarFechas() {
          val fixture = FixtureRepositorio.DevolverFixture()

          LazyColumn(
              modifier = Modifier
                  .fillMaxSize(),

          ) {
              items(fixture.size) { index ->
                  val fecha = fixture[index]
                Column() {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .height(250.dp)
                            .background(color = Color.LightGray, shape = RoundedCornerShape(30.dp))
                            .clip(RoundedCornerShape(7.dp))
                            //.padding(10.dp) // Agregamos padding para que el contenido no esté pegado a los bordes redondeados
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Column(modifier =Modifier.background(Color.Blue)) {
                            Text(text = "Fecha ${fecha.id}",
                                color = Color.White,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(35.dp)
                                    .padding(5.dp),
                                textAlign = TextAlign.Center

                        )
                            fecha.listaPartidos.forEach { partido ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(30.dp)
                                        .background(Color(0xFFBAE1F3))
                                        .border(width = 0.5.dp, color = Color.White)
                                        .clickable {
                                            // Tu lógica para iniciar la actividad con los detalles del partido
                                        }
                                ) {
                                    Text(
                                        modifier = Modifier
                                            .width(106.dp)
                                            .fillMaxHeight(),
                                        text = partido.equipoLocal.toString(),
                                        textAlign = TextAlign.Center
                                    )

                                    Text(
                                        text = partido.cancha.toString(),
                                        modifier = Modifier
                                            .width(65.dp)
                                            .fillMaxHeight(),
                                        textAlign = TextAlign.Center
                                    )

                                    Text(
                                        text = partido.fecha.toString(),
                                        modifier = Modifier
                                            .width(48.dp)
                                            .fillMaxHeight(),
                                        textAlign = TextAlign.Center
                                    )

                                    Text(
                                        text = partido.hora,
                                        modifier = Modifier
                                            .width(48.dp)
                                            .fillMaxHeight(),
                                        textAlign = TextAlign.Center
                                    )

                                    Text(
                                        text = partido.equipoVisitante.toString(),
                                        modifier = Modifier
                                            .width(106.dp)
                                            .fillMaxHeight(),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
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
                IconButton(onClick = {startActivity(
                    Intent(
                        this@FechasActivity,
                        MainActivity::class.java
                    )

                )  }) {
                    Image(
                        painter = painterResource(id = R.drawable.home),
                        contentDescription = "home"
                    )
                }
                Spacer(modifier = Modifier.width(120.dp))
                IconButton(onClick = { }) {
                    Image(
                        painter = painterResource(id = R.drawable.gol),
                        contentDescription = "goleadores"
                    )
                }
                Spacer(modifier = Modifier.width(120.dp))
                IconButton(onClick = {  }) {
                    Image(
                        painter = painterResource(id = R.drawable.time),
                        contentDescription = "tiempos"
                    )
                }
            }
        }
    }
}

