package com.project.segunfrancis.quickbuy.model

/**
 * Created by SegunFrancis
 */

data class Department(
    val department_id: Int,
    val name: String,
    val description: String
)

data class Category(
    val category_id: Int,
    val name: String,
    val description: String,
    val department_id: Int
)

data class Product(
    val product_id: Int,
    val name: String,
    val description: String,
    val price: String,
    val discounted_price: String,
    val thumbnail: String
)

data class ProductComplete(
    val product_id: Int,
    val name: String,
    val price: String,
    val discounted_price: String,
    val image: String,
    val image2: String,
    val thumbnail: String,
    val display: Int
)

data class ProductDetail(
    val product_id: Int,
    val name: String,
    val description: String,
    val price: String,
    val discounted_price: String,
    val image: String,
    val image2: String
)

data class ProductLocations(
    val category_id: Int,
    val category_name: String,
    val department_id: Int,
    val department_name: String
)

data class Review(
    val name: String,
    val review: String,
    val rating: Int,
    val created_on: String
)

data class Customer(
    val customer_id: Int,
    val name: String,
    val email: String,
    val address_1: String,
    val address_2: String,
    val city: String,
    val region: String,
    val postal_code: String,
    val country: String,
    val shipping_region_id: Int,
    val day_phone: String,
    val eve_phone: String,
    val mob_phone: String
)

data class CustomerRegister(
    val customer: Customer,
    val accessToken: String,
    val expires_in: String
)

data class UpdateCustomerAddress(
    var address_1: String,
    var address_2: String?,
    var city: String,
    var region: String,
    var postal_code: String,
    var country: String,
    var shipping_region_id: Int
)

data class Cart(
    val item_id: Int,
    val name: String,
    val attributes: String,
    val price: String,
    val quantity: Int,
    val subtotal: String
)

data class CartWithProduct(
    val item_id: Int,
    val name: String,
    val attributes: String,
    val price: String,
    val quantity: Int,
    val product_id: Int,
    val subtotal: String
)

data class Attribute(
    val attribute_id: Int,
    val name: String,
    val value: Int,
    val attribute_name: String,
    val attribute_value_id: String,
    val attribute_value: String
)

data class Error(
    val code: String,
    val message: String,
    val field: String
)

data class Unauthorized(
    val code: String,
    val message: String,
    val field: String
)

data class NotFound(val message: String)