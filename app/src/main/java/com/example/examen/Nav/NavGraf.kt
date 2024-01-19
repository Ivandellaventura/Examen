package com.example.examen.Nav

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.example.examen.Compras.Compra
import com.example.examen.Compras.Compras
import com.example.examen.Principal.Menu

var ArrayBox = mutableStateListOf<Compra>()

@Composable
fun GrafoNav(context: Context){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Menu"){

        composable(Rutas.PantallaMenu.ruta){
            Menu(navController = navController, context = context)

        }
        composable(Rutas.PantallaCompras.ruta){
            Compras(navController = navController, context = context)

        }



    }

}