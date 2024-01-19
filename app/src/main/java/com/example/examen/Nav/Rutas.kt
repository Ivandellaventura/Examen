package com.example.examen.Nav

sealed class Rutas(val ruta: String) {
    /* TODO
        Crear e identificar las rutas (diferentes pantallas) de nuestra app
     */
    object PantallaMenu: Rutas("Menu")
    object PantallaCompras:Rutas("Compras")



}