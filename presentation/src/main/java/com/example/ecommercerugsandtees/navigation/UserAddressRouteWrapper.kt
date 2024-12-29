package com.example.ecommercerugsandtees.navigation

import android.os.Parcelable
import com.example.ecommercerugsandtees.model.UserAddress
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class UserAddressRouteWrapper(
    val userAddress: UserAddress?
) : Parcelable
