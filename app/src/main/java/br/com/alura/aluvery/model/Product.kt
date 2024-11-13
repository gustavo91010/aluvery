package br.com.alura.aluvery.model

import androidx.annotation.DrawableRes
import br.com.alura.aluvery.R
import java.math.BigDecimal

class Product {
    val name: String
    val price: BigDecimal
    @DrawableRes
    val image: Int //a anotação DrawableRes garante que p que vai vir é um aimagem

    constructor(name: String, price: BigDecimal, image: Int) {
        this.name = name
        this.price = price
        this.image = image
    }
}
