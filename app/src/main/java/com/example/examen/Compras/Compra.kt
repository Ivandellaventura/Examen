package com.example.examen.Compras

class Compra(platanos: Int, tomates: Int, asado:Boolean ) {
    val precioPlatanos = 2
    val precioTomates = 5
    val precioAsado = 100
    val asado = asado
    val platanos = platanos
    val tomates = tomates
    val precioTotal = CrearPrecio()
    val elementosTotales =CrearUnidades()
    fun CrearPrecio() : Int{
        var precioTotal : Int

        if(asado){
            precioTotal = precioPlatanos * platanos + tomates * precioTomates + precioAsado

        }else{
            precioTotal = precioPlatanos * platanos + tomates * precioTomates
        }
        return precioTotal

    }
    fun CrearUnidades() : Int{
        var precioTotal : Int

        if(asado){
            precioTotal = platanos + tomates + 2

        }else{
            precioTotal =platanos + tomates
        }
        return precioTotal

    }



}