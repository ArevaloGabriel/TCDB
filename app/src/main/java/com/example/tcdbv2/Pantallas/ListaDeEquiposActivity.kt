package com.example.tcdbv2.Pantallas

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tcdbv2.Pantallas.ui.theme.TCDBV2Theme
import com.example.tcdbv2.R
import com.example.tcdbv2.Repositorio.ListaEquiposRepositorio


class ListaDeEquiposActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column() {
                ListaDeEquipos()
                BottomBar()
            }
        }
    }


    @Preview
    @Composable
    fun ListaDeEquipos() {
        val equipos = ListaEquiposRepositorio.get()
        LazyColumn(modifier = Modifier.fillMaxWidth().height(700.dp)) {
            items(equipos) { equipo ->
                Box(modifier = Modifier.fillMaxWidth().fillMaxHeight()){
                    Row(modifier = Modifier.fillMaxWidth().height(100.dp).align(Alignment.Center)
                        .clickable{
                            // Cuando se hace clic en un Equipo, iniciar ListaDeJugadoresActivity
                            startActivity(
                                Intent(
                                    this@ListaDeEquiposActivity,
                                    ListaDeJugadoresActivity::class.java
                                )
                                    .putExtra("Equipo", equipo.nombre.toString())
                            )

                        }) {
                        Image(painter = painterResource(id = equipo.logo), contentDescription ="", modifier = Modifier.height(50.dp)
                            .width(50.dp),
                            contentScale = ContentScale.Crop)
                        Text(
                            text = equipo.nombre.toString(),
                            modifier = Modifier
                                .padding(16.dp)
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
                IconButton(onClick = { startActivity(Intent(this@ListaDeEquiposActivity, MainActivity ::class.java)) }) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
                        contentDescription = "atras"
                    )
                }

            }
        }
    }


}