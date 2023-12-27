package module.coupon

import model.coupon.Coupon

fun setDiscountByPointCoupon(): Coupon {
    println("Do you want to custom point usage per 1 THB? (default 1)")
    println(": y or n")
    val answer = readln().map { it.lowercase() }.joinToString("")
    var customPointPerUse = 1
    when(answer) {
        "y", "yes" -> {
            print("Enter custom point usage per 1 THB: ")
            customPointPerUse = readln().toInt()
        }
        else -> { /* do nothing */ }
    }
    return Coupon.PointModel(customPointPerUse)
}

fun setDemoDiscountByPointCoupon(usagePoint: Int = 1): Coupon {
    return Coupon.PointModel(usagePoint = usagePoint)
}