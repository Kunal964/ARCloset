package com.example.data.di.model.request

import kotlinx.serialization.Serializable


@Serializable
data class LoginRequest(
    val email: String,
    val password: String

)
