package com.example.tcdbv2.Pantallas

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tcdbv2.Pantallas.ui.theme.TCDBV2Theme
import com.example.tcdbv2.R
import com.example.tcdbv2.ViewModels.JugadorViewModel


class JugadorActivity : ComponentActivity() {
    private val viewModel: JugadorViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(  modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)) {
                DetalleJugador()
                Spacer(modifier = Modifier.height(16.dp))
                BottomBar( )
            }

        }
    }

@Preview
@Composable
    fun DetalleJugador(){
        val dniJugador = intent.getIntExtra("dni",0)

        val jugadorSeleccionado = viewModel.DetalleJugador(dniJugador)

        Column() {
            if (jugadorSeleccionado != null) {
                Image( painter = painterResource(id = jugadorSeleccionado.fotoPerfil ),
                    contentDescription = "Foto de Perfil",
                    modifier = Modifier
                        .size(300.dp) // Ajusta el tamaño de la imagen según sea necesario
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Column( modifier=Modifier.align(Alignment.CenterHorizontally),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text ="Nombre :" + jugadorSeleccionado.nombre )

                    Text(text ="Apellido :" + jugadorSeleccionado.apellido )

                    Text(text ="Equipo:" + jugadorSeleccionado.equipo )

                    Text(text ="Numero Camiseta :" + jugadorSeleccionado.numeroCamiseta.toString() )
                    Text(text ="Amonestaciones :" +jugadorSeleccionado.amonestaciones.toString() )
                    Text(text ="Expulsiones :" + jugadorSeleccionado.expulsiones.toString() )
                    Text(text ="Goles :" +jugadorSeleccionado.goles.toString() )
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
                IconButton(onClick = { startActivity(Intent(this@JugadorActivity, MainActivity ::class.java)) }) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
                        contentDescription = "atras"
                    )
                }

            }
        }
    }



}

