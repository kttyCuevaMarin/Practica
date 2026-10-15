package com.example.practica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.practica.ui.theme.PracticaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticaTheme {
                ControldeAforo()
            }
        }
    }
}

@Composable
fun ControldeAforo() {
    var cantidadPersonas by remember { mutableStateOf(0) }
    var ultimoRegistrado by remember { mutableStateOf("Ninguno") }
    var nombreIngresado by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {

        Text(text = "Control de Aforo")
        Text(text = "Personas adentro: $cantidadPersonas")
        Text(text = "Último registrado: $ultimoRegistrado")

        TextField(
            value = nombreIngresado,
            onValueChange = { nombreIngresado = it },
            label = { Text("Escribe un nombre") }
        )

        Button(onClick = {


            ultimoRegistrado = nombreIngresado
            cantidadPersonas = cantidadPersonas + 1
            nombreIngresado = ""
        }) {
            Text(text = "Registrar e Ingresar")
        }

        Row {
            Button(onClick = {
                if (cantidadPersonas > 0) {
                    cantidadPersonas = cantidadPersonas - 1
                }
            }) {
                Text(text = "Salida (-1)")
            }

            Button(onClick = {
                cantidadPersonas = 0
                ultimoRegistrado = "Ninguno"
                nombreIngresado = ""
            }) {
                Text(text = "Reiniciar")
            }
        }
    }
}
