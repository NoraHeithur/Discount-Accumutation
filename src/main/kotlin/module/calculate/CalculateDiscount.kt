package module.calculate

import model.cart.CartModel
import model.coupon.Coupon
import model.coupon.CouponCategory
import model.customer.CustomerModel
import model.product.ProductCategory

fun calculateDiscount(customer: CustomerModel, cartModel: CartModel, onCalculateResult: (Double) -> Unit) {
    val appliedCampaignCoupons = cartModel.appliedCoupon.apply {
        sortBy { it.type.couponCategory.ordinal }
    }
    var currentCart = cartModel
    repeat(appliedCampaignCoupons.size) {
        when(appliedCampaignCoupons[it]) {
            is Coupon.FixedAmountModel -> calculateCoupon(currentCart) { cart ->
                currentCart = cart
            }
            is Coupon.PercentageModel -> calculateCoupon(currentCart) { cart ->
                currentCart = cart
            }
            is Coupon.PercentageByCategoryModel -> calculateOnTopCategory(currentCart) { cart ->
                currentCart = cart
            }
            is Coupon.PointModel -> calculateOnTopPoint(customer, currentCart, onFinished = { cart ->
                currentCart = cart
            }) { customer ->
                println("Your remaining point: ${customer.point}")
            }
            is Coupon.SpecialModel -> calculateSpecialCampaign(currentCart) { cart ->
                currentCart = cart
            }
        }
    }
    onCalculateResult(currentCart.totalPrice)
}

private fun calculateCoupon(
    cartModel: CartModel,
    onFinished: (CartModel) -> Unit = {}
) {
    val couponCategory = cartModel.appliedCoupon.filter {
        it.type.couponCategory == CouponCategory.COUPON
    }

    val coupon = if (couponCategory.isNotEmpty()) couponCategory.first() else return

    when (coupon) {
        is Coupon.FixedAmountModel -> {
            cartModel.totalPrice -= coupon.amount
        }
        is Coupon.PercentageModel -> {
            cartModel.totalPrice -= toPercentage(cartModel.totalPrice, coupon.percentage.toDouble())
        }
        else -> { /* do nothing */ }
    }
    onFinished(cartModel)
}

private fun calculateOnTopCategory(
    cartModel: CartModel,
    onFinished: (CartModel) -> Unit = {}
) {
    val accumulatedCategoriesDiscount: Pair<Double, Double>
    val onTopCategory = cartModel.appliedCoupon.filterIsInstance<Coupon.PercentageByCategoryModel>()
    val coupon = if (onTopCategory.isNotEmpty()) onTopCategory.first() else return
    val items = cartModel.items
    if (onTopCategory.isNotEmpty()) {
        when (coupon.productCategory) {
            ProductCategory.CLOTHING -> {
                accumulatedCategoriesDiscount = items.filter { itemsInCategory ->
                    itemsInCategory.category == ProductCategory.CLOTHING
                }.sumOf {
                    it.totalItemPrice
                }.toDouble() to coupon.percentage.toDouble()
            }

            ProductCategory.ACCESSORIES -> {
                accumulatedCategoriesDiscount = items.filter { itemsInCategory ->
                    itemsInCategory.category == ProductCategory.ACCESSORIES
                }.sumOf {
                    it.totalItemPrice
                }.toDouble() to coupon.percentage.toDouble()
            }

            ProductCategory.ELECTRONICS -> {
                accumulatedCategoriesDiscount = items.filter { itemsInCategory ->
                    itemsInCategory.category == ProductCategory.ELECTRONICS
                }.sumOf {
                    it.totalItemPrice
                }.toDouble() to coupon.percentage.toDouble()

            }

            else -> {
                accumulatedCategoriesDiscount = items.filter { itemsInCategory ->
                    itemsInCategory.category == ProductCategory.OTHERS
                }.sumOf {
                    it.totalItemPrice
                }.toDouble() to coupon.percentage.toDouble()
            }
        }
    } else {
        return
    }

    cartModel.apply {
        this.totalPrice -= toPercentage(
            value = accumulatedCategoriesDiscount.first,
            by = accumulatedCategoriesDiscount.second
        )
    }
    onFinished(cartModel)
}

private fun calculateOnTopPoint(
    customer: CustomerModel,
    cartModel: CartModel,
    onFinished: (CartModel) -> Unit = {},
    onCalculatePoint: (CustomerModel) -> Unit = {}
) {
    val onTopPoint = cartModel.appliedCoupon.filterIsInstance<Coupon.PointModel>()
    val coupon = if (onTopPoint.isNotEmpty()) onTopPoint.first() else return

    cartModel.apply { this.totalPrice -= coupon.usagePoint }
    onFinished(cartModel)
    onCalculatePoint(customer.apply { this.point -= coupon.usagePoint })
}

private fun calculateSpecialCampaign(
    cartModel: CartModel,
    onFinished: (CartModel) -> Unit = {}
) {
    val seasonalCategory = cartModel.appliedCoupon.filterIsInstance<Coupon.SpecialModel>()
    val coupon = if (seasonalCategory.isNotEmpty()) seasonalCategory.first() else return
    val subtractTime = (cartModel.totalPrice / coupon.everyAmount).toInt()
    if (subtractTime > 0) {
        repeat(subtractTime) {
            cartModel.apply { this.totalPrice -= coupon.amount }
        }
    } else {
        return
    }
    onFinished(cartModel)
}