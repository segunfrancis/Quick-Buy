package com.project.segunfrancis.quickbuy.dataSource.remote

import com.project.segunfrancis.quickbuy.model.*
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by SegunFrancis
 */
interface ItemService {

    /* DEPARTMENTS */
    @GET("departments")
    fun departments(): Call<List<Department>>

    @GET("departments/{department_id}")
    fun getDepartments(department_id: Int): Call<Department>

    /* CATEGORIES */
    @GET("categories")
    fun categories(): Call<Category>

    @GET("categories/{category_id}")
    fun getCategories(category_id: Int): Call<Category>

    @GET("categories/inProduct/{product_id}")
    fun getProductCategory(product_id: Int): Call<Category>

    @GET("categories/inDepartment/{department_id}")
    fun getDepartmentCategory(department_id: Int): Call<Department>

    /* ATTRIBUTES */
    @GET("attributes")
    fun attributes(): Call<Attribute>

    @GET("attributes/{attribute_id}")
    fun getAttributes(attribute_id: Int): Call<List<Attribute>>

    @GET("attributes/values/{attribute_id}")
    fun getValuesAttributeFromAttribute(attribute_id: Int): Call<Attribute>

    @GET("attributes/inProduct/{product_id}")
    fun getAttributesWithProductId(product_id: Int): Call<List<Attribute>>

    /* PRODUCTS */
    @GET("products")
    fun products(): Call<ProductBaseResponse>

    @GET("products/search")
    fun searchProducts(@Query("query_string") query: String): Call<ProductBaseResponse>

    @GET("products/{product_id}")
    fun getProductByID(product_id: Int): Call<ProductComplete>

    @GET("products/inCategory/{category_id}")
    fun getProductsInCategory(category_id: Int): Call<ProductBaseResponse>

    @GET("products/inDepartment/{department_id}")
    fun getProductsInDepartment(department_id: Int): Call<ProductBaseResponse>

    @GET("products/{product_id}/details")
    fun getProductDetails(product_id: Int): Call<ProductDetail>

    @GET("products/{product_id}/locations")
    fun getProductLocation(product_id: Int): Call<ProductLocations>

    @GET("products/{product_id}/reviews")
    fun getProductReview(product_id: Int): Call<Review>

    @POST("products/{product_id}/reviews")
    fun postReview(product_id: Int, review: String, rating: Int): Call<Void>

    /* CUSTOMERS */
    @PUT("customer")
    fun updateCustomer(
        name: String,
        email: String,
        password: String?,
        day_phone: String?,
        eve_phone: String?,
        mob_phone: String?
    ): Call<Customer>

    @GET("customer")
    fun getCustomerById(@Header("access_token") token: String): Call<Customer>

    @POST("customers")
    fun registerCustomer(name: String, email: String, password: String): Call<CustomerRegister>

    @POST("customers/login")
    fun signInCustomer(email: String, password: String): Call<CustomerRegister>

    @POST("customers/facebook")
    fun signInCustomerFacebook(access_token: String): Call<CustomerRegister>

    @PUT("customers/address")
    fun updateCustomerAddress(customerAddress: UpdateCustomerAddress): Call<Customer>

    @PUT("customers/creditCard")
    fun updateCustomerCardDetails(creditCard: String): Call<Customer>
}