package module.coupon

import model.coupon.Coupon

fun setAvailableCampaigns(): List<Coupon> {
    val availableCoupon = mutableListOf<Coupon>()
    println("-----------------------------------------")
    println("Available coupon setting")
    println("Select number to set type of coupon")
    println("1: Fixed amount, 2: Percentage, 3: Percentage by item category, 4: Customer's point, 5: Special campaigns")
    do {
        println("Enter available coupon: (type -1 to finish)")
        print("type of coupon: ")
        val type = readln().toInt()
        when (type) {
            1 -> checkDuplicateCoupon(setFixedAmountCoupon(), availableCoupon)
            2 -> checkDuplicateCoupon(setPercentageDiscountCoupon(), availableCoupon)
            3 -> checkDuplicateCoupon(setPercentageDiscountByProductCategoryCoupon(), availableCoupon)
            4 -> checkDuplicateCoupon(setDiscountByPointCoupon(), availableCoupon)
            5 -> checkDuplicateCoupon(setSpecialDiscountCoupon(), availableCoupon)
            else -> { /* do nothing */ }
        }
        println()
    } while (type != -1)
    return availableCoupon
}