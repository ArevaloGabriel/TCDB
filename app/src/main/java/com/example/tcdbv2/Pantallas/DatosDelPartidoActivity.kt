package com.example.tcdbv2.Pantallas

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tcdbv2.R

import com.example.tcdbv2.Repositorio.fechasRepositorio

class DatosDelPartidoActivity : ComponentActivity() {
    // val idPartido = intent.getIntExtra("idPartido", 0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column() {


                DatosPartido()
                BottomBar()
            }
        }
    }

@Preview
    @Composable
    fun DatosPartido() {
        val idFecha = intent.getIntExtra("idFecha", 0)
        val idPartido = intent.getIntExtra("idPartido", 0)

        val partidoSeleccionado = fechasRepositorio.DatosPartidoPorFecha(idFecha,idPartido)

        Column() {
            if (partidoSeleccionado != null) {
                Spacer(modifier = Modifier.height(16.dp))
                Column(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Local :" + partidoSeleccionado.equipoLocal.toString())
                    Text(text = "Visitante :" + partidoSeleccionado.equipoVisitante.toString())
                    Text(text = "Fecha:" + partidoSeleccionado.fecha.toString())

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
                        this@DatosDelPartidoActivity,
                        MainActivity::class.java
                    )

                )  }) {
                    Image(
                        painter = painterResource(id = R.drawable.home),
                        contentDescription = "home"
                    )
                }
                Spacer(modifier = Modifier.width(120.dp))
                IconButton(onClick = { startActivity(
                    Intent(
                        this@DatosDelPartidoActivity,
                        MainActivity::class.java
                    )

                )  }) {
                    Image(
                        painter = painterResource(id = R.drawable.gol),
                        contentDescription = "goleadores"
                    )
                }
                Spacer(modifier = Modifier.width(120.dp))
                IconButton(onClick = {startActivity(
                    Intent(
                        this@DatosDelPartidoActivity,
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
