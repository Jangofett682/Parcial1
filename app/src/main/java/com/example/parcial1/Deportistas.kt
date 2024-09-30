package com.example.parcial1

data class Deportistas (
    val Id : Int,
    val Nombre : String,
    val Deporte : Deportes,
    val Activo : Boolean
)

enum class Deportes
{
    Futbol, Tenis, Basket, MMA, F1
}