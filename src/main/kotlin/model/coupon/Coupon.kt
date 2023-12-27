package model.coupon

import model.product.ProductCategory

sealed class Coupon(val type: CampaignType) {
    data class FixedAmountModel(
        var amount: Int
    ): Coupon(type = CampaignType.FIXED)

    data class PercentageModel(
        var percentage: Int
    ): Coupon(type = CampaignType.PERCENTAGE)

    data class PercentageByCategoryModel(
        val productCategory: ProductCategory,
        var percentage: Int
    ): Coupon(type = CampaignType.PERCENTAGE_BY_CATEGORY)

    data class PointModel(
        var usagePoint: Int
    ): Coupon(type = CampaignType.POINT)

    data class SpecialModel(
        var everyAmount: Int,
        var amount: Int
    ): Coupon(type = CampaignType.SPECIAL)
}
