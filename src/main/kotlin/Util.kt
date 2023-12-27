fun printFixedAmountDetail(amount: Int) {
    println("Discount: $amount THB\n")
}

fun printPercentageDiscountDetail(percent: Int) {
    println("Discount: $percent%\n")
}

fun printPercentageByCategoryDetail(percent: Int, category: String) {
    println("Discount: $percent% Off on $category\n")
}

fun printPointDiscountDetail(points: Int) {
    println("$points point = 1 THB\n")
}

fun printPointDiscountSummaryDetail(points: Int) {
    println("Points: $points Points\n")
}

fun printSpecialDiscountDetail(everyAmount: Int, amount: Int) {
    println("Discount: $amount THB at every $everyAmount THB\n")
}

fun printItem(amount: Int, itemName: String, price: Int) {
    println("$amount $itemName: $price THB")
}

fun printTotalPrice(total: Double) {
    println("Total Price: $total THB")
}