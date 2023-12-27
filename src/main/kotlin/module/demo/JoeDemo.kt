package module.demo

import model.coupon.Coupon
import model.customer.CustomerModel
import module.calculate.calculateDiscount
import module.calculate.displayCampaignCoupons
import module.cart.getCartItem
import module.cart.setDemoCart
import module.coupon.*
import printItem
import printTotalPrice

fun setJoeDemo() {
    val customer = CustomerModel("Joe", 2000)
    val cart = getCartItem(setDemoCart())
    displayCampaignCoupons(setJoeAvailableCampaigns(), cart)

    calculateDiscount(customer, cart) { totalPrice ->
        println("Items in cart:")
        repeat(cart.items.size) { index ->
            printItem(cart.items[index].amount, cart.items[index].product, cart.items[index].totalItemPrice)
        }

        printTotalPrice(totalPrice)
    }
}

private fun setJoeAvailableCampaigns(): List<Coupon> {
    val availableCoupon = mutableListOf<Coupon>()
    availableCoupon.add(setDemoFixedAmountCoupon())
    availableCoupon.add(setDemoPercentageDiscountCoupon())
    availableCoupon.add(setDemoPercentageDiscountByProductCategoryCoupon())
    availableCoupon.add(setDemoDiscountByPointCoupon())
    availableCoupon.add(setDemoSpecialDiscountCoupon())
    return availableCoupon
}