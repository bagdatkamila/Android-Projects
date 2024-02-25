package com.example.example.listItems

import com.example.example.R
import com.example.example.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class Products {
    private val _productList = MutableStateFlow<MutableList<Product>>(mutableListOf())
    private val productListFlow: StateFlow<MutableList<Product>> = _productList

    fun getProducts(): Flow<MutableList<Product>>{
        val productList: MutableList<Product> = mutableListOf(
            Product(
                imgProduct = R.drawable.hawaii,
                name = "Гавайская с альфредо",
                price = "2400",
                description = "Двойная порция цыпленка, кусочки ананасов, моцарелла, соус альфредо"
            ),
            Product(
                imgProduct = R.drawable.karbonara,
                name = "Карбонара",
                price = "2400",
                description = "Ветчина из цыпленка, сыры чеддер и пармезан, томаты, красный лучок, моцарелла, соус альфредо, чеснок и итальянские травы"
            ),
            Product(
                imgProduct = R.drawable.naruto,
                name = "Наруто пицца",
                price = "3900",
                description = "Куриные кусочки, соус терияки, ананасы, моцарелла, фирменный соус альфредо"
            ),
            Product(
                imgProduct = R.drawable.pepperoni,
                name = "Пепперони с грибами",
                price = "2000",
                description = "Пикантная пепперони, моцарелла, шампиньоны, соус альфредо"
            ),
            Product(
                imgProduct = R.drawable.hawaii,
                name = "Пицца Жюльен",
                price = "2700",
                description = "Цыпленок, шампиньоны, ароматный грибной соус, лук, сухой чеснок, моцарелла, смесь сыров чеддер и пармезан, фирменный соус альфредо"
            )
        )
        _productList.value = productList

        return productListFlow
    }
}