package module.coupon

import model.coupon.Coupon
import model.product.ProductCategory
import module.product.setDemoClothingCategory
import module.product.setProductCategory

fun setPercentageDiscountByProductCategoryCoupon(): Coupon {
    println("Set category and discount percentage")
    val category = setProductCategory()

    print("category ${category.name} discount by (percentage): ")
    val byDiscount = readln().toInt()

    return Coupon.PercentageByCategoryModel(
        productCategory = category,
        percentage = byDiscount
    )
}

fun setDemoPercentageDiscountByProductCategoryCoupon(
    productCategory: ProductCategory = setDemoClothingCategory(),
    percentage: Int = 15
): Coupon {
    return Coupon.PercentageByCategoryModel(
        productCategory = productCategory,
        percentage = percentage
    )
}