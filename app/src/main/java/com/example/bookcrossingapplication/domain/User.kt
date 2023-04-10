package com.example.bookcrossingapplication.domain

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int,
    val login: String,
    val name: String,
    val photoUrl: String,
    val telegramLink: String? = null,
    val whatsappLink: String? = null,
)