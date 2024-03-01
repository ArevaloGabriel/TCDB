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
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.IconButton

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tcdbv2.R
import com.example.tcdbv2.Repositorio.ListaEquiposRepositorio

import com.example.tcdbv2.Repositorio.fechasRepositorio

class DatosDelPartidoActivity : ComponentActivity() {
    // val idPartido = intent.getIntExtra("idPartido", 0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

          PantallaDatosDelPartido()
        }
    }
@Composable
    fun PantallaDatosDelPartido() {
        val listaComposables: List<@Composable () -> Unit> = listOf(
            {   DatosPartido() }

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
    fun DatosPartido() {
        val idFecha = intent.getIntExtra("idFecha", 0)
        val idPartido = intent.getIntExtra("idPartido", 0)

        val partidoSeleccionado = fechasRepositorio.DatosPartidoPorFecha(idFecha,idPartido)
        val resultado=fechasRepositorio.ResultadoDePartidoPorFecha(idFecha,idPartido)



    Column(modifier = Modifier.background(color = Color.White)) {
        if (partidoSeleccionado != null) {
            val logoEquipoLocal =
                ListaEquiposRepositorio.ObtenerLogoPorEquipo(partidoSeleccionado.equipoLocal.toString())
            val logoEquipoVisitante =
                ListaEquiposRepositorio.ObtenerLogoPorEquipo(partidoSeleccionado.equipoVisitante.toString())
            Spacer(modifier = Modifier.height(16.dp))
           Box(modifier=Modifier.fillMaxSize()) {
                Column() {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                      ) {
                        Spacer(modifier = Modifier.padding(10.dp))
                        Box() {
                            Column(modifier=Modifier.align(Center)) {

                                Image(modifier= Modifier
                                    .width(150.dp)
                                    .height(150.dp),
                                    painter = painterResource(id = logoEquipoLocal),
                                    contentDescription = "logo equipo local"
                                )
                                Spacer(modifier = Modifier.height(5.dp))

                                Text(text =  partidoSeleccionado.equipoLocal.toString(),
                                    modifier = Modifier.padding(25.dp))
                                Box(modifier=Modifier.align(CenterHorizontally)) {

                                    Text(
                                        text = partidoSeleccionado.golesLocal.toString(),
                                        style = TextStyle(fontSize = 50.sp),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.width(40.dp))
                        Box() {
                            Column(modifier = Modifier.align(TopCenter)) {

                                Image(modifier= Modifier
                                    .width(150.dp)
                                    .height(150.dp),
                                    painter = painterResource(id = logoEquipoVisitante),
                                    contentDescription = "logo equipo visitante"
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(text =  partidoSeleccionado.equipoVisitante.toString(),
                                    modifier = Modifier.padding(25.dp))
                                Box(modifier=Modifier.align(CenterHorizontally)) {

                                    Text(
                                        text = partidoSeleccionado.golesVisitante.toString(),
                                        style = TextStyle(fontSize = 50.sp),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
                    }
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(70.dp)
                            .align(CenterHorizontally)) {

                        if(resultado  == "GANO_LOCAL"){
                            Text(text ="GANADOR : "+partidoSeleccionado.equipoLocal.name, textAlign = TextAlign.Center)
                        }else if(resultado == "GANO_VISITANTE"){
                            Text(text ="GANADOR : "+partidoSeleccionado.equipoVisitante.name)
                        }else if(resultado == "EMPATE"){
                            Text(text ="EMPATE")
                        }else{
                            Text(text ="TODAVIA NO SE JUGO")
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
                        this@DatosDelPartidoActivity,
                        MainActivity::class.java
                    )

                )
                }
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.home),
                        contentDescription = "home"
                    )
                }
                Spacer(modifier = Modifier.width(120.dp))
                IconButton(onClick = { startActivity(
                    Intent(
                        this@DatosDelPartidoActivity,
                        EstadisticasActivity::class.java
                    )

                )
                }
                )
                {
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
