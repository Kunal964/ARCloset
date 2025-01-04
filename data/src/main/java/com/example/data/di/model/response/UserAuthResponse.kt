package com.example.data.di.model.response

import kotlinx.serialization.Serializable

@Serializable
data class UserAuthResponse(
    val `data`: UserResponse,
    val msg: String
)
