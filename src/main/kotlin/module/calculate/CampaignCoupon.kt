package module.calculate

import model.cart.CartModel
import model.coupon.Coupon
import printFixedAmountDetail
import printPercentageByCategoryDetail
import printPercentageDiscountDetail
import printPointDiscountDetail
import printSpecialDiscountDetail

fun displayCampaignCoupons(campaigns: List<Coupon>, cart: CartModel): CartModel {
    do {
        val availableCampaigns = campaigns.filter {
            it.type.couponCategory !in cart.appliedCoupon.map { inCart -> inCart.type.couponCategory }
        }
        println("-----------------------------------------")
        if (availableCampaigns.isEmpty()) {
            return cart
        } else {
            println("Available campaigns")
            println("You can apply only one campaign from the same category.")
            repeat(availableCampaigns.size) { index ->
                val currentCampaign = availableCampaigns[index]
                println("${index + 1}: ${currentCampaign.type.campaignName}(${currentCampaign.type.couponCategory})")

                when(currentCampaign) {
                    is Coupon.FixedAmountModel -> printFixedAmountDetail(currentCampaign.amount)
                    is Coupon.PercentageModel -> printPercentageDiscountDetail(currentCampaign.percentage)
                    is Coupon.PercentageByCategoryModel -> printPercentageByCategoryDetail(
                        currentCampaign.percentage,
                        currentCampaign.productCategory.name.lowercase().replaceFirstChar { it.uppercase() })
                    is Coupon.PointModel -> printPointDiscountDetail(currentCampaign.usagePoint)
                    is Coupon.SpecialModel -> printSpecialDiscountDetail(currentCampaign.everyAmount, currentCampaign.amount)
                }
            }
            print("select campaign(-1 to finish): ")
        }

        val selected = readln().toInt()

        if (selected != -1) {
            try {
                cart.appliedCoupon.add(applyCampaignCoupon(selected - 1, availableCampaigns, cart.totalPrice))
            } catch (e: IndexOutOfBoundsException) {
                println("There are no campaign that you selected")
            }
        }

    } while (availableCampaigns.isEmpty() || selected != -1)

    return cart
}

fun applyCampaignCoupon(selected: Int, campaigns: List<Coupon>, totalPrice: Double): Coupon {
    val selectedCampaign = campaigns[selected]
    return if (selectedCampaign is Coupon.PointModel) {
        val maxPoint = (toPercentage(totalPrice, 20.0) * selectedCampaign.usagePoint).toInt()
        println("You can use points capped at 20% of total price.")
        println("Total price: $totalPrice, maximum $maxPoint points ")
        print("Points in use: ")
        val points = readln().toInt()
        selectedCampaign.apply { usagePoint = if (points <= maxPoint) points else maxPoint }
    } else {
        selectedCampaign
    }
}