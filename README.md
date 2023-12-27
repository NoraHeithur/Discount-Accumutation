# Discount-Accumutation

##### How to use
run project on `Main.kt` file

##### uncomment 
`setJoeDemo()`
##### or 
`setJudyDemo()`
##### for short setup and comment this
```
val customer = setCustomer()

val campaigns = setAvailableCampaigns()

val cart = getCartItem(setCart())

displayCampaignCoupons(campaigns, cart)

calculateDiscount(customer, cart) { totalPrice ->
  println("Items in cart:")
  repeat(cart.items.size) { index ->
    printItem(cart.items[index].amount, cart.items[index].product, cart.items[index].totalItemPrice)
  }
  printTotalPrice(totalPrice)
}
```

##### For fully input
##### Uncomment
```
val customer = setCustomer()

val campaigns = setAvailableCampaigns()

val cart = getCartItem(setCart())

displayCampaignCoupons(campaigns, cart)

calculateDiscount(customer, cart) { totalPrice ->
  println("Items in cart:")
  repeat(cart.items.size) { index ->
    printItem(cart.items[index].amount, cart.items[index].product, cart.items[index].totalItemPrice)
  }
  printTotalPrice(totalPrice)
}
```
##### and comment
`setJoeDemo()` and `setJudyDemo()`
