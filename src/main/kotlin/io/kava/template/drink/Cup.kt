package io.kava.template.drink

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

sealed interface Cup {
    object Empty : Cup

    data class Filled(
        val drink: Drink
    ) : Cup
}

@OptIn(ExperimentalContracts::class)
fun Cup.isFilled(): Boolean {
    contract {
        returns(true) implies (this@isFilled is Cup.Filled)
    }

    return this is Cup.Filled
}