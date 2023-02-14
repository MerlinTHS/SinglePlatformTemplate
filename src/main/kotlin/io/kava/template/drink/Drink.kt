package io.kava.template.drink

enum class Drink {
    Coffee,
    Tea
}

fun Drink.isCoffee(): Boolean =
    this == Drink.Coffee