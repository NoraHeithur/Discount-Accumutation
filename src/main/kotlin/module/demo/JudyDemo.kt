package module.demo

import model.coupon.Coupon
import model.customer.CustomerModel
import model.product.ProductCategory
import module.calculate.calculateDiscount
import module.calculate.displayCampaignCoupons
import module.cart.getCartItem
import module.cart.setDemoCart2
import module.coupon.*
import printItem
import printTotalPrice

fun setJudyDemo() {
    val customer = CustomerModel("Judy", 5000)
    val cart = getCartItem(setDemoCart2())
    displayCampaignCoupons(setJudyAvailableCampaigns(), cart)

    calculateDiscount(customer, cart) { totalPrice ->
        println("Items in cart:")
        repeat(cart.items.size) { index ->
            printItem(cart.items[index].amount, cart.items[index].product, cart.items[index].totalItemPrice)
        }

        printTotalPrice(totalPrice)
    }
}

private fun setJudyAvailableCampaigns(): List<Coupon> {
    val availableCoupon = mutableListOf<Coupon>()
    availableCoupon.add(setDemoFixedAmountCoupon(100))
    availableCoupon.add(setDemoPercentageDiscountCoupon(20))
    availableCoupon.add(setDemoPercentageDiscountByProductCategoryCoupon(ProductCategory.ACCESSORIES, 12))
    availableCoupon.add(setDemoDiscountByPointCoupon(4))
    availableCoupon.add(setDemoSpecialDiscountCoupon(evertAmount = 25000, amount = 1000))
    return availableCoupon
}