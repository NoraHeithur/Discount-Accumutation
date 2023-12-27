package module.product

import model.product.ProductCategory

fun setProductCategory(): ProductCategory {
    println("Enter number to set category of product")
    println("1: Clothing, 2: Accessories, 3: Electronics, other number: Others")
    print("category: ")
    val category = readln().toInt()
    return when(category) {
        1 -> ProductCategory.CLOTHING
        2 -> ProductCategory.ACCESSORIES
        3 -> ProductCategory.ELECTRONICS
        else -> ProductCategory.OTHERS
    }
}

fun setDemoClothingCategory(): ProductCategory {
    return ProductCategory.CLOTHING
}

fun setDemoAccessoriesCategory(): ProductCategory {
    return ProductCategory.ACCESSORIES
}

fun setDemoElectronicsCategory(): ProductCategory {
    return ProductCategory.ELECTRONICS
}