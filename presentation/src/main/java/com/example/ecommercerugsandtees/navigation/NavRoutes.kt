package com.example.ecommercerugsandtees.navigation


import com.example.ecommercerugsandtees.model.UiProductModel
import kotlinx.serialization.Serializable

@Serializable
object HomeScreen

@Serializable
object CartScreen

@Serializable
object ProfileScreen

@Serializable
data class ProductDetails(val product: UiProductModel)

@Serializable
object CartSummaryScreen

@Serializable
data class UserAddressRoute(val userAddressWrapper: UserAddressRouteWrapper)