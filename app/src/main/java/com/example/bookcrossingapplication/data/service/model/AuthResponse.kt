package com.example.bookcrossingapplication.data.service.model

import com.example.bookcrossingapplication.domain.Token
import com.example.bookcrossingapplication.domain.User
import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(
    val user: User,
    val token: Token
)
