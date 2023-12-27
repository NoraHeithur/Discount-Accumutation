package model.product

import module.product.setProductCategory

data class ProductModel(
    val name: String,
    val price: Int,
    val category: ProductCategory = setProductCategory()
)
