package module.coupon

import model.coupon.Coupon

fun setFixedAmountCoupon(): Coupon {
    print("Discount amount: ")
    return Coupon.FixedAmountModel(amount = readln().toInt())
}

fun setDemoFixedAmountCoupon(amount: Int = 50): Coupon {
    return Coupon.FixedAmountModel(amount = amount)
}