package module.coupon

import model.coupon.Coupon

fun setPercentageDiscountCoupon(): Coupon {
    print("Discount by (percentage): ")
    return Coupon.PercentageModel(percentage = readln().toInt())
}

fun setDemoPercentageDiscountCoupon(percentage: Int = 10): Coupon {
    return Coupon.PercentageModel(percentage = percentage)
}