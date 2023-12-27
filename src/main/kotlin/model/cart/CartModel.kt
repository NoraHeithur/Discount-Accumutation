package model.cart

import model.coupon.Coupon
import model.item.ItemModel

data class CartModel(
    val items: List<ItemModel>,
    val appliedCoupon: MutableList<Coupon> = mutableListOf(),
    var totalPrice: Double = 0.0
)