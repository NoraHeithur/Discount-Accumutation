package module.cart

import model.cart.CartModel
import model.item.ItemModel

fun getCartItem(items: List<ItemModel>): CartModel {
    return CartModel(items).apply {
        this.items.onEach {
            this.totalPrice += it.totalItemPrice
        }
    }
}