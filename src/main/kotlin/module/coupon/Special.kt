package module.coupon

import model.coupon.Coupon

fun setSpecialDiscountCoupon(): Coupon {
    print("Enter the amount at condition to get a discount: ")
    val everyAmount = readln().toInt()

    print("Discount by (amount): ")
    val discountBy = readln().toInt()

    return Coupon.SpecialModel(everyAmount = everyAmount, amount = discountBy)
}

fun setDemoSpecialDiscountCoupon(
    evertAmount: Int = 300,
    amount: Int = 40
): Coupon {
    return Coupon.SpecialModel(everyAmount = evertAmount, amount = amount)
}