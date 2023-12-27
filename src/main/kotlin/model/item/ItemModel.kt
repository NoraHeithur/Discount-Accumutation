package model.item

import model.product.ProductCategory

data class ItemModel(
    val amount: Int,
    val product: String,
    val category: ProductCategory,
    var totalItemPrice: Int = 0
) {
    fun calculateTotalPrice(price: Int) = amount * price
}