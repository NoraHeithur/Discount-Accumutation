package module

import model.customer.CustomerModel

fun setCustomer(): CustomerModel {
    print("name: ")
    val name = readln()

    print("available point: ")
    val point = readln().toInt()
    return CustomerModel(name = name, point = point)
}