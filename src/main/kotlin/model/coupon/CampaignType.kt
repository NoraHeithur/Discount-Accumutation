package model.coupon

enum class CampaignType(
    val campaignName: String,
    val couponCategory: CouponCategory
) {
    FIXED("Fixed amount", CouponCategory.COUPON),
    PERCENTAGE("Percentage discount", CouponCategory.COUPON),
    PERCENTAGE_BY_CATEGORY("Percentage discount by item category", CouponCategory.ON_TOP),
    POINT("Discount by points", CouponCategory.ON_TOP),
    SPECIAL("Special campaigns", CouponCategory.SEASONAL)
}
