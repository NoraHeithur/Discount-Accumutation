package module.coupon

import model.coupon.Coupon

fun checkDuplicateCoupon(coupon: Coupon, couponList: MutableList<Coupon>): List<Coupon> {
    couponList.let {
        when(coupon) {
            is Coupon.PercentageByCategoryModel -> {
                val couponByCategories = couponList.filterIsInstance<Coupon.PercentageByCategoryModel>()

                val isAlreadyHaveCouponByCategory = couponByCategories.any { category ->
                    category.productCategory == coupon.productCategory
                }
                if (isAlreadyHaveCouponByCategory) {
                    it[it.indexOfFirst {
                        couponByCategories.any { category ->
                            category.productCategory == coupon.productCategory
                        }
                    }] = coupon
                } else {
                    it.add(coupon)
                }
            }
            else -> {
                val isAlreadyHaveCoupon = it.any { currentCoupon -> currentCoupon.type == coupon.type }
                if (isAlreadyHaveCoupon) {
                    it[couponList.indexOfFirst { currentCoupon -> currentCoupon.type == coupon.type }] = coupon
                } else {
                    it.add(coupon)
                }
            }
        }
    }

    return couponList
}