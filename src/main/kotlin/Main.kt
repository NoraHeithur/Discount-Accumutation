import model.cart.CartModel
import module.calculate.calculateDiscount
import module.calculate.displayCampaignCoupons
import module.cart.getCartItem
import module.cart.setCart
import module.cart.setDemoCart
import module.cart.setDemoCart2
import module.coupon.setAvailableCampaigns
import module.demo.setJoeDemo
import module.demo.setJudyDemo
import module.setCustomer

fun main() {
    println("Set customer name and point")
    try {
//        uncomment to use short setup demo
//        setJoeDemo()
//        setJudyDemo()

        // fully customize
        val customer = setCustomer()

        val campaigns = setAvailableCampaigns()

        val cart = getCartItem(setCart())

        displayCampaignCoupons(campaigns, cart)

        calculateDiscount(customer, cart) { totalPrice ->
            println("Items in cart:")
            repeat(cart.items.size) { index ->
                printItem(cart.items[index].amount, cart.items[index].product, cart.items[index].totalItemPrice)
            }
            printTotalPrice(totalPrice)
        }
    } catch (e: NumberFormatException) {
        println("Invalid input. Please enter a valid number.")
    }
}