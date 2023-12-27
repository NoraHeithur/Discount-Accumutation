package module.cart

import model.item.ItemModel
import model.product.ProductCategory
import model.product.ProductModel

fun setCart(): List<ItemModel> {
    val itemsInTheCart = mutableListOf<ItemModel>()
    println("-----------------------------------------")
    println("Your shopping cart")
    println("Enter list of item in your the cart")
    do {
        println("Add Item (type -1 to finish)")
        print("name: ")
        val itemName = readln()

        when(itemName) {
            "-1" -> {}
            else -> {
                print("price: ")
                val price = readln().toInt()

                val product = ProductModel(
                    name = itemName,
                    price = price
                )

                print("amount: ")
                val amount = readln().toInt()

                val item = ItemModel(
                    amount = amount,
                    product = product.name,
                    category = product.category,
                    totalItemPrice = product.price * amount
                )

                itemsInTheCart.add(item)
            }
        }

        println()
    } while (itemName != "-1")
    return itemsInTheCart
}

fun setDemoCart(): List<ItemModel> {
    val itemsInTheCart = mutableListOf<ItemModel>()
    val product1 = ProductModel("T-Shirt", 350, ProductCategory.CLOTHING)
    val product2 = ProductModel("Hoodie", 250, ProductCategory.CLOTHING)
    val product3 = ProductModel("Watch", 230, ProductCategory.ACCESSORIES)
    val product4 = ProductModel("Bag", 640, ProductCategory.ACCESSORIES)

    val item1 = ItemModel(
        amount = 1, product = product1.name, category = product1.category
    ).apply {
        this.totalItemPrice = calculateTotalPrice(product1.price)
    }

    val item2 = ItemModel(
        amount = 1, product = product2.name, category = product2.category
    ).apply {
        this.totalItemPrice = calculateTotalPrice(product2.price)
    }

    val item3 = ItemModel(
        amount = 1, product = product3.name, category = product3.category
    ).apply {
        this.totalItemPrice = calculateTotalPrice(product3.price)
    }

    val item4 = ItemModel(
        amount = 1, product = product4.name, category = product4.category
    ).apply {
        this.totalItemPrice = calculateTotalPrice(product4.price)
    }

    itemsInTheCart.add(item1)
    itemsInTheCart.add(item2)
    itemsInTheCart.add(item3)
//    itemsInTheCart.add(item4)

    return itemsInTheCart
}

fun setDemoCart2(): List<ItemModel> {
    val itemsInTheCart = mutableListOf<ItemModel>()
    val product1 = ProductModel("Gold Ring", 300000, ProductCategory.ACCESSORIES)
    val product2 = ProductModel("Dragon pendent", 10000, ProductCategory.ACCESSORIES)

    val item1 = ItemModel(
        amount = 2, product = product1.name, category = product1.category
    ).apply {
        this.totalItemPrice = calculateTotalPrice(product1.price)
    }

    val item2 = ItemModel(
        amount = 5, product = product2.name, category = product2.category
    ).apply {
        this.totalItemPrice = calculateTotalPrice(product2.price)
    }

    itemsInTheCart.add(item1)
    itemsInTheCart.add(item2)

    return itemsInTheCart
}