package com.example.examen.Compras

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.examen.Nav.ArrayBox
import java.util.Collections
import com.example.examen.R


@Composable
fun Compras(navController: NavHostController, context: Context) {
    var filtro by remember { mutableStateOf("") }
    var listaMutable = remember {
        mutableStateListOf<Compra>().apply {
            addAll(ArrayBox)
        }
    }
    var precioTotal by remember{
        mutableStateOf(0)
    }
    println("$listaMutable.size $ArrayBox.size")
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Estas son todas las compras que has hecho! Puedes filtrar seleccionando los botones")
        Row() {
            Button(onClick = { filtro = "Pobres" }) {
                Text(text = "Pobres")

            }
            Button(onClick = { filtro = "Medias" }) {
                Text(text = "Medias")

            }
            Button(onClick = { filtro = "Grandes" }) {
                Text(text = "Grandes")

            }
            Button(onClick = { filtro = "" }) {
                Text(text = "Todos")

            }

        }
        LazyColumn() {



            items(listaMutable) { Compra ->

                MostrarCompras(filtro = filtro, compra = Compra)



            }
        }
        Button(onClick = {
            for (i in listaMutable){
                precioTotal = precioTotal + i.precioTotal

            }
            Toast.makeText(context, "El precio total es de: " + precioTotal.toString() + " CACHING", Toast.LENGTH_SHORT).show()

        }) {
            Text(text = "Precio Total")

        }


    }


}

@Composable
fun MostrarCompras(filtro: String, compra: Compra) {
    if (filtro == "") {
        itemCompra(compra = compra, filtro = filtro)

    } else if (filtro == "Pobres") {
        if (compra.precioTotal < 50) {
            itemCompra(compra = compra, filtro = filtro)

        }

    } else if (filtro == "Grandes") {
        if (compra.precioTotal >= 100) {
            itemCompra(compra = compra, filtro = filtro)

        }


    } else if (filtro == "Medias") {
        if (compra.precioTotal >= 50) {
            itemCompra(compra = compra, filtro = filtro)

        }


    }
}

@Composable
fun itemCompra(compra: Compra, filtro: String) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {


            var painter: Painter = painterResource(id = R.drawable.very_rich)
            val texto =
                "Se hizo una compra de " + compra.elementosTotales + " con una suma total de " + compra.precioTotal


            if (compra.precioTotal < 50) {
                painter = painterResource(id = R.drawable.poor)
            } else if (compra.precioTotal >= 100) {

                painter = painterResource(id = R.drawable.very_rich)

            } else if (compra.precioTotal >= 50) {
                painter = painterResource(id = R.drawable.rich)


            }
            Image(painter = painter, contentDescription = null, modifier = Modifier.height(100.dp))
            Text(text = texto)
        }
    }
}