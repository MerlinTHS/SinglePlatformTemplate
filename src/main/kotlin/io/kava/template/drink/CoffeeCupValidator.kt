package io.kava.template.drink

import io.mths.kava.GenerateExtensions
import io.mths.kava.ValidationScope
import io.mths.kava.Validator

@GenerateExtensions("cup")
class CoffeeCupValidator : Validator<Drink, Cup> {
    override val invalid =
        Cup.Empty

    override fun valid(drink: Drink) =
        Cup.Filled(drink)

    override fun ValidationScope<*>.validate(cup: Cup) = with(cup) {
        if (isFilled() && drink.isCoffee())
            drink
        else
            fail()
    }
}