package com.example.examen.Principal

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.examen.Compras.Compra
import com.example.examen.Nav.ArrayBox
import com.example.examen.Nav.Rutas
import com.example.examen.R
import java.util.Collections



@Composable
fun Menu(navController: NavHostController , context: Context) {
    var valor1 by remember { mutableStateOf("0") }
    var movimientoSlider by remember { mutableFloatStateOf(0f) }
    var asado by remember {
        mutableStateOf(false)

    }

    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
        Column(verticalArrangement = Arrangement.SpaceEvenly) {
            Row(){
                Text(text = "Bienvenido a la tienda, haz tus compras! \n Introduce el número de bananas")
            }
            Row(){
                Image(painter = painterResource(id = R.drawable.banana), contentDescription = null, modifier = Modifier.fillMaxWidth())

            }
            Row(){
                TextField(
                    value = valor1, onValueChange = { valor1 = it }, modifier = Modifier
                        .weight(1f),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                )
            }


        }
        Column {
            Text(text = "¿Cuantos tomatitos?")
            Image(painter = painterResource(id = R.drawable.tomate), contentDescription = null, modifier = Modifier.fillMaxWidth())
            Slider(
                value = movimientoSlider,
                onValueChange = { movimientoSlider = it },
                valueRange = 0f..5f, steps = 5
            )
            Text("${movimientoSlider.toInt()}")
        }
        Column() {
            Text(text = "Un asado con la pulga de ibai")
            Image(painter = painterResource(id = R.drawable.asado), contentDescription = null, modifier = Modifier.fillMaxWidth().height(300.dp))
            Checkbox(
                checked = asado,
                onCheckedChange = { asado = it },
                colors = CheckboxDefaults.colors(
                    uncheckedColor = Color.Blue,
                    checkedColor = Color.Blue,
                    checkmarkColor = Color.White
                )
            )
        }
        Button(onClick = {
            var CompraTemp = Compra(platanos = valor1.toInt(), tomates = movimientoSlider.toInt(), asado = asado )
            ArrayBox.add(CompraTemp)
            navController.navigate(Rutas.PantallaCompras.ruta) }) {
            Text(text = "Comprar!")

        }


    }

}
